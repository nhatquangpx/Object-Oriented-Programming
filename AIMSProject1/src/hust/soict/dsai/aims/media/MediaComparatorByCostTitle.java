package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if (costComparison != 0) {
            return costComparison;	// Doan Nhat Quang - 5911
        }
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}
