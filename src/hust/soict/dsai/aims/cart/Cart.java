package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Still keeping this limit as a safeguard
    private ArrayList<Media> itemsOrdered = new ArrayList<>(); // Use ArrayList to store Media objects

    // Method to add Media to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("Doan Nhat Quang - 5911 - The cart is full, cannot add more items.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Doan Nhat Quang - 5911 - The media has been added to the cart.");
        }
    }

    // Method to remove Media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Doan Nhat Quang - 5911 - The media has been removed from the cart.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - The media was not found in the cart.");
        }
    }

    // Method to calculate the total cost of the cart
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost(); // Each Media has a getCost() method
        }
        return total;
    }

    // Method to print Cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Doan Nhat Quang - 5911 - Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("Doan Nhat Quang - 5911 - Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Search by ID
    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) { // Assuming getId() exists in Media
                return media;
            }
        }
        return null;
    }

    // Search by Title
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) { // Assuming isMatch() exists in Media
                return media;
            }
        }
        return null;
    }
    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }
    public void filterMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose filtering option:");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the scanner buffer

        switch (choice) {
            case 1 -> {
                System.out.print("Enter media ID to filter: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                boolean found = false;

                for (Media media : itemsOrdered) {
                    if (media.getId() == id) {
                        System.out.println(media);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No media found with the given ID.");
                }
            }
            case 2 -> {
                System.out.print("Enter media title to filter: ");
                String title = scanner.nextLine();
                boolean found = false;

                for (Media media : itemsOrdered) {
                    if (media.isMatch(title)) {
                        System.out.println(media);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No media found with the given title.");
                }
            }
            default -> System.out.println("Invalid choice! No filtering performed.");
        }
    }
    public void sortMedia() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting option:");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the scanner buffer

        switch (choice) {
            case 1 -> {
                Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
                System.out.println("The cart has been sorted by title.");
                
            }
            case 2 -> {
                Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
                System.out.println("The cart has been sorted by cost.");
            }
            default -> System.out.println("Invalid choice! No sorting performed.");
        }
        print();
    }

}
