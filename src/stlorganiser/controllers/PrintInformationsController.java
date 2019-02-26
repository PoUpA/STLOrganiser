/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stlorganiser.controllers;

import hall.collin.christopher.stl4j.STLParser;
import hall.collin.christopher.stl4j.Triangle;
import java.io.IOException;
import static java.lang.Math.toIntExact;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteException;
import stlorganiser.db.DBUtils;
import stlorganiser.models.PrintInformations;
import stlorganiser.views.STLOrganiser;
import stlorganiser.tools.Tools;
import stlviewer.PModel;
/**
 *
 * @author Jean-Christophe Chatelain
 */
public class PrintInformationsController {
    private final STLOrganiser mainWindow;
    private DBUtils db;
    private final ArrayList<PrintInformations> printInformationsList;
    
    public PrintInformationsController() {
        this.mainWindow = new STLOrganiser();
        initListeners();
        db = new DBUtils();
        printInformationsList = db.loadPrintInformationsFromDB();
        db.close();
        for (int i = 0; i < printInformationsList.size(); i++){
            mainWindow.favoritesPanel.addToTable(printInformationsList.get(i).getTableObject());
        }
        
        
    }
    public static void main(String[] args) {
        new PrintInformationsController();
    }
    
    private void initListeners()
    {
        mainWindow.explorerPanel.customInfoPanel.setVisible(false);
        
        // File changed event
        mainWindow.explorerPanel.explorerTreeSelectionListener((e) -> {
            String selectedPath = e.getPath().getLastPathComponent().toString();
        
            if(selectedPath.toLowerCase().endsWith(".stl")){
                System.out.println("file loaded");
                mainWindow.explorerPanel.customInfoPanel.setVisible(true);
                Path stlFile = Paths.get(selectedPath);
                loadSTL(stlFile);
                
                try {
                    db = new DBUtils();
                    PrintInformations printInfos = db.getPrintInformationFromDB(Tools.getChecksum(selectedPath));
                    db.close();
                    if(printInfos!=null){
                        mainWindow.explorerPanel.setEdit();
                    }else{
                        mainWindow.explorerPanel.setCreate();
                        printInfos = new PrintInformations();
                        BasicFileAttributes attr;
                        System.out.println(stlFile);
                        attr = Files.readAttributes(stlFile, BasicFileAttributes.class);
                        printInfos.setName(stlFile.getFileName().toString());
                        printInfos.setPath(stlFile.toString());
                        printInfos.setSize(toIntExact(attr.size()));
                        printInfos.setChecksum(Tools.getChecksum(stlFile.toString()));
                        printInfos.setDescription("");
                        printInfos.setPrintTime("");
                        printInfos.setGrade(0);
                    }
                    setFileInfos(stlFile);
                    setCustomFileInfos(printInfos);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        mainWindow.explorerPanel.saveActionListener(((e) -> {
            PrintInformations printInfosToSave = getViewValues();
            try {
                addToDb(printInfosToSave);
            } catch (SQLiteException ex) {
                Logger.getLogger(PrintInformationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        
        mainWindow.explorerPanel.updateActionListener(((e) -> {
            PrintInformations printInfosToSave = getViewValues();
            try {
                updateDb(printInfosToSave);
                //mainWindow.favoritesPanel.addToTable(printInfosToSave.getTableObject());            
            } catch (SQLiteException ex) {
                Logger.getLogger(PrintInformationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        
        mainWindow.explorerPanel.deleteActionListener(((e) -> {
            PrintInformations printInfosToDelete = getViewValues();
            try {
                deleteFromDb(printInfosToDelete.getChecksum());
            } catch (SQLException ex) {
                Logger.getLogger(PrintInformationsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
    }
    
    public void deleteFromDb(Long checksum) throws SQLException{
        System.out.println("Delete...");
        PrintInformations printInfosToDelete;
        db = new DBUtils();
        printInfosToDelete = db.getPrintInformationFromDB(checksum);
        db.deleteFromDB(checksum);
        db.close();
        mainWindow.favoritesPanel.removeFromTable(printInfosToDelete.getChecksum());
        mainWindow.explorerPanel.setCreate();
    }
    
    public void updateDb(PrintInformations printInfos) throws SQLiteException{
        System.out.println("Update...");
        db = new DBUtils();
        db.updateDB(printInfos);
        db.close();
        mainWindow.favoritesPanel.removeFromTable(printInfos.getChecksum());
        mainWindow.favoritesPanel.addToTable(printInfos.getTableObject());
    }
    
    public void addToDb(PrintInformations printInfos) throws SQLiteException{
        System.out.println("Add...");
        db = new DBUtils();
        db.addToDB(printInfos);
        db.close();
        mainWindow.favoritesPanel.addToTable(printInfos.getTableObject());
        mainWindow.explorerPanel.setEdit();
    }
    
    public void loadSTL(Path stlFile){
        try {
            List<Triangle> mesh = new STLParser().parseSTLFile(stlFile);
            if(mainWindow.explorerPanel.model != null)
                mainWindow.explorerPanel.model.cleanup();			
            mainWindow.explorerPanel.model = new PModel();
            mainWindow.explorerPanel.model.setBnormstrip(true);
            mainWindow.explorerPanel.model.addtriangles(mesh);
            mainWindow.explorerPanel.canvas.rendermodel(mainWindow.explorerPanel.model, mainWindow.explorerPanel.universe);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
        }
    }
    

    private void setFileInfos(Path stlFile) throws IOException {
        BasicFileAttributes attr;
        System.out.println(stlFile);
        attr = Files.readAttributes(stlFile, BasicFileAttributes.class);
        mainWindow.explorerPanel.nameValue.setText(stlFile.getFileName().toString());
        mainWindow.explorerPanel.pathValue.setText(stlFile.toString());
        mainWindow.explorerPanel.sizeValue.setText(String.format("%s",attr.size()));
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        mainWindow.explorerPanel.crDateValue.setText(df.format(attr.creationTime().toMillis()));
        mainWindow.explorerPanel.modDateValue.setText(df.format(attr.lastModifiedTime().toMillis()));
        mainWindow.explorerPanel.crcValue.setText(String.format("%s",Tools.getChecksum(stlFile.toString())));
    }
    private void setCustomFileInfos(PrintInformations printInfos) throws IOException {
        
        mainWindow.explorerPanel.noteSlider.setValue(printInfos.getGrade());
        mainWindow.explorerPanel.descriptionTextArea.setText(printInfos.getDescription());
        mainWindow.explorerPanel.printTimeTextField.setText(printInfos.getPrintTime());
        mainWindow.explorerPanel.supportCheckbox.setSelected(printInfos.isNeedSupport());
    }
    
    private PrintInformations getViewValues(){
        PrintInformations printInfos = new PrintInformations();
        printInfos.setName(mainWindow.explorerPanel.nameValue.getText());
        printInfos.setPath(mainWindow.explorerPanel.pathValue.getText());
        printInfos.setSize(Integer.parseInt(mainWindow.explorerPanel.sizeValue.getText()));
        printInfos.setChecksum(Long.parseLong(mainWindow.explorerPanel.crcValue.getText()));
        printInfos.setDescription(mainWindow.explorerPanel.descriptionTextArea.getText());
        printInfos.setPrintTime(mainWindow.explorerPanel.printTimeTextField.getText());
        printInfos.setGrade(mainWindow.explorerPanel.noteSlider.getValue());
        printInfos.setNeedSupport(mainWindow.explorerPanel.supportCheckbox.isSelected());
        return printInfos;
        
    }
}
