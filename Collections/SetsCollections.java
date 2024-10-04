package Collections;

import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetsCollections {
    public static void main(String... args) {
        print("\n example1: =================================================\n");
        List<String> strings = List.of("one", "two", "three", "four", "five", "six");
        Set<String> set = new HashSet<>();
        set.addAll(strings);
        set.forEach(SetsCollections::print);

        print("\n example2: =================================================\n");
        SortedSet<Integer> set2 = new TreeSet<>(Set.of(2, 3, 1, 4));
        print(set2);
        print(set2.first());
        print(set2.last());
        print(set2.headSet(3));
        print(set2.tailSet(3));
        print(set2.subSet(2, 4));

        print("\n example3: =================================================\n");

        SortedSet<String> strings2 = new TreeSet<>(Set.of("a", "b", "c", "d", "e", "f"));
        SortedSet<String> subSet = strings2.subSet("ab", "f");
        System.out.println("sub set = " + subSet);

        print("\n example4: =================================================\n");

        NavigableSet<Integer> ints = new TreeSet<>(Set.of(2, 3, 1, 4, 5, 7, 8, 0));
        print(ints);
        print(ints.headSet(3, true));

        // In navigable sets boolean to include or exclude the extreme argument in the
        // return value.
        print(ints.tailSet(3, false));
        print(ints.subSet(2, true, 7, true));

        print("\n example5: =================================================\n");

        print(ints.ceiling(5));
        print(ints.floor(5));
        print(ints.lower(5));
        print(ints.higher(5));

        print("\n example6: =================================================\n");

        print(ints.pollFirst()); // removes and returns least number
        print(ints.pollLast()); // removes and returns highest number
        print(ints);

        print("\n example7: =================================================\n");
        print(ints.descendingSet()); // sorted set in descending order
        // look at NavigableSet::descendingIterator() -> gives iterator that traverses
        // the set in descending order.
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}
