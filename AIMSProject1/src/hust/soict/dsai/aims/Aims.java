package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu cho Store
        initializeStore();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> System.out.println("Doan Nhat Quang - 5911 - Exiting AIMS. Goodbye!");
                default -> System.out.println("Doan Nhat Quang - 5911 - Invalid choice! Please choose a valid option.");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("Doan Nhat Quang - 5911 - AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Doan Nhat Quang - 5911 - Please choose a number: 0-1-2-3: ");
    }

    private static void viewStore() {
        System.out.println("\nDoan Nhat Quang - 5911 - STORE INVENTORY:");
        store.printStore();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> seeCurrentCart();
                case 0 -> System.out.println("Doan Nhat Quang - 5911 - Returning to main menu...");
                default -> System.out.println("Doan Nhat Quang - 5911 - Invalid choice! Please choose a valid option.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Doan Nhat Quang - 5911 - Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Doan Nhat Quang - 5911 - Please choose a number: 0-1-2-3-4: ");
    }

    private static void seeMediaDetails() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println("\nMedia Details: ");
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Media with the given title not found.");
        }
    }

    private static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("Doan Nhat Quang - 5911 - Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Doan Nhat Quang - 5911 - Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> {
                    if (media instanceof Playable playable) {
                        playable.play();
                    } else {
                        System.out.println("Doan Nhat Quang - 5911 - This media cannot be played.");
                    }
                }
                case 0 -> System.out.println("Doan Nhat Quang - 5911 - Returning to store menu...");
                default -> System.out.println("Doan Nhat Quang - 5911 - Invalid choice! Please choose a valid option.");
            }
        } while (choice != 0);
    }

    private static void addMediaToCart() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Added " + media.getTitle() + " to cart.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Media with the given title not found.");
        }
    }

    private static void playMedia() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("Doan Nhat Quang - 5911 - This media cannot be played.");
        }
    }

    private static void updateStore() {
        System.out.println("Doan Nhat Quang - 5911 - Update store: ");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        switch (choice) {
            case 1 -> addMediaToStore();
            case 2 -> removeMediaFromStore();
            default -> System.out.println("Doan Nhat Quang - 5911 - Invalid choice! Returning to main menu...");
        }
    }

    private static void addMediaToStore() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the new media: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = scanner.nextFloat();
        scanner.nextLine(); // Clear buffer
        Media media = new Media(store.getNextId(), title, category, cost) {};
        store.addMedia(media);
        System.out.println("Doan Nhat Quang - 5911 - Media added to store.");
    }

    private static void removeMediaFromStore() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Media with the given title not found.");
        }
    }

    private static void seeCurrentCart() {
        System.out.println("\nDoan Nhat Quang - 5911 - CURRENT CART:");
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            switch (choice) {
                case 1 -> cart.filterMedia();
                case 2 -> cart.sortMedia();
                case 3 -> removeMediaFromCart();
                case 4 -> playMediaFromCart();
                case 5 -> placeOrder();
                case 0 -> System.out.println("Doan Nhat Quang - 5911 - Returning to main menu...");
                default -> System.out.println("Doan Nhat Quang - 5911 - Invalid choice! Please choose a valid option.");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Doan Nhat Quang - 5911 - Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Doan Nhat Quang - 5911 - Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void removeMediaFromCart() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Removed " + media.getTitle() + " from cart.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Media with the given title not found in cart.");
        }
    }

    private static void playMediaFromCart() {
        System.out.print("Doan Nhat Quang - 5911 - Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media instanceof Playable playable) {
            playable.play();
        } else {
            System.out.println("Doan Nhat Quang - 5911 - This media cannot be played.");
        }
    }

    private static void placeOrder() {
        System.out.println("Doan Nhat Quang - 5911 - Order placed successfully!");
        cart.emptyCart();
    }

    private static void initializeStore() {
    	store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
    	store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
    	store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new Book(4, "Harry Potter", "Fantasy", 29.99f));
        store.addMedia(new CompactDisc(5, "Best Hits 2023", "Music", "Various Artists", 15.99f, 60, "Producer A"));
    }
}
