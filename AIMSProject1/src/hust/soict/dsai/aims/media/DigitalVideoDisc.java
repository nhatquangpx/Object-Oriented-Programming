package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
    private static int nbDigitalVideoDiscs = 0;

    // Constructor 1: Tạo DVD chỉ với title
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0, 0, null); // Gọi constructor của Disc với giá trị mặc định
    }

    // Constructor 2: Tạo DVD với category, title, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null); // Gọi constructor của Disc với giá trị mặc định
    }

    // Constructor 3: Tạo DVD với director, category, title, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, director); // Gọi constructor của Disc với length mặc định
    }

    // Constructor 4: Tạo DVD với tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director); // Gọi đầy đủ constructor của Disc
    }

	public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title); // Sử dụng getTitle() từ lớp cha Disc/Media
    }


    // Implement play() from Playable interface
	public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // Play DVD logic here
        	System.out.println("Doan Nhat Quang - 5911 - Playing DVD: " + getTitle());
            System.out.println("Doan Nhat Quang - 5911 - DVD length: " + getLength() + " mins");
        } else {
            throw new PlayerException("Quang - 5911 - ERROR: DVD length is non-positive!");
        }
    }
}
