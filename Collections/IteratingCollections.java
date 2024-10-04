package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratingCollections {
    public static void main(String... args) {
        Collection<String> strings = List.of("one", "two", "three");
        print("\n example1: =================================================\n");
        for (String element : strings) {
            print(element);
        }

        print("\n example2: =================================================\n");

        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
            String out = iterator.next();
            if (out.length() == 3) {
                print(out);
            }
        }
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
