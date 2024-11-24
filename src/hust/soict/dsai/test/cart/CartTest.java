package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart cart = new Cart();

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animation", "The Lion King", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Science Fiction", "Star Wars", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation", "Aladin", 18.99f);

        // Thêm DVD vào giỏ hàng
        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // In thông tin giỏ hàng
        cart.print();

        // Tìm kiếm DVD theo ID
        int searchId = 2; // ID cần tìm
        DigitalVideoDisc foundById = cart.searchById(searchId);
        if (foundById != null) {
            System.out.println("Doan Nhat Quang - 5911 - Found by ID: " + foundById.toString());
        } else {
            System.out.println("Doan Nhat Quang - 5911 - No DVD found with ID: " + searchId);
        }

        String searchTitle = "Star Wars"; 
        DigitalVideoDisc foundByTitle = cart.searchByTitle(searchTitle);
        if (foundByTitle != null) {
            System.out.println("Doan Nhat Quang - 5911 - Found by Title: " + foundByTitle.toString());
        } else {
            System.out.println("Doan Nhat Quang - 5911 - No DVD found with title: " + searchTitle);
        }
        
    }
    
}
