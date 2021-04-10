import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class WordCount
{
    private final Map<String, Integer> dictionary;
    WordCount()
    {
        dictionary = new HashMap<>();
    }
    Map<String, Integer> phrase(String sentence)
    {
        var result = Pattern.compile("\\b[\\w']+\\b").
                                 matcher(sentence.toLowerCase()).
                                 results().
                                 map(MatchResult::group).
                                 collect(Collectors.toList());
        for (String word : result)
        {
            if (dictionary.containsKey(word)) {
                int count = dictionary.get(word);
                dictionary.put(word, ++count);
            } else dictionary.put(word, 1);
        }
        return dictionary;
    }
}

