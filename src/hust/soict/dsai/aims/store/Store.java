package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore; // Dynamic list for Media items
    private static int nextId = 1; // Static variable to track the next unique ID

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Method to add a Media item to the store
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Doan Nhat Quang - 5911 - Media \"" + media.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(media);
            System.out.println("Doan Nhat Quang - 5911 - Media \"" + media.getTitle() + "\" has been added to the store.");
        }
    }

    // Method to remove a Media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Doan Nhat Quang - 5911 - Media \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Media \"" + media.getTitle() + "\" was not found in the store.");
        }
    }

    // Method to display all Media items in the store
    public void printStore() {
        System.out.println("*******************STORE*******************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Doan Nhat Quang - 5911 - The store is currently empty.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Items in the store:");
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*******************************************");
    }
    public int getNextId() {
        return nextId++; // Increment and return the next unique ID
    }
    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) { // Assuming getId() exists in Media
                return media;
            }
        }
        return null;
    }

    // Search by Title
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) { // Assuming isMatch() exists in Media
                return media;
            }
        }
        return null;
    }
}
