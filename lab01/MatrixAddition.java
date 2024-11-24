// EX6: MatrixAddition.java
import java.util.Scanner;
public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Doan Nhat Quang - 5911 - Chon cach nhap ma tran:");
        System.out.println("Doan Nhat Quang - 5911 - 1. Nhap ma tran tu ban phim");
        System.out.println("Doan Nhat Quang - 5911 - 2. Su dung ma tran hang so");
        System.out.print("Doan Nhat Quang - 5911 - Nhap lua chon (1 hoac 2): ");
        int choice = scanner.nextInt();

        int rows, cols;
        int[][] matrix1, matrix2, resultMatrix;

        if (choice == 1) {
            System.out.print("Doan Nhat Quang - 5911 - Nhap so hang cua ma tran: ");
            rows = scanner.nextInt();
            System.out.print("Doan Nhat Quang - 5911 - Nhap so cot cua ma tran: ");
            cols = scanner.nextInt();

            matrix1 = new int[rows][cols];
            matrix2 = new int[rows][cols];
            resultMatrix = new int[rows][cols];

            System.out.println("Doan Nhat Quang - 5911 - Nhap cac phan tu cua ma tran 1:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Doan Nhat Quang - 5911 - Nhap phan tu [" + i + "][" + j + "]: ");
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Doan Nhat Quang - 5911 - Nhap cac phan tu cua ma tran 2:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Doan Nhat Quang - 5911 - Nhap phan tu [" + i + "][" + j + "]: ");
                    matrix2[i][j] = scanner.nextInt();
                }
            }
        } else {
            
            rows = 3; 
            cols = 3;  

            // Initialize constant matrices
            matrix1 = new int[][]{
                {1, 2, 7},
                {3, 5, 4}, 
                {9, 10, -6}
            };
            matrix2 = new int[][]{
                {5, 24, 6},
                {7, -12, 18},
                {-2, -5, 3}
            };
            resultMatrix = new int[rows][cols];

            System.out.println("Doan Nhat Quang - 5911 - Su dung ma tran hang so:");
            System.out.println("Doan Nhat Quang - 5911 - Ma tran 1:");
            displayMatrix(matrix1);
            System.out.println("Doan Nhat Quang - 5911 - Ma tran 2:");
            displayMatrix(matrix2);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Doan Nhat Quang - 5911 - Ma tran ket qua sau khi cong:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
