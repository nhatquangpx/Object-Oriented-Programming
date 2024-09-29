// EX5: Array.java
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Doan Nhat Quang - 5911 - Nhap so luong phan tu trong mang: ");
        int n = scanner.nextInt();
        double[] numbers = new double[n];
        System.out.println("Doan Nhat Quang - 5911 - Nhap cac phan tu cua mang: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        bubbleSort(numbers);

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }

        double average = sum / n;

        System.out.print("Doan Nhat Quang - 5911 - Mang sau khi sap xep: ");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Doan Nhat Quang - 5911 - Tong cac phan tu: " + sum);
        System.out.println("Doan Nhat Quang - 5911 - Gia tri trung binh: " + average);
        scanner.close();
    }

    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
