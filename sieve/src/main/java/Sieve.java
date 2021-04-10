import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
    private final List<Integer> primes;

    Sieve(int maxPrime) {
        primes = IntStream.rangeClosed(2, maxPrime).boxed().collect(Collectors.toList());

        IntStream.rangeClosed(2, (int) Math.sqrt(maxPrime))
                .forEach(i -> {
                    int j = 2;
                    int product = i * j;
                    while (product <= maxPrime) {
                        primes.remove((Integer) product);
                        product = i * (++j);
                    }
                });
    }

    List<Integer> getPrimes() {
        return primes;
    }
}
