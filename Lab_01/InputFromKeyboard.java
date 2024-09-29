// EX2: InputFromKeyboard.java
import java.util.Scanner;
public class InputFromKeyboard{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Doan Nhat Quang - 5911 - What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("Doan Nhat Quang - 5911 - How old are you?");
        int iAge = keyboard.nextInt();
        System.err.println("Doan Nhat Quang - 5911 - How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Doan Nhat Quang - 5911 - Mrs/Mr. " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight + "." );

    }
}