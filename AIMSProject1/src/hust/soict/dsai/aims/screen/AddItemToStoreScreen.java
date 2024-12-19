package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Container cp;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        this.cp = getContentPane();
        this.setLayout(new GridLayout(7, 2, 5, 5)); 

        addCommonFields();
        addSpecificFields();

        JButton turnInBtn = new JButton("Add");
        this.add(new JLabel()); 
        this.add(turnInBtn);

        turnInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore(); 
                Cart cart = null;
                StoreScreen storeScreen = new StoreScreen(store, cart); 
                storeScreen.revalidate(); 
                storeScreen.repaint();
            }
        });


        this.setTitle(getScreenTitle());
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void addCommonFields() {
        this.add(new JLabel("Quang - 5911 - Enter title: "));
        this.add(createTextField("title"));

        this.add(new JLabel("Quang - 5911 - Enter category: "));
        this.add(createTextField("category"));

        this.add(new JLabel("Quang - 5911 - Enter cost: "));
        this.add(createTextField("cost"));
    }

    protected abstract void addSpecificFields();

    protected abstract String getScreenTitle();

    protected abstract void addItemToStore();

    protected JTextField createTextField(String name) {
        JTextField field = new JTextField(10);
        field.setName(name);
        return field;
    }
}
