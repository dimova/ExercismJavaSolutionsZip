import java.util.*;
import java.util.stream.Collectors;

public class Poker {

    private final List<PokerHand> hands;

    public Poker(List<String> hands) {
        this.hands = hands.stream().map(PokerHand::new).collect(Collectors.toList());
    }

    public List<String> getBestHands() {
        if (hands.size() == 1) return handsToString(hands);
        Collections.sort(hands);
        PokerHand best = hands.get(hands.size() - 1);
        List<PokerHand> bestHands = new ArrayList<>();
        for (int i = hands.size() - 2; i >= 0; i--) {
            if (best.compareTo(hands.get(i)) == 0) {
                bestHands.add(hands.get(i));
            } else {
                break;
            }
        }
        bestHands.add(best);
        return handsToString(bestHands);
    }

    private List<String> handsToString (List<PokerHand> list) {
        return list.stream().map(PokerHand::toString).collect(Collectors.toList());
    }


}
