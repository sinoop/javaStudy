package lambdaexpressions.functionalInterface;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FunctionalInterface {
    public static void main(String[] args) {
        SentenceReverse f = s ->
                Pattern.compile("\\W")
                    .splitAsStream(s)
                    .map(x -> new StringBuilder(String.valueOf(x)).reverse().toString())
                    .collect(Collectors.joining(" "));

        
        System.out.println(f.getReversed("This is a test"));


    }
}
