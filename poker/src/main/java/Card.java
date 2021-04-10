public class Card{

    private final char value;
    private final CardSuite suite;

    public Card(String stringRepresentation) {
        int size = stringRepresentation.length();
        this.value = size == 3 ? 'T' : stringRepresentation.charAt(0);
        this.suite = CardSuite.valueOfLabel(stringRepresentation.charAt(size - 1));
    }

       public int getNumericValue() {
        switch (value) {
            case 'T': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14; //Ace is always high except in five-high straights
            default: return value - '0';
        }
    }

    public CardSuite getSuite() {
        return suite;
    }
}
enum PokerHandType {
    HIGH,
    PAIR,
    TWO_PAIR,
    THREE,
    STRAIGHT,
    FLUSH,
    FULL,
    FOUR,
    STRAIGHT_FLUSH
}