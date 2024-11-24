package Aims;

public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Action", "Jungle", 20.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Adventure", "Cinderella", 15.0f);

        System.out.println("Doan Nhat Quang - 5911 - DVD 1 ID: " + dvd1.getId()); // Output: DVD 1 ID: 1
        System.out.println("Doan Nhat Quang - 5911 - DVD 2 ID: " + dvd2.getId()); // Output: DVD 2 ID: 2
        System.out.println("Doan Nhat Quang - 5911 - Total DVDs: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
        
        // Create new dvd objects and add them to the cart
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//        anOrder.addDigitalVideoDisc(dvd1);
//
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
//        anOrder.addDigitalVideoDisc(dvd2);
//
//        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
//        anOrder.addDigitalVideoDisc(dvd3);
//
//        // Print total cost of the items in the cart
//        System.out.println("Doan Nhat Quang - 5911 - Total Cost is: " + anOrder.totalCost());
//
//        // Test removing a disc that exists in the cart
//        System.out.println("Doan Nhat Quang - 5911 - Removing 'Star Wars' from the cart.");
//        anOrder.removeDigitalVideoDisc(dvd2);
//
//        // Print total cost after removal
//        System.out.println("Doan Nhat Quang - 5911 - Total Cost after removal is: " + anOrder.totalCost());
//
//        // Test removing a disc that does not exist in the cart
//        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Nonexistent Movie", "Genre", "Director", 100, 10.0f);
//        System.out.println("Doan Nhat Quang - 5911 - Attempting to remove a disc not in the cart.");
//        anOrder.removeDigitalVideoDisc(dvd4);
    }
}