package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    // Fields
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    // Constructor(s)
    public CompactDisc(int id, String title, String category, String artist, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
        this.artist = artist;			// Doan Nhat Quang - 5911
    }

	// Getter for artist
    public String getArtist() {
        return artist;
    }

    // Method to add a track
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Doan Nhat Quang - 5911 - Track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Doan Nhat Quang - 5911 - Track \"" + track.getTitle() + "\" has been added to the CD.");
        }
    }

    // Method to remove a track
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Doan Nhat Quang - 5911 - Track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("Doan Nhat Quang - 5911 - Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }

    // Method to calculate total length of the CD
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Play all tracks in the CD
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try {
                    nextTrack.play(); // Try to play each track
                } catch (PlayerException e) {
                    System.err.println(e.getMessage());
                    // Continue playing other tracks, or throw PlayerException if required
                    throw e;
                }
            }
        } else {
            throw new PlayerException("Quang - 5911 - ERROR: CD length is non-positive!");
        }
    }

	public ArrayList<Track> getTracks() {
        return tracks;
    }
}
