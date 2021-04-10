import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParallelLetterFrequency {
    private Map<Integer, Integer> _letterCounts;

    public Map<Integer, Integer> letterCounts() {
        return _letterCounts;
    }

    public ParallelLetterFrequency(String input) {
        _letterCounts = new ConcurrentHashMap<Integer, Integer>();
        input.toLowerCase().chars().parallel().forEach(this::incrementCount);
    }

    private void incrementCount(Integer character) {
        // Character range check takes care of whitespace, number, and punctuation rules
        if (character >= 'a' && character <= 'z') {
            _letterCounts.merge(character, 1, Integer::sum);
        }
    }
}