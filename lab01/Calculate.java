// Example 5: Calculate.java
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Doan Nhat Quang - 5911 - The results are: ";

        strNum1 = JOptionPane.showInputDialog(null, "Doan Nhat Quang - 5911 - Please input the first number: ","Doan Nhat Quang - 5911 - Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Doan Nhat Quang - 5911 - Please input the second number: ","Doan Nhat Quang - 5911 - Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        strNotification += "Sum = " + sum;
        double difference = num1 - num2;
        strNotification += " Difference = " + difference;
        double production = num1 * num2;
        strNotification += " Production = " + production;
        double quotient = num1 / num2;
        strNotification += " Quotient = " + quotient;

        JOptionPane.showMessageDialog(null, strNotification, " Doan Nhat Quang - 5911 - The results ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
