import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Card> cards;
    private final Map<Integer,Long> histogram;
    private final PokerHandType type;
    private final String handAsString;

    public PokerHand(String handAsString) {
        this.handAsString = handAsString;
        this.cards = Arrays.stream(handAsString.split("\\s"))
                .map(Card::new)
                .sorted(Comparator.comparing(Card::getNumericValue))
                .collect(Collectors.toList());
        this.histogram = getHistogram();
        this.type = determineType();
    }

    public PokerHandType getType() {
        return type;
    }

    private PokerHandType determineType() {
        List<Integer> rep = getRepetitions();
        if (rep.size() == 4) return PokerHandType.PAIR;
        if (rep.contains(4)) return PokerHandType.FOUR;
        else if (rep.contains(3)) {
            if (rep.contains(2)) return PokerHandType.FULL;
            else if (rep.contains(1)) return PokerHandType.THREE;
        }
        else if(rep.containsAll(List.of(2,2,1))) return PokerHandType.TWO_PAIR;
        else {
            boolean straight = isStraight(cards);
            boolean flush = isFlush(cards);
            if (straight && flush) return PokerHandType.STRAIGHT_FLUSH;
            else if (straight) return PokerHandType.STRAIGHT;
            else if (flush) return PokerHandType.FLUSH;
        }
        return PokerHandType.HIGH;
    }

    private boolean isFlush(List<Card> cards) {
        int aux = (int) cards.stream().map(Card::getSuite).distinct().count();
        return aux == 1;
    }

    private boolean isStraight(List<Card> sortedCards) {
        int highest = sortedCards.get(sortedCards.size() - 1).getNumericValue();
        int lowest = sortedCards.get(0).getNumericValue();
        if (highest == 14 && lowest == 2) { //If there is an Ace and a two, the ace ranks low
            highest = sortedCards.get(sortedCards.size() - 2).getNumericValue();
            lowest = 1;
        }
        return highest - lowest == 4;
    }

    private List<Integer> getRepetitions() {
        return histogram.values().stream().mapToInt(Long::intValue).boxed().collect(Collectors.toList());
    }

    private Map<Integer,Long> getHistogram() {
        return cards.stream().collect(groupingBy(Card::getNumericValue, counting()));
    }

    private List<Integer> getCardsRepeated(int times) {
        return histogram.entrySet().stream()
                .filter(e -> e.getValue() == times)
                .map(Map.Entry::getKey)
                .collect(toList());
    }


    @Override
    public String toString() {
        return this.handAsString;
    }

    @Override
    public int compareTo(PokerHand o) {
        if (this.getType() != o.getType()) {
            return this.getType().compareTo(o.getType());
        } else {
            return this.compareType(this,o);
        }
    }

    private int compareType(PokerHand hand, PokerHand other) {
        switch (hand.getType()) {
            case HIGH:
            case FLUSH: return compareKickers(hand,other);
            case PAIR: return comparePair(hand, other);
            case TWO_PAIR: return compareTwoPair(hand, other);
            case THREE: return compareThree(hand, other);
            case STRAIGHT:
            case STRAIGHT_FLUSH: return compareStraight(hand, other);
            case FULL: return compareFull(hand, other);
            case FOUR: return compareFour(hand, other);
            default: throw new IllegalArgumentException();
        }
    }

    private int compareKickers(PokerHand hand, PokerHand other) {
        List<Integer> kickers = hand.getCardsRepeated(1);
        List<Integer> otherKickers = other.getCardsRepeated(1);
        int aux = 0;
        for (int i = kickers.size() - 1; i >= 0; i--) {
            aux = Integer.compare(kickers.get(i), otherKickers.get(i));
            if (aux != 0) break;
        }
        return aux;
    }

    private int comparePair(PokerHand hand, PokerHand other) {
        int pairValue = hand.getCardsRepeated(2).get(0);
        int otherPairValue = other.getCardsRepeated(2).get(0);
        int aux = Integer.compare(pairValue, otherPairValue);
        if (aux == 0) {
            aux = compareKickers(hand, other);
        }
        return aux;
    }

    private int compareTwoPair(PokerHand hand, PokerHand other) {
        List<Integer> pairs = hand.getCardsRepeated(2);
        List<Integer> otherPairs = other.getCardsRepeated(2);
        int aux = Integer.compare(pairs.get(1),otherPairs.get(1));
        if (aux == 0) {
            aux = Integer.compare(pairs.get(0), otherPairs.get(0));
            if (aux == 0) {
                int kicker = hand.getCardsRepeated(1).get(0);
                int otherKicker = other.getCardsRepeated(1).get(0);
                aux = Integer.compare(kicker, otherKicker);
            }
        }
        return aux;
    }

    private int compareThree(PokerHand hand, PokerHand other) {
        int threeValue = hand.getCardsRepeated(3).get(0);
        int otherThreeValue = other.getCardsRepeated(3).get(0);
        int aux = Integer.compare(threeValue, otherThreeValue);
        if (aux == 0) return compareKickers(hand, other);
        else return aux;
    }

    private int compareStraight(PokerHand hand, PokerHand other) {
        int highest = hand.cards.get(4).getNumericValue();
        if (highest == 14 && hand.cards.get(0).getNumericValue() == 2) {
            highest = hand.cards.get(3).getNumericValue();
        }
        int otherHighest = other.cards.get(4).getNumericValue();
        if (otherHighest == 14 && other.cards.get(0).getNumericValue() == 2) {
            otherHighest = other.cards.get(3).getNumericValue();
        }
        return Integer.compare(highest, otherHighest);
    }

    private int compareFull(PokerHand hand, PokerHand other) {
        int tripletValue = hand.getCardsRepeated(3).get(0);
        int otherTripletValue = other.getCardsRepeated(3).get(0);
        int aux = Integer.compare(tripletValue, otherTripletValue);
        if (aux == 0) {
            int pair = hand.getCardsRepeated(2).get(0);
            int otherPair = other.getCardsRepeated(2).get(0);
            aux = Integer.compare(pair, otherPair);
        }
        return aux;
    }

    private int compareFour(PokerHand hand, PokerHand other) {
        int squareValue = hand.getCardsRepeated(4).get(0);
        int otherSquareValue = other.getCardsRepeated(4).get(0);
        int aux = Integer.compare(squareValue, otherSquareValue);
        if (aux == 0) {
            aux = compareKickers(hand, other);
        }
        return aux;
    }


}
