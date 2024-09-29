// Example 6: EquationSolver.java
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("Doan Nhat Quang - 5911 - Chon loai phuong trinh de giai:");
            System.out.println("Doan Nhat Quang - 5911 - 1. Phuong trinh bac nhat (ax + b = 0)");
            System.out.println("Doan Nhat Quang - 5911 - 2. He phuong trinh bac nhat (2 bien)");
            System.out.println("Doan Nhat Quang - 5911 - 3. Phuong trinh bac hai (ax^2 + bx + c = 0)");
            System.out.print("Doan Nhat Quang - 5911 - Nhap lua chon cua ban (1-3): ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 3) {
                break; 
            } else {
                System.out.println("Doan Nhat Quang - 5911 - Lua chon khong hop le. Vui long nhap lai.");
            }
        }

        switch (choice) {
            case 1:
                // Giai phuong trinh bac nhat
                System.out.print("Doan Nhat Quang - 5911 - Nhap he so a: ");
                double a = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap he so b: ");
                double b = scanner.nextDouble();

                if (a == 0) {
                    if (b == 0) {
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh co vo so nghiem.");
                    } else {
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh vo nghiem.");
                    }
                } else {
                    double x = -b / a;
                    System.out.println("Doan Nhat Quang - 5911 - Nghiem cua phuong trinh bac nhat la: x = " + x);
                }
                break;

            case 2:
                // Giai he phuong trinh bac nhat
                System.out.print("Doan Nhat Quang - 5911 - Nhap a11: ");
                double a11 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap a12: ");
                double a12 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap b1: ");
                double b1 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap a21: ");
                double a21 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap a22: ");
                double a22 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap b2: "); 
                double b2_1 = scanner.nextDouble();

                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2_1 * a12; 
                double D2 = a11 * b2_1 - a21 * b1; 

                if (D == 0) {
                    if (D1 == 0 && D2 == 0) {
                        System.out.println("Doan Nhat Quang - 5911 - He phuong trinh co vo so nghiem.");
                    } else {
                        System.out.println("Doan Nhat Quang - 5911 - He phuong trinh vo nghiem.");
                    }
                } else {
                    double x1 = D1 / D;
                    double x2 = D2 / D;
                    System.out.println("Doan Nhat Quang - 5911 - Nghiem cua he phuong trinh la: x1 = " + x1 + ", x2 = " + x2);
                }
                break;

            case 3:
                // Giai phuong trinh bac hai
                System.out.print("Doan Nhat Quang - 5911 - Nhap he so a: ");
                double a2 = scanner.nextDouble();
                System.out.print("Doan Nhat Quang - 5911 - Nhap he so b: ");
                double b2_2 = scanner.nextDouble(); 
                System.out.print("Doan Nhat Quang - 5911 - Nhap he so c: ");
                double c = scanner.nextDouble();

                if (a2 == 0) {
                    if (b2_2 == 0) {
                        if (c == 0) {
                            System.out.println("Doan Nhat Quang - 5911 - Phuong trinh co vo so nghiem.");
                        } else {
                            System.out.println("Doan Nhat Quang - 5911 - Phuong trinh vo nghiem.");
                        }
                    } else {
                        double x = -c / b2_2;
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh bac nhat tuong duong: x = " + x);
                    }
                } else {
                    double delta = b2_2 * b2_2 - 4 * a2 * c; 

                    if (delta > 0) {
                        double x1_2 = (-b2_2 + Math.sqrt(delta)) / (2 * a2);
                        double x2_2 = (-b2_2 - Math.sqrt(delta)) / (2 * a2);
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh co 2 nghiem phan biet: x1 = " + x1_2 + ", x2 = " + x2_2);
                    } else if (delta == 0) {
                        double x_2 = -b2_2 / (2 * a2);
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh co nghiem kep: x = " + x_2);
                    } else {
                        System.out.println("Doan Nhat Quang - 5911 - Phuong trinh vo nghiem.");
                    }
                }
                break;
        }

        scanner.close();
    }
}
