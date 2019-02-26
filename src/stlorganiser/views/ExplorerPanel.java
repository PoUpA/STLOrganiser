/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stlorganiser.views;

import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import hall.collin.christopher.stl4j.STLParser;
import hall.collin.christopher.stl4j.Triangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.TreeSelectionListener;
import stlorganiser.models.FileDriveComboModel;
import stlorganiser.models.FileTreeModel;
import stlorganiser.tools.Tools;

import stlviewer.PCanvas3D;
import stlviewer.PModel;
/**
 * Main view with complete file browser, stl renderer and file information fields
 * @author Jean-Christophe Chatelain
 */
public class ExplorerPanel extends javax.swing.JPanel {

    public PCanvas3D canvas;
    public SimpleUniverse universe;
    public PModel model;
    /**
     * Creates new form ExplorerPanel
     */
    public ExplorerPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainSplitPane = new javax.swing.JSplitPane();
        rightContainerPanel = new javax.swing.JPanel();
        rightContainerSplitPane = new javax.swing.JSplitPane();
        canvasPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        fileInfoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        crcLabel = new javax.swing.JLabel();
        crDateLabel = new javax.swing.JLabel();
        modDateLabel = new javax.swing.JLabel();
        nameValue = new javax.swing.JLabel();
        pathValue = new javax.swing.JLabel();
        sizeValue = new javax.swing.JLabel();
        crcValue = new javax.swing.JLabel();
        crDateValue = new javax.swing.JLabel();
        modDateValue = new javax.swing.JLabel();
        fileInfoLabel = new javax.swing.JLabel();
        customInfoPanel = new javax.swing.JPanel();
        noteSlider = new javax.swing.JSlider();
        noteLabel = new javax.swing.JLabel();
        noteValue = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        printTimeLabel = new javax.swing.JLabel();
        printTimeTextField = new javax.swing.JTextField();
        supportCheckbox = new javax.swing.JCheckBox();
        leftContainerPanel = new javax.swing.JPanel();
        drivesComboBox = new javax.swing.JComboBox<>();
        explorerScrollPane = new javax.swing.JScrollPane();
        explorerTree = new javax.swing.JTree();

        setPreferredSize(new java.awt.Dimension(1920, 1080));

        mainSplitPane.setDividerLocation(300);

        rightContainerSplitPane.setDividerLocation(700);
        rightContainerSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        canvas = new PCanvas3D(config);
        universe = new SimpleUniverse(canvas);
        canvas.initcanvas(universe);

        javax.swing.GroupLayout canvasPanelLayout = new javax.swing.GroupLayout(canvasPanel);
        canvasPanel.setLayout(canvasPanelLayout);
        canvasPanelLayout.setHorizontalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1612, Short.MAX_VALUE)
        );
        canvasPanelLayout.setVerticalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );

        rightContainerSplitPane.setTopComponent(canvasPanel);
        canvasPanelLayout.setHorizontalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.Alignment.TRAILING)

        );
        canvasPanelLayout.setVerticalGroup(
            canvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        nameLabel.setText("Nom :");

        pathLabel.setText("Chemin :");

        sizeLabel.setText("Taille :");

        crcLabel.setText("CRC :");

        crDateLabel.setText("Date de création :");

        modDateLabel.setText("Date de modification :");

        fileInfoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fileInfoLabel.setText("Informations sur le fichier :");

        javax.swing.GroupLayout fileInfoPanelLayout = new javax.swing.GroupLayout(fileInfoPanel);
        fileInfoPanel.setLayout(fileInfoPanelLayout);
        fileInfoPanelLayout.setHorizontalGroup(
            fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(pathLabel)
                    .addComponent(sizeLabel)
                    .addComponent(crcLabel)
                    .addComponent(crDateLabel)
                    .addComponent(modDateLabel))
                .addGap(33, 33, 33)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pathValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crcValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crDateValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modDateValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(fileInfoPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(fileInfoLabel)
                .addGap(0, 168, Short.MAX_VALUE))
        );
        fileInfoPanelLayout.setVerticalGroup(
            fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileInfoPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(fileInfoLabel)
                .addGap(18, 18, 18)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel)
                    .addComponent(pathValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crcLabel)
                    .addComponent(crcValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crDateLabel)
                    .addComponent(crDateValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modDateLabel)
                    .addComponent(modDateValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customInfoPanel.setEnabled(false);

        noteSlider.setMaximum(10);
        noteSlider.setToolTipText("");
        noteSlider.setValue(0);
        noteSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                noteSliderStateChanged(evt);
            }
        });

        noteLabel.setText("Note :");

        noteValue.setText("0");

        descriptionLabel.setText("Description :");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        saveButton.setText("Sauvegarder");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Effacer");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Mettre à jour");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        printTimeLabel.setText("Temps d'impression :");

        printTimeTextField.setText("jTextField1");
        printTimeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printTimeTextFieldActionPerformed(evt);
            }
        });

        supportCheckbox.setText("Besoin de supports ?");
        supportCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supportCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout customInfoPanelLayout = new javax.swing.GroupLayout(customInfoPanel);
        customInfoPanel.setLayout(customInfoPanelLayout);
        customInfoPanelLayout.setHorizontalGroup(
            customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton))
                    .addGroup(customInfoPanelLayout.createSequentialGroup()
                        .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel)
                            .addGroup(customInfoPanelLayout.createSequentialGroup()
                                .addComponent(noteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noteValue))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(printTimeLabel)
                            .addComponent(printTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supportCheckbox))))
                .addGap(594, 594, 594))
        );
        customInfoPanelLayout.setVerticalGroup(
            customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customInfoPanelLayout.createSequentialGroup()
                .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customInfoPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(customInfoPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noteLabel)
                            .addComponent(noteValue)
                            .addComponent(printTimeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(printTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(customInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descriptionLabel)
                            .addComponent(supportCheckbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(fileInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(customInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fileInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(customInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rightContainerSplitPane.setRightComponent(infoPanel);

        javax.swing.GroupLayout rightContainerPanelLayout = new javax.swing.GroupLayout(rightContainerPanel);
        rightContainerPanel.setLayout(rightContainerPanelLayout);
        rightContainerPanelLayout.setHorizontalGroup(
            rightContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightContainerPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(rightContainerSplitPane))
        );
        rightContainerPanelLayout.setVerticalGroup(
            rightContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightContainerSplitPane)
        );

        mainSplitPane.setRightComponent(rightContainerPanel);

        drivesComboBox.setModel(new FileDriveComboModel());
        drivesComboBox.setSelectedIndex(0);
        drivesComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drivesComboBoxItemStateChanged(evt);
            }
        });
        drivesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drivesComboBoxActionPerformed(evt);
            }
        });

        System.out.println(drivesComboBox.getSelectedItem().toString());
        explorerTree.setModel(new FileTreeModel((File)drivesComboBox.getSelectedItem()));
        drivesComboBox.setSelectedItem(drivesComboBox.getItemAt(0));
        explorerTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                explorerTreeValueChanged(evt);
            }
        });
        explorerScrollPane.setViewportView(explorerTree);

        javax.swing.GroupLayout leftContainerPanelLayout = new javax.swing.GroupLayout(leftContainerPanel);
        leftContainerPanel.setLayout(leftContainerPanelLayout);
        leftContainerPanelLayout.setHorizontalGroup(
            leftContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(explorerScrollPane)
            .addComponent(drivesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        leftContainerPanelLayout.setVerticalGroup(
            leftContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftContainerPanelLayout.createSequentialGroup()
                .addComponent(drivesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(explorerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE))
        );

        mainSplitPane.setLeftComponent(leftContainerPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void explorerTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_explorerTreeValueChanged
        
    }//GEN-LAST:event_explorerTreeValueChanged

    private void drivesComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drivesComboBoxItemStateChanged
        explorerTree.setModel(new FileTreeModel(new File(evt.getItem().toString())));
    }//GEN-LAST:event_drivesComboBoxItemStateChanged

    private void drivesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drivesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drivesComboBoxActionPerformed

    private void noteSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_noteSliderStateChanged
        JSlider source = (JSlider)evt.getSource();
        noteValue.setText(String.format("%d",source.getValue()));
    }//GEN-LAST:event_noteSliderStateChanged

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void printTimeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printTimeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printTimeTextFieldActionPerformed

    private void supportCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supportCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supportCheckboxActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    public void explorerTreeSelectionListener(TreeSelectionListener listener)
    {
        explorerTree.addTreeSelectionListener(listener);
    }
    
    public void saveActionListener(ActionListener listener)
    {
        saveButton.addActionListener(listener);
    }
    public void deleteActionListener(ActionListener listener)
    {
        deleteButton.addActionListener(listener);
    }
    public void updateActionListener(ActionListener listener)
    {
        updateButton.addActionListener(listener);
    }
    
    public void setCreate(){
        saveButton.setVisible(true);
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
    }
    public void setEdit(){
        saveButton.setVisible(false);
        updateButton.setVisible(true);
        deleteButton.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel canvasPanel;
    public javax.swing.JLabel crDateLabel;
    public javax.swing.JLabel crDateValue;
    public javax.swing.JLabel crcLabel;
    public javax.swing.JLabel crcValue;
    public javax.swing.JPanel customInfoPanel;
    public javax.swing.JButton deleteButton;
    public javax.swing.JLabel descriptionLabel;
    public javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JComboBox<String> drivesComboBox;
    public javax.swing.JScrollPane explorerScrollPane;
    public javax.swing.JTree explorerTree;
    public javax.swing.JLabel fileInfoLabel;
    public javax.swing.JPanel fileInfoPanel;
    public javax.swing.JPanel infoPanel;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel leftContainerPanel;
    public javax.swing.JSplitPane mainSplitPane;
    public javax.swing.JLabel modDateLabel;
    public javax.swing.JLabel modDateValue;
    public javax.swing.JLabel nameLabel;
    public javax.swing.JLabel nameValue;
    public javax.swing.JLabel noteLabel;
    public javax.swing.JSlider noteSlider;
    public javax.swing.JLabel noteValue;
    public javax.swing.JLabel pathLabel;
    public javax.swing.JLabel pathValue;
    public javax.swing.JLabel printTimeLabel;
    public javax.swing.JTextField printTimeTextField;
    public javax.swing.JPanel rightContainerPanel;
    public javax.swing.JSplitPane rightContainerSplitPane;
    public javax.swing.JButton saveButton;
    public javax.swing.JLabel sizeLabel;
    public javax.swing.JLabel sizeValue;
    public javax.swing.JCheckBox supportCheckbox;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
