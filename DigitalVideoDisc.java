package Aims;

public class DigitalVideoDisc {
    // Thuộc tính đối tượng
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Thuộc tính lớp (static): Theo dõi số lượng DVD đã được tạo
    private static int nbDigitalVideoDiscs = 0;

    // Thuộc tính đối tượng: ID duy nhất của mỗi DVD
    private int id;

    // Constructor 1: Tạo DVD chỉ với title
    public DigitalVideoDisc(String title) {
        this.title = title;
        // Tăng số lượng DVD đã được tạo
        nbDigitalVideoDiscs++;
        // Gán ID cho DVD
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 2: Tạo DVD với category, title, cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 3: Tạo DVD với director, category, title, cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Constructor 4: Tạo DVD với tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getter cho ID
    public int getId() {
        return id;
    }

    // Getter cho số lượng DVD đã tạo
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Getter cho các thuộc tính khác
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

	public void setTitle(String title) {
		this.title = title;
	}
	public String toString() {
	    return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
	}
	public boolean isMatch(String title) {
	    return this.title.equalsIgnoreCase(title);
	}

}