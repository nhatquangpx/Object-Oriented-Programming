package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Using "+" operator
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Doan Nhat Quang - 5911 - Using + operator: " + (System.currentTimeMillis() - start) + " ms");

        // Using StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Doan Nhat Quang - 5911 - Using StringBuilder: " + (System.currentTimeMillis() - start) + " ms");

        // Using StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbuf.append(r.nextInt(2));
        }
        s = sbuf.toString();
        System.out.println("Doan Nhat Quang - 5911 - Using StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
    }
}
