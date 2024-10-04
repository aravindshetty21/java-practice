package Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FactoryMethods {
    public static void main(String... args) {
        // .of() method
        List<String> stringList = List.of("one", "two", "three");
        Set<String> stringSet = Set.of("one", "two", "three");

        // .copyOf()
        Collection<String> strings = Arrays.asList("one", "two");

        List<String> list = List.copyOf(strings);
        Set<String> set = Set.copyOf(strings);
        /**
         * Collections =>
         * min(), max()
         * indexOfSublist, lastIndexOfSubList -> (List<?> source, List<?> target)
         * sort(), shuffle()
         */

        // .rotate()
        List<String> strings2 = Arrays.asList("0", "1", "2", "3", "4");
        Collections.rotate(strings2, 2);
        print(strings2);
        Collections.rotate(strings2.subList(2, 5), -1);
        print(strings2);
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
