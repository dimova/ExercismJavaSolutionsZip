import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Yacht {

    private final int[] dice;
    private final YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch (yachtCategory) {
            case YACHT -> {
                if (Arrays.stream(dice).distinct().count() == 1) {
                    return 50;
                }
            }
            case CHOICE -> {
                return Arrays.stream(dice).sum();
            }
            case BIG_STRAIGHT -> {
                int[] sortedDice = Arrays.stream(dice).sorted().toArray();
                if (sortedDice[0] == 2 && sortedDice[1] == 3 && sortedDice[2] == 4 && sortedDice[3] == 5 && sortedDice[4] == 6) {
                    return 30;
                }
            }
            case LITTLE_STRAIGHT -> {
                int[] sortedDice = Arrays.stream(dice).sorted().toArray();
                if (sortedDice[0] == 1 && sortedDice[1] == 2 && sortedDice[2] == 3 && sortedDice[3] == 4 && sortedDice[4] == 5) {
                    return 30;
                }
            }
            case FOUR_OF_A_KIND -> {
                if (Arrays.stream(dice).distinct().count() == 1) {
                    return dice[0] * 4;
                }
                if (Arrays.stream(dice).distinct().count() == 2) {
                    Map<Integer, Long> countMap = Arrays.stream(dice).boxed().collect(Collectors.groupingBy(v -> v, Collectors.counting()));
                    for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
                        if (entry.getValue() == 4L) {
                            return entry.getKey() * 4;
                        }
                    }
                }
            }
            case FULL_HOUSE -> {
                if (Arrays.stream(dice).distinct().count() == 2) {
                    Map<Integer, Long> countMap = Arrays.stream(dice).boxed().collect(Collectors.groupingBy(v -> v, Collectors.counting()));
                    if (countMap.containsValue(2L) && countMap.containsValue(3L)) {
                        return Arrays.stream(dice).sum();
                    }
                }
            }
            case SIXES -> {
                return Arrays.stream(dice).filter(v -> v == 6).sum();
            }
            case FIVES -> {
                return Arrays.stream(dice).filter(v -> v == 5).sum();
            }
            case FOURS -> {
                return Arrays.stream(dice).filter(v -> v == 4).sum();
            }
            case THREES -> {
                return Arrays.stream(dice).filter(v -> v == 3).sum();
            }
            case TWOS -> {
                return Arrays.stream(dice).filter(v -> v == 2).sum();
            }
            case ONES -> {
                return Arrays.stream(dice).filter(v -> v == 1).sum();
            }
        }
        return 0;
    }

}
