package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class ListCollections {
    public static void main(String... args) {
        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

        print("\n example1: =================================================\n");

        strings.add("seven");
        strings.remove("six");
        print(strings.get(3));
        strings.set(3, "eight");
        print(strings.get(3));

        print("\n example2: =================================================\n");

        print(strings);
        strings.subList(1, 3).clear();
        print(strings);

        print("\n example3: =================================================\n");

        Collection<String> strings2 = List.of("six", "seven");
        strings.addAll(1, strings2);
        print(strings);

        print("\n example4: =================================================\n");
        List<Integer> ints = new ArrayList<>(List.of(5, 2, 1, 4, 6, 3));
        ints.sort(Comparator.naturalOrder());
        print(ints);

        print("\n example5: =================================================\n");
        List<Integer> ints2 = new ArrayList<>(List.of(5, 2, 1, 4, 6, 3));
        ints2.sort((x, y) -> -x.compareTo(y));
        print(ints2);

        print("\n example6: =================================================\n");
        List<String> numbers = Arrays.asList("one", "two", "three", "four");
        for (ListIterator<String> iterator = numbers.listIterator(); iterator.hasNext();) {
            String nextElement = iterator.next();
            if (nextElement == "two") {
                iterator.set("2");
            }
        }
        print(numbers);
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
