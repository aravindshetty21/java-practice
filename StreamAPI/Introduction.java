package StreamAPI;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Introduction {
    public static void main(String... args) {
        print("Example 1 =========================");
        List<String> strings = List.of("one", "two", "three", "four");
        Function<String, Integer> toLength = String::length;
        List<Integer> lengths = strings.stream()
                .map(toLength)
                .collect(Collectors.toList());
        print(lengths);
        print("Example 2 =========================");

        IntSummaryStatistics stats = strings.stream()
                .mapToInt(String::length)
                .summaryStatistics();

        print(stats);
        print("Example 3 =========================");

        Long count = strings.stream()
                .map(String::length)
                .filter(x -> x > 3)
                .count();

        print("count = " + count);

        print("Example 4 validating inputs using flatmap =========================");
        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };

        List<String> strings2 = List.of("1", " ", "2", "3 ", "", "3");
        List<Integer> ints = strings2.stream()
                .flatMap(flatParser)
                .collect(Collectors.toList());
        print("ints = " + ints);

        print("Example 5 distinct and sorted =========================");
        List<Integer> intList = List.of(1, 2, 2, 3, 5, 5, 64, 5, 5);
        List<Integer> distinctList = intList.stream().distinct().collect(Collectors.toList());
        List<Integer> sortedList = intList.stream().sorted((x, y) -> -x.compareTo(y)).collect(Collectors.toList());
        print(distinctList);
        print(sortedList);

        print("Example 6 skip and limit =========================");
        List<Integer> skipLimitedInts = intList.stream()
                .skip(2)
                .limit(5)
                .collect(Collectors.toList());

        print(skipLimitedInts);

        print("Example 7 peek =========================");

        List<String> result = strings.stream()
                .peek(s -> System.out.println("Starting with = " + s))
                .filter(s -> s.startsWith("t"))
                .peek(s -> System.out.println("Filtered = " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Mapped = " + s))
                .collect(Collectors.toList());
        System.out.println("result = " + result);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

}