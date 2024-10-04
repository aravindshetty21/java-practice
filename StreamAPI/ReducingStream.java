package StreamAPI;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReducingStream {

    public static void main(String[] args) {
        print(" ++++++++++++++++ Using a Binary Operator to Reduce a Stream ++++++++++");
        List<Integer> _ints = List.of(3, 6, 2, 1);
        BinaryOperator<Integer> sum = (a, b) -> a + b;

        int _result = _ints.get(0);
        for (int index = 1; index < _ints.size(); index++) {
            _result = sum.apply(_result, _ints.get(index));
        }
        System.out.println("sum = " + _result);

        List<Integer> ints = List.of(3, 6, 2, 1);
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        int result = ints.get(0);
        for (int index = 1; index < ints.size(); index++) {
            result = max.apply(result, ints.get(index));
        }
        print("max = " + result);

        print(" ++++++++++++++++ Choosing a Binary Operator That Can Be Used in Parallel ++++++++++");

        BinaryOperator<Integer> sum_ = (a, b) -> a + b;

        int result1 = reduce(ints.subList(0, 2), sum_);
        int result2 = reduce(ints.subList(2, 4), sum_);

        int result_ = sum_.apply(result1, result2);
        print("sum = " + result_);

        print(" ++++++++++++++++ Exploring the Reduction Methods of the Stream API ++++++++++");

        Stream<Integer> ints_ = Stream.of(0, 0, 0, 0);

        // with identitity argument (first arg) to reduce
        int sum__ = ints_.reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum__);

        // without identity argument to reduce
        Stream<Integer> ints___ = Stream.of(2, 8, 1, 5, 3);
        Optional<Integer> optional = ints___.reduce((i1, i2) -> i1 > i2 ? i1 : i2);

        if (optional.isPresent()) {
            System.out.println("result = " + optional.orElseThrow());
        } else {
            System.out.println("No result could be computed");
        }

    }

    public static int reduce(List<Integer> ints, BinaryOperator<Integer> sum) {
        int result = ints.get(0);
        for (int index = 1; index < ints.size(); index++) {
            result = sum.apply(result, ints.get(index));
        }
        return result;
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}