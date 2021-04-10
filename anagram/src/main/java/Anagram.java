import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    private String searchString;

    public Anagram(String value) {
        searchString = value;
    }

    public List<String> match(List<String> input) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (searchString.length() == input.get(i).length() && !searchString.equalsIgnoreCase(input.get(i))) {
                char[] word1 = searchString.toLowerCase().toCharArray();
                char[] word2 = input.get(i).toLowerCase().toCharArray();

                Arrays.sort(word1);
                Arrays.sort(word2);

                if (Arrays.equals(word1, word2)) {
                    output.add(input.get(i));
                }
            }
        }

        return output;
    }
}
