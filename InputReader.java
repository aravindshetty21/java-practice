import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InputReader {

    public static void main(String[] arr) {
        int N = 0;
        BufferedReader ipt = new BufferedReader(new InputStreamReader(System.in));
        try {
            N = Integer.parseInt(ipt.readLine().trim());
            ipt.close();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(N);
    }
}