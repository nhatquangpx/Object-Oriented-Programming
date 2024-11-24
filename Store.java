package Aims;

import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore; // Dynamic list for flexibility

    // Constructor
    public Store() {
        itemsInStore = new ArrayList<>();
    }

    // Method to add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)) {
            System.out.println("Doan Nhat Quang - 5911 - DVD \"" + dvd.getTitle() + "\" is already in the store.");
        } else {
            itemsInStore.add(dvd);
            System.out.println("Doan Nhat Quang - 5911 - DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        }
    }

    // Method to remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.contains(dvd)) {
            itemsInStore.remove(dvd);
            System.out.println("Doan Nhat Quang - 5911 - DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - DVD \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }

    // Method to display all DVDs in the store
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
}

