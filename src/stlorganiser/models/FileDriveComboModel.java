/*
 * 
 */
package stlorganiser.models;

import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * ComboModel representing the file drives (or system roots)
 * @author Jean-Christophe Chatelain
 */
public class FileDriveComboModel extends AbstractListModel implements ComboBoxModel  {
    Object selection = null;
    @Override
    public int getSize() {
        return File.listRoots().length;
    }

    @Override
    public Object getElementAt(int index) {
        return File.listRoots()[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = anItem; // to select and register an
    }

    @Override
    public Object getSelectedItem() {
        return selection; // to add the selection to the combo box
    }
    
}
