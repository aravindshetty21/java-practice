package Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImplementingIterables {
    public static void main(String... args) {
        for (int i : new Range(1, 5)) {
            print(i);
        }
    }

    public static void print(Object x) {
        System.out.println(x);
    }
}

record Range(int start, int end) implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = start;

            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if (index > end) {
                    throw new NoSuchElementException("" + index);
                }
                int currentIndex = index;
                index++;
                return currentIndex;
            }
        };
    }
}

class Range2 implements Iterable<Integer> {
    private final int start;
    private final int end;

    public Range2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = start;

            @Override
            public boolean hasNext() {
                return index < end;
            }

            @Override
            public Integer next() {
                if (index > end) {
                    throw new NoSuchElementException("" + index);
                }
                int currentIndex = index;
                index++;
                return currentIndex;
            }
        };
    }
}