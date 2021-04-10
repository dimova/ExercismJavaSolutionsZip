import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum CardSuite {
    CLUBS('C'),
    SPADES('S'),
    DIAMONDS('D'),
    HEARTS('H');

    private final char label;
    private static final Map<Character,CardSuite> BY_LABEL;

    static {
        BY_LABEL = new HashMap<>();
        Arrays.stream(values()).forEach(c -> BY_LABEL.put(c.label,c));
    }

    CardSuite(char label) {
        this.label = label;
    }

    public static CardSuite valueOfLabel(char label) {
        return BY_LABEL.get(label);
    }
}
