import java.util.HashMap;
import java.util.Map;

class RnaTranscription {

    static final Map<Character, Character> RNA = new HashMap<>();
    static {
        RNA.put('G', 'C');
        RNA.put('C', 'G');
        RNA.put('T', 'A');
        RNA.put('A', 'U');
    }

    String transcribe(String dnaStrand) {
        String result = "";
        for (int i = 0; i < dnaStrand.length(); i++) {
            result +=RNA.get(dnaStrand.charAt(i));
        }
        return result;
    }

}
