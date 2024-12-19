package hust.soict.dsai.aims.screen;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Container cp;
    private Cart cart;
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Quang - 5911 - Options");
        JMenu smUpdateStore = new JMenu("Quang - 5911 - Update Store");

        JMenuItem addBook = new JMenuItem("Quang - 5911 - Add Book");
        addBook.addActionListener(e -> new AddBookStoreScreen(store));
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Quang - 5911 - Add CD");
        addCD.addActionListener(e -> new AddCDStoreScreen(store));
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Quang - 5911 - Add DVD");
        addDVD.addActionListener(e -> new AddDVDStoreScreen(store));
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("Quang - 5911 - View Store"));
        menu.add(new JMenuItem("Quang - 5911 - View Cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }


    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("Doan Nhat Quang - 5911 - AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cart1 = new JButton("Quang - 5911 - View cart");
        cart1.setPreferredSize(new Dimension(100,50));
        cart1.setMaximumSize(new Dimension(100,50));
        cart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container cp = getContentPane();
                cp.add(new CartScreen(cart));
            }
        });
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart1);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }
    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // GridLayout 3x3
        ArrayList<Media> mediaStore = store.getItemsInStore();

        int maxItems = 9;
        for (int i = 0; i < maxItems; i++) {
            Media media;
            if (i < mediaStore.size()) {
                media = mediaStore.get(i);
            } else {
                media = new DigitalVideoDisc("Placeholder", "No Category", "Unknown", 0, 0f);
            }

            if (media instanceof DigitalVideoDisc && media.getTitle().equals("Placeholder")) {
                MediaStore cell = new MediaStore(media, cart, false); 
                center.add(cell);
            } else {
                MediaStore cell = new MediaStore(media, cart, true);
                center.add(cell);
            }
        }
        return center;
    }



    public StoreScreen(Store store, Cart myCart) {
        this.store = store; 
        this.cart = myCart; 

        setTitle("Doan Nhat Quang - Store Screen");
        setLayout(new BorderLayout());
        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Tạo các sản phẩm DigitalVideoDisc
        DigitalVideoDisc dvd = new DigitalVideoDisc("ABCD", "EFGH", "Anonymous", 97, 13.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("MNPQ", "JQKA", "Quang", 117, 23.5f);

        // Tạo CompactDisc và thêm track
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Pickaball", 3));
        tracks.add(new Track("APT", 4));
        CompactDisc cd = new CompactDisc(2, "Nhac TopTop", "Nhac Viet", "Various artist", 20.5f, 7, "Unknown");
        for (Track track : tracks) {
            cd.addTrack(track);
        }

        // Tạo CompactDisc thứ hai và thêm track
        ArrayList<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("New Era - A", 3));
        tracks2.add(new Track("Bau troi moi - Dalab", 4));
        tracks2.add(new Track("Giai dieu VN minh", 4));
        CompactDisc cd2 = new CompactDisc(5, "ABCD", "EFG", "Various artist", 37.25f, 20, "Unknown");
        for (Track track : tracks2) {
            cd2.addTrack(track);
        }

        // Tạo Book với constructor phù hợp
        Book book1 = new Book(3, "Giai tich", "detective", 25.2f);
        book1.addAuthor("Hust");

        Book book2 = new Book(4, "Dai so", "novel", 27.45f);
        book2.addAuthor("Hust");

        // Tạo đối tượng Cart và Store
        Cart myCart = new Cart();
        Store store = new Store();

        // Thêm sản phẩm vào store
        store.addMedia(dvd);
        store.addMedia(dvd2);
        store.addMedia(cd);
        store.addMedia(cd2);
        store.addMedia(book1);
        store.addMedia(book2);

        // Hiển thị giao diện StoreScreen
        new StoreScreen(store, myCart);
    }

}