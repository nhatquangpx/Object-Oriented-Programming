package hust.soict.dsai.aims.screen;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        smUpdateStore.add(new JMenuItem("Quang - 5911 - Add Book"));

        JMenuItem addCD = new JMenuItem("Quang - 5911 - Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCDStoreScreen popUp = new AddCDStoreScreen(store);
            }
        });

        JMenuItem addDVD = new JMenuItem("Quang - 5911 - Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddDVDStoreScreen popUp = new AddDVDStoreScreen(store);
            }
        });
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("Quang - 5911 - View store"));
        menu.add(new JMenuItem("Quang - 5911 - View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cart1 = new JButton("View cart");
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
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // GridLayout 3x3
        ArrayList<Media> mediaStore = store.getItemsInStore();

        // Hiển thị tối đa 9 sản phẩm
        int maxItems = 9;
        for (int i = 0; i < maxItems; i++) {
            Media media;
            if (i < mediaStore.size()) {
                // Lấy sản phẩm từ danh sách nếu tồn tại
                media = mediaStore.get(i);
            } else {
                // Tạo placeholder nếu không đủ sản phẩm
                media = new DigitalVideoDisc("Placeholder", "No Category", "Unknown", 0, 0f);
            }

            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
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
        tracks2.add(new Track("Tobu - Candyland", 3));
        tracks2.add(new Track("Niviro - You", 4));
        tracks2.add(new Track("MBB - Beach", 2));
        tracks2.add(new Track("Syn Cole - Gizmo", 4));
        tracks2.add(new Track("Deamn - Sign", 4));
        tracks2.add(new Track("MBB - Arrival", 3));
        tracks2.add(new Track("EnV - Pneumatic", 5));
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


    private class AddDVDStoreScreen extends JFrame {
        public AddDVDStoreScreen(Store store) {
            this.setLayout(new GridLayout(4, 2, 5, 5));
            this.add(new JLabel("Quang - 5911 - Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Quang - 5911 - Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Quang - 5911 - Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);

            this.setTitle("Quang - 5911 - Add DVD");
            this.setSize(300, 100);
            JButton turnInBtn = new JButton("Quang - 5911 - Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	DigitalVideoDisc dvd = new DigitalVideoDisc( title.getText(), category.getText(), "", 0, Float.parseFloat(cost.getText()));
                    store.addMedia(dvd);
                    cp.add(createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            this.show();
        }
    }

    private class AddCDStoreScreen extends JFrame {
        public AddCDStoreScreen(Store store) {
            this.setLayout(new GridLayout(7, 2, 5, 5));
            this.add(new JLabel("Quang - 5911 - Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Quang - 5911 - Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Quang - 5911 - Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);
            this.add(new JLabel("Quang - 5911 - Enter artist: "));
            TextField artist = new TextField(10);
            this.add(artist);
            this.setTitle("Quang - 5911 - Add CD");
            this.add(new JLabel("Quang - 5911 - Number of tracks: "));
            TextField numberOfTracks = new TextField(10);
            this.add(numberOfTracks);
            this.pack();
            JButton turnInBtn = new JButton("Quang - 5911 - Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                	CompactDisc cd = new CompactDisc(0,title.getText(), category.getText(), artist.getText(), Float.parseFloat(cost.getText()),0, ""  );
                    cp.add(createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            this.show();
        }
    }
}