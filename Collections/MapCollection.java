package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MapCollection
 */
public class MapCollection {

    public static void main(String... args) {

        print("\n example1: =================================================\n");

        // Not more than 10 elements
        Map<Integer, String> map = Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "one",
                6, "two",
                7, "three",
                8, "four",
                9, "one",
                10, "two");

        // More than 10 elements

        Map<Integer, String> map2 = Map.ofEntries(
                Map.entry(1, "one"),
                Map.entry(2, "one"),
                Map.entry(3, "one"),
                Map.entry(4, "one"),
                Map.entry(5, "one"),
                Map.entry(7, "one"),
                Map.entry(6, "one"),
                Map.entry(8, "one"),
                Map.entry(9, "one"),
                Map.entry(10, "one"),
                Map.entry(11, "one"),
                Map.entry(12, "one"));

        print("\n example2: =================================================\n");

        Map<String, Integer> map3 = new HashMap<>();

        map3.put("one", 1);
        map3.put("two", null);

        try {
            for (int value : map3.values()) {
                print(value);
            }
        } catch (NullPointerException e) {
            print(e.getMessage());
        }

        print("\n example3: =================================================\n");
        for (String key : map3.keySet()) {
            map3.putIfAbsent(key, -1);
        }
        print(map3);

        print("\n example4: =================================================\n");
        Map<Integer, String> map4 = new HashMap<>();

        map4.put(1, "one");
        map4.put(2, "two");
        map4.put(3, "three");

        // .get(key) -> gets the value of the key.
        // .getorDefault(key, defaultValue) -> value if present or returns defaultValue.
        // .remove(key), .remove(key,value) -> removes key and value from map
        // .containsKey(key), .containesValue(value) -> checks for the presence of key
        // or value.

        List<String> list = new ArrayList<>();
        for (int key = 0; key < 5; key++) {
            list.add(map4.getOrDefault(key, "undefined"));
        }
        print(list);

        print("\n example5: =================================================\n");

        print(map4.containsKey(1));
        print(map4.containsValue("two"));
        print(map4.size());
        print(map4.isEmpty());
        map4.clear();
        print(map4.isEmpty());
        map4.putAll(map2);
        print(map4);

        print("\n example5: =================================================\n");
        Set<Integer> keys = map4.keySet();
        keys.remove(3);
        print(map4);

        print("\n example6: =================================================\n");

        map4.forEach((key, value) -> print(key + "::" + value));

        // replace(key, value) -> replaces value -> returns old value
        // replace(key, existingValue, newValue). -> replaces newvalue if it matches
        // existing value

        map4.replaceAll((key, value) -> value.toUpperCase());
        print(map4);
        print("\n example7: =================================================\n");

        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");
        Map<Integer, List<String>> map5 = new HashMap<>();

        for (String word : strings) {
            Integer length = word.length();
            // computeIfAbsent return the value if present or get the value by computing
            // lambda expression
            map5.computeIfAbsent(length, key -> new ArrayList<>()).add(word);
        }

        print(map5);

        print("\n example7: =================================================\n");
        Map<Integer, String> map6 = new HashMap<>();
        for (String word : strings) {
            Integer length = word.length();
            // merge is used in case the values are immutable
            map6.merge(length, word, (existingValue, newValue) -> existingValue + "," + newValue);
        }

        print(map6);
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}