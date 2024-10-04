package StreamAPI;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamProblems {

    public static void main(String[] args) {

        String sentence = "Rudy is a great magician despite being so young!";
        String[] sentenceArr = sentence.split(" ");

        Optional<String> result = Arrays.stream(sentenceArr)
                .filter(x -> !x.equals("is"))
                .collect(Collectors.reducing((x, y) -> x + " " + y));

        System.out.println(result.orElse("Error"));
    }
}