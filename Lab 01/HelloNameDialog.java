// Example 3: HelloNameDialog.java
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main (String[] args){
        String result;
        result = JOptionPane.showInputDialog("Doan Nhat Quang - 5911 - Please enter your name:");
        JOptionPane.showMessageDialog(null, "Toi la Doan Nhat Quang 5911. Hi " + result + "!");
        System.exit(0);
    }
}
