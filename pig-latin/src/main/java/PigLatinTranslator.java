import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PigLatinTranslator{
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
    private static final Pattern RULES = Pattern.compile("((?<vowel>[aeiou]|xr|yt)|" +
                                                        "(?<consonant>(?!xr|yt)y?(?:[^aeiouy]*qu|[^aeiouy]*)))" +
                                                        "(?<body>.*)");
    private static final String TEMPLATE = "${vowel}${body}${consonant}ay";

    String translate(String phrase) {
        Stream<String> wordsStream = WHITESPACE.splitAsStream(phrase);
        return wordsStream.map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {
        return RULES.matcher(word).replaceFirst(TEMPLATE);
    }
}