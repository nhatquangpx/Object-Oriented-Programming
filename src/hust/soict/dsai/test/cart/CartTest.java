package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Create instances of Media
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie 1", "Action", "Director 1", 120, 20.5f);
        CompactDisc cd = new CompactDisc(1, "Album 1", "Music", "Artist 1", 15.0f, 50, "Director 2");
        Book book = new Book(2, "Book 1", "Fiction", 10.0f);

        // Add media to the cart
        cart.addMedia(dvd);
        cart.addMedia(cd);
        cart.addMedia(book);

        // Print the cart
        cart.print();

        // Search and remove
        Media found = cart.searchByTitle("Book 1");
        if (found != null) {
            cart.removeMedia(found);
        }

        // Print the cart after removal
        cart.print();
    }
}
