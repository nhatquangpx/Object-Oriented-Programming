package hust.soict.dsai.aims.media;

public class Track implements Playable {
    // Fields to store track information
    private String title;
    private int length;

    // Constructor: Initialize the fields
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter for title
    public String getTitle() {  			// Doan Nhat Quang - 5911
        return title;
    }

    // Getter for length
    public int getLength() {
        return length;
    }

    // Implement play() from Playable interface
    public void play() {
        System.out.println("Doan Nhat Quang - 5911 - Playing Track: " + title);
        System.out.println("Doan Nhat Quang - 5911 - Track length: " + length + " mins");
    }
    public boolean equals(Object obj) {			// Doan Nhat Quang - 5911
        if (this == obj) return true; // Check reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check null and class type

        Track track = (Track) obj; // Cast object to Track
        return length == track.getLength() && title != null && title.equalsIgnoreCase(track.getTitle()); // Compare title and length
    }

}
