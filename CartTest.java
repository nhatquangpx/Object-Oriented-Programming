package Aims;

public class CartTest {
    public static void main(String[] args) {
        // Tạo đối tượng Cart
        Cart cart = new Cart();

        // Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers: Endgame", "Action", "Russo Brothers", 181, 29.99f);

        // 1. Kiểm tra phương thức thêm 1 DVD
        System.out.println("\n=== Adding a single DVD ===");
        cart.addDigitalVideoDisc(dvd1);

        // 2. Kiểm tra phương thức thêm danh sách DVD (mảng)
        System.out.println("\n=== Adding multiple DVDs (array) ===");
        DigitalVideoDisc[] dvdArray = {dvd2, dvd3};
        cart.addDigitalVideoDisc(dvdArray);

        // 3. Kiểm tra phương thức thêm 2 DVD
        System.out.println("\n=== Adding two DVDs ===");
        cart.addDigitalVideoDisc(dvd4, dvd1);

        // 4. In giỏ hàng sau khi thêm các DVD
//        System.out.println("\n=== Cart after adding DVDs ===");
//        cart.printCart();
    }
}

