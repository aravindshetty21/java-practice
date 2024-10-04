package StreamAPI;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.text.html.HTML;

public class CreatingStreams {
    public static void main(String[] args) {
        print("Example 1 =============================================");
        Stream<String> empty = Stream.empty();
        List<String> strings = empty.collect(Collectors.toList());
        print(strings);

        print("Example 2 using varArgs or an Array =============================================");

        Stream<Integer> intStream = Stream.of(1, 2, 3);
        List<Integer> ints = intStream.collect(Collectors.toList());
        print(ints);

        String[] strArr = { "one", "two", "three" };
        Stream<String> strStream = Arrays.stream(strArr);
        List<String> strList = strStream.collect(Collectors.toList());
        print(strList);

        print("\n Example 3 generate method =============================================");

        Stream<String> generated = Stream.generate(() -> "+");
        List<String> _strings = generated.limit(10L).collect(Collectors.toList()); // Limit is required. otherwise
                                                                                   // generate will generate the
                                                                                   // elements infinitely.
        print(_strings);

        print("\n Creating a Stream from a UnaryOperator and a Seed =============================================");

        Stream<String> iterated = Stream.iterate("+", s -> s + "+");
        iterated.limit(5).forEach(System.out::println);

        // uses predicate to stop iterating instead of limit
        Stream<String> _iterated = Stream.iterate("+", s -> s.length() <= 5, s -> s + "+");
        _iterated.forEach(System.out::println);

        print("\n Creating a Stream from a Range of Numbers =============================================");

        String[] letters = { "A", "B", "C", "D" };
        List<String> listLetters = IntStream.range(0, letters.length)
                .mapToObj(index -> letters[index])
                .collect(Collectors.toList());
        print(listLetters);

        print("\n Creating a Stream of Random Numbers =============================================");

        Random random = new Random(314L);
        List<Integer> randomInts = random.ints(10, 1, 5)
                .boxed() // Boxing IntStream to Stream<Integers>
                .collect(Collectors.toList());
        print(randomInts);

        print("\n Creating a Stream from the Characters of a String =============================================");

        String sentence = "hello duke";
        List<String> sentenceChars = sentence.chars()
                .mapToObj(charCode -> (char) charCode)
                .map(Object::toString)
                .collect(Collectors.toList());

        print(sentenceChars);

        // In java 11 ::toString() method is added to Character

        String _sentence = "Hello Duke";
        List<String> _letters = _sentence.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toList());
        print("letters = " + _letters);

        print("\n Creating a Stream from the Lines of a Text File =============================================");

        Path path = Path.of("./sample.txt");
        try (Stream<String> lines = Files.lines(path)) {
            long count = lines.count();
            print(count);
        } catch (IOException e) {

        }

        print("\n Creating a Stream from a Regular Expression =============================================");

        String __sentence = "For there is good news yet to hear and fine things to be seen";

        String[] elements = __sentence.split(" ");
        Stream<String> stream = Arrays.stream(elements);

        print(stream.collect(Collectors.toList()));

        // Compared to above method, the below has less overhead as there is no creation
        // of array.

        String sentence_ = "For there is good news yet to hear and fine things to be seen";

        Pattern pattern = Pattern.compile(" ");
        Stream<String> stream_ = pattern.splitAsStream(sentence_);
        List<String> words = stream_.collect(Collectors.toList());

        print("words = " + words);

        print("\n Creating a Stream with the Builder Pattern=============================================");

        Stream.Builder<String> builder = Stream.<String>builder();

        builder.add("One")
                .add("two")
                .add("three")
                .add("four");

        Stream<String> numString = builder.build();

        print(numString.collect(Collectors.toList()));

        print("\n Creating a Stream on an HTTP Source =============================================");

        // throws an exception so commented.

        // URI uri = URI.create("https://www.gutenberg.org/files/98/98-0.txt");

        // HttpClient client = HttpClient.newHttpClient();
        // HttpRequest request = HttpRequest.newBuilder(uri).build();

        // HttpResponse<Stream<String>> response = client.send(request,
        // HttpResponse.BodyHandlers.ofLines());
        // List<String> lines;
        // try (Stream<String> stream__ = response.body()) {
        // lines = stream__
        // .dropWhile(line -> !line.equals("A TALE OF TWO CITIES"))
        // .takeWhile(line -> !line.equals("*** END OF THE PROJECT GUTENBERG EBOOK A
        // TALE OF TWO CITIES ***"))
        // .collect(Collectors.toList());
        // }
        // print("# lines = " + lines.size());
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
