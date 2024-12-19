package hust.soict.dsai.aims.screen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

public class AddBookStoreScreen extends AddItemToStoreScreen {
    private JTextField authorsField;

    public AddBookStoreScreen(Store store) {
        super(store);
    }
    @Override
    protected void addSpecificFields() {
        this.add(new JLabel("Quang - 5911 - Enter authors: "));
        authorsField = createTextField("authors");
        this.add(authorsField);
    }
    @Override
    protected String getScreenTitle() {
        return "Quang - 5911 - Add Book";
    }
    @Override
    protected void addItemToStore() {
        try {
            String title = ((JTextField) this.getContentPane().getComponent(1)).getText();
            String category = ((JTextField) this.getContentPane().getComponent(3)).getText();
            float cost = Float.parseFloat(((JTextField) this.getContentPane().getComponent(5)).getText());
            String[] authors = authorsField.getText().split(",");

            Book book = new Book(0, title, category, cost);
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Quang - 5911 - Book added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quang - 5911 - Invalid input! Please check your fields.");
        }
    }
}


