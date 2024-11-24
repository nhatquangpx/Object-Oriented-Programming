
package Aims;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;											//Doan Nhat Quang - 5911
    private int length;
    private float cost;



    // Constructor 1: Tạo DVD chỉ với title
    public DigitalVideoDisc(String title) {
        this.title = title;

    }

    // Constructor 2: Tạo DVD với category, title, cost
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;

    }

    // Constructor 3: Tạo DVD với director, category, title, cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;

    }

    // Constructor 4: Tạo DVD với tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;											//Doan Nhat Quang - 5911
        this.cost = cost;

    }



    public String getTitle() {
        return title;
    }

    public String getCategory() {											//Doan Nhat Quang - 5911
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {											//Doan Nhat Quang - 5911
        return length;
    }

    public float getCost() {
        return cost;
    }

	public void setTitle(String title) {
		this.title = title;
	}
}
