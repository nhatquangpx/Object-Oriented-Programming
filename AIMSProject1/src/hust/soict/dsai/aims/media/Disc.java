package hust.soict.dsai.aims.media;

public class Disc extends Media {
    // Fields specific to Disc
    private int length;
    private String director;						// Doan Nhat Quang - 5911

    // Constructor 1: Disc with all Media fields + length, director
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); // Call Media's constructor
        this.length = length;
        this.director = director;
    }

    // Constructor 2: Disc with minimal attributes
    public Disc(int id, String title) {
        super(id, title); // Doan Nhat Quang - 5911

    }

    // Getters
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}
