package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Attribute
    private List<String> authors = new ArrayList<>();

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Method to add an author
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Doan Nhat Quang - 5911 - Author is already in the list");
        } else {
            authors.add(authorName);
            System.out.println("Doan Nhat Quang - 5911 - Added author successfully");
        }
    }

    // Method to remove an author
    public void removeAuthor(String authorName) {
    	if (!authors.contains(authorName)) {
    		System.out.println("Doan Nhat Quang - 5911 - Author is absent in the list");
    		return;
     }
    		authors.remove(authorName);
    		System.out.println("Doan Nhat Quang - 5911 - Removed author successfully");
    }

    // Getter and Setter
    public List<String> getAuthors() { return authors; }

    public void setAuthors(List<String> authors) { this.authors = authors; }

    // Method to print details of a book
    public void print() {
	     System.out.print(getId() + ". Book - "
	             + getTitle() + " - "
	             + getCategory() + " - ");
	     for (String author : authors) {
	         System.out.print(author + " - ");
	     }
	     System.out.println(getCost() + "$");
	 }
}
