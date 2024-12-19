package hust.soict.dsai.aims.screen;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCDStoreScreen extends AddItemToStoreScreen {
    private JTextField artistField;
    private JTextField numberOfTracksField;
    public AddCDStoreScreen(Store store) {
        super(store);
    }
    @Override
    protected void addSpecificFields() {
        this.add(new JLabel("Quang - 5911 - Enter artist: "));
        artistField = createTextField("artist");
        this.add(artistField);

        this.add(new JLabel("Quang - 5911 - Number of tracks: "));
        numberOfTracksField = createTextField("numberOfTracks");
        this.add(numberOfTracksField);
    }
    @Override
    protected String getScreenTitle() {
        return "Quang - 5911 - Add CD";
    }
    @Override
    protected void addItemToStore() {
        try {
            String title = ((JTextField) this.getContentPane().getComponent(1)).getText();
            String category = ((JTextField) this.getContentPane().getComponent(3)).getText();
            float cost = Float.parseFloat(((JTextField) this.getContentPane().getComponent(5)).getText());
            String artist = artistField.getText();
            int numberOfTracks = Integer.parseInt(numberOfTracksField.getText());
            CompactDisc cd = new CompactDisc(0, title, category, artist, cost, numberOfTracks, "");
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "Quang - 5911 - CD added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quang - 5911 - Invalid input! Please check your fields.");
        }
    }
}


