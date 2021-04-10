import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {
    private final int sum;

    SumOfMultiples(int number, int[] set) {
        sum = IntStream.range(1, number)
                .filter(i -> Arrays.stream(set).anyMatch(n -> n > 0 && i % n == 0))
                .sum();
    }

    int getSum() {
        return sum;
    }
}