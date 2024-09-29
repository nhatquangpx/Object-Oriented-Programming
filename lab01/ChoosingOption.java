// EX1: ChoosingOption.java
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, "Doan Nhat Quang - 5911 - Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "Doan Nhat Quang - 5911 - You have chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
