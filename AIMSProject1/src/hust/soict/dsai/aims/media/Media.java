package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	// Attributes
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(int id, String title) {
		this.id = id;
		this.title = title; 		// Doan Nhat Quang - 5911
	}

	public Media(int id, String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title); 
    }
	public String toString() {
		return "Media{" + 						// Doan Nhat Quang - 5911
				"id=" + id + 
				", title = '" + title + '\'' + 
				", category = '" + category +  '\'' + 
				", cost = '" + cost + '}' ;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {						// Doan Nhat Quang - 5911
	        return true;
	    }
	    if (obj == null) {
	        return false;
	    }
	    if (!(obj instanceof Media)) {
	        return false;
	    }
	    Media otherMedia = (Media) obj;
	    
	    return this.getTitle() != null && this.getTitle().equals(otherMedia.getTitle());
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
	        new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
	        new MediaComparatorByCostTitle();
}
