import java.io.*;
import java.util.*;

public class Practice1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(scanner.nextLine());
            int temp = 0;
            while (num != 0 && num != -1) {
                num = num >> 2;
                temp++;
            }
            System.out.println(num + " can be fitter in:");
            if (temp >= 7) {
                System.out.println("* byte");
            }
            if (temp >= 15) {
                System.out.println("* short");
            }
            if (temp >= 31) {
                System.out.println("* int");
            }
            if (temp >= 63) {
                System.out.println("* long");
            }
        }
        scanner.close();
    }
}
