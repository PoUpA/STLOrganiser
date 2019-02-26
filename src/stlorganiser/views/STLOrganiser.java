/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stlorganiser.views;

import stlorganiser.views.ExplorerPanel;
import stlorganiser.views.FavoritesPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

/**
 *
 * @author Jean-Christophe Chatelain
 */
public class STLOrganiser extends JFrame implements ActionListener, WindowListener {
    public JToolBar toolbar;
    public ExplorerPanel explorerPanel;
    public FavoritesPanel favoritesPanel;
    public JPanel settingsPanel;
    /**
     * @param args the command line arguments
     */
    public STLOrganiser() throws HeadlessException {
        super("STL Organiser");
        setDefaultCloseOperation(EXIT_ON_CLOSE);		
        createMainWindow();
    }
    
    
    
    public void createMainWindow(){
        setPreferredSize(new Dimension(1920, 1080));
        toolbar = new JToolBar();
        explorerPanel = new ExplorerPanel();
        favoritesPanel = new FavoritesPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Explorateur",explorerPanel);
        tabs.add("Favoris",favoritesPanel);
        getContentPane().add(tabs);
        pack();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
