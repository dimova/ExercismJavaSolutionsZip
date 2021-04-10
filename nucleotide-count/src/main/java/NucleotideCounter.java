import java.util.HashMap;
import java.util.Map;

class NucleotideCounter {
    private Map<Character, Integer> nuMap = new HashMap<Character, Integer>();

    public NucleotideCounter(String s) {
        this.nuMap.put('A', 0);
        this.nuMap.put('C', 0);
        this.nuMap.put('G', 0);
        this.nuMap.put('T', 0);

        for (char c : s.toCharArray()) {
            if ("ACGT".indexOf(c) == -1)
                throw new IllegalArgumentException();

            this.nuMap.put(c, this.nuMap.get(c) + 1);
        }
    }

    public Map<Character, Integer> nucleotideCounts() {
        return this.nuMap;
    }
}
