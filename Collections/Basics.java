package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class Basics {
    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        Collection<String> strings2 = new ArrayList<>();
        Collection<String> strings3 = new ArrayList<>();

        print("\n example1: =================================================\n");
        strings.add("one");
        strings.add("two");
        strings.add("three");
        if (strings.contains("one")) {
            print("one is here");
        }
        strings2.add("one");
        strings2.add("two");
        print("\n example2: =================================================\n");
        if (strings.containsAll(strings2)) {
            print("strings contains strings2");
        }
        if (strings2.containsAll(strings))
            print("strings2 contains strings");
        print("strings " + strings);
        print("\n example3: =================================================\n");
        strings.remove("one");
        print("strings " + strings);

        print("\n example4: =================================================\n");
        boolean hasChanged = strings3.addAll(strings);
        if (hasChanged)
            print(" string3 has changed");
        print(strings3);

        print("\n example5: =================================================\n");
        Collection<String> toBeRemoved = new ArrayList<>();
        toBeRemoved.add("two");

        hasChanged = strings3.removeAll(toBeRemoved);
        if (hasChanged) {
            print("toBeRemoved got removed from string3");
        }
        print(strings3);

        print("\n example6: =================================================\n");

        hasChanged = strings.retainAll(strings2);
        if (hasChanged) {
            print("strings has changed");
        }

        print(strings);

        print("\n example7: =================================================\n");

        int size = strings.size();
        print("strings is " + (size != 0 ? "not" : "") + " empty" + "\nsize of the string is " + size);

        print("strings is " + (strings.isEmpty() ? "" : "not") + " empty");

        strings.clear();
        print("strings is " + (strings.isEmpty() ? "" : "not") + " empty");

        print("\n example8: =================================================\n");

        Collection<String> stringList = List.of("one", "two");
        String[] largertab = { "three", "three", "three", "I", "was", "three" };
        print("largertab = " + Arrays.toString(largertab));
        String[] result = stringList.toArray(largertab);
        print("stringList to array = " + Arrays.toString(result));

        String[] emptyArr = { "three" };
        String[] result1 = stringList.toArray(emptyArr);
        print("stringList to array = " + Arrays.toString(result1));

        print("stringList to array = " + Arrays.toString(strings.toArray(String[]::new)));

        print("\n example9: =================================================\n");

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;

        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        Collection<String> sample = new ArrayList<>();
        sample.add(null);
        sample.add("");
        sample.add("one");
        sample.add("two");
        sample.add("");
        sample.add("three");
        sample.add(null);

        print(sample);
        sample.removeIf(isNullOrEmpty);
        print(sample);
    }

    public static void print(Object x) {
        System.out.println(x);
    }

}
