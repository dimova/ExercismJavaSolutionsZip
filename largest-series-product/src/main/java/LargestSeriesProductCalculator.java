import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private final List<Integer> digits;

    LargestSeriesProductCalculator(String inputNumber) {
        if (!inputNumber.matches("\\d*")) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.digits = inputNumber.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if (numberOfDigits < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        if (numberOfDigits > digits.size()) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        return IntStream
                .rangeClosed(0, digits.size() - numberOfDigits)
                .mapToLong(i -> digits.subList(i, i + numberOfDigits).stream().reduce(1, (s, e) -> s * e))
                .max()
                .orElse(0L);
    }
}
