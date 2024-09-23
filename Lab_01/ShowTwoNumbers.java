// Example 5: ShowTwoNumbers.java
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Doan Nhat Quang - 5911 - You have just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                                             "Doan Nhat Quang - 5911 - Please input the first number: ","Doan Nhat Quang - 5911 - Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, "Doan Nhat Quang - 5911 - Please input the second number: ","Doan Nhat Quang - 5911 - Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        
        JOptionPane.showMessageDialog(null, strNotification, "Doan Nhat Quang - 5911 - Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
}
