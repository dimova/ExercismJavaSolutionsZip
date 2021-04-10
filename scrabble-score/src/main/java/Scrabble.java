import java.util.HashMap;

class Scrabble {

    private HashMap<Character, Integer> letterValues = new HashMap<Character, Integer>();
    private int score = 0;

    Scrabble(String word) {
        setValues();
        word = word.toUpperCase();

        for (int i = 0; i < word.length(); i++) {
            score += letterValues.get(word.charAt(i));
        }
    }

    private void setValues() {
        letterValues.put('A', 1);
        letterValues.put('E', 1);
        letterValues.put('I', 1);
        letterValues.put('O', 1);
        letterValues.put('U', 1);
        letterValues.put('L', 1);
        letterValues.put('N', 1);
        letterValues.put('R', 1);
        letterValues.put('S', 1);
        letterValues.put('T', 1);
        letterValues.put('D', 2);
        letterValues.put('G', 2);
        letterValues.put('B', 3);
        letterValues.put('C', 3);
        letterValues.put('M', 3);
        letterValues.put('P', 3);
        letterValues.put('F', 4);
        letterValues.put('H', 4);
        letterValues.put('V', 4);
        letterValues.put('W', 4);
        letterValues.put('Y', 4);
        letterValues.put('K', 5);
        letterValues.put('J', 8);
        letterValues.put('X', 8);
        letterValues.put('Q', 10);
        letterValues.put('Z', 10);
    }

    int getScore() {
        return score;
    }

}
