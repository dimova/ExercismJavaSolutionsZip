import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Acronym {
    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase.toUpperCase();
    }

    String get() {
        return getMatches()
                .stream()
                .map(word -> String.valueOf(word.charAt(0)))
                .collect(Collectors.joining());
    }

    private ArrayList<String> getMatches() {
        ArrayList<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+'\\w+|[A-Za-z]+");
        Matcher matcher = pattern.matcher(phrase);

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches;
    }
}
