package hust.soict.dsai.test.polymorphism;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        // Tạo danh sách Media
        List<Media> mediaList = new ArrayList<>();

        // Tạo các đối tượng Media
        mediaList.add(new Book(1, "The Alchemist", "Fiction", 9.99f));
        mediaList.add(new Book(2, "The Alchemist", "Fiction", 15.99f));
        mediaList.add(new Book(3, "Harry Potter", "Fantasy", 19.99f));
        mediaList.add(new Disc(4, "Inception", "Sci-Fi", 12.99f, 148, "Christopher Nolan"));
        mediaList.add(new CompactDisc(5, "Best of 2023", "Music", "Various Artists", 9.99f, 80, "Producer A"));

        // In danh sách ban đầu
        System.out.println("Doan Nhat Quang - 5911 - Before sorting:");
        for (Media media : mediaList) {
            System.out.println(media);
        }

        // Sắp xếp theo Title -> Cost
        Collections.sort(mediaList, Media.COMPARE_BY_TITLE_COST);
        System.out.println("\nDoan Nhat Quang - 5911 - After sorting by Title -> Cost:");
        for (Media media : mediaList) {
            System.out.println(media);
        }

        // Sắp xếp theo Cost -> Title
        Collections.sort(mediaList, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nDoan Nhat Quang - 5911 - After sorting by Cost -> Title:");
        for (Media media : mediaList) {
            System.out.println(media);
        }
    }
}
