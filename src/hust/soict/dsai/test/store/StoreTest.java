package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a store
        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", "Star Wars", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);

        // Add DVDs to the store
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Print the store's inventory
        store.printStore();

        // Remove a DVD from the store
        store.removeDVD(dvd2);

        // Try removing a DVD not in the store
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Action", "Avengers: Endgame", "Anthony Russo", 180, 29.99f);
        store.removeDVD(dvd4);

        // Try adding a duplicate DVD
        store.addDVD(dvd1);

        // Print the store's inventory after modifications
        store.printStore();
    }
}

