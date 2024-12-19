package hust.soict.dsai.aims.screen;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDVDStoreScreen extends AddItemToStoreScreen {
    public AddDVDStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected void addSpecificFields() {
        // No additional fields for DVD in this example
    }

    @Override
    protected String getScreenTitle() {
        return "Quang - 5911 - Add DVD";
    }

    @Override
    protected void addItemToStore() {
        try {
            String title = ((JTextField) this.getContentPane().getComponent(1)).getText();
            String category = ((JTextField) this.getContentPane().getComponent(3)).getText();
            float cost = Float.parseFloat(((JTextField) this.getContentPane().getComponent(5)).getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, "", 0, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "Quang - 5911 - DVD added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quang - 5911 - Invalid input! Please check your fields.");
        }
    }
}

