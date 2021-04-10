import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PrimeFactorsCalculator {


    List<Long> calculatePrimeFactorsOf(Long num) {
        List<Long> factors = new ArrayList<>();
        long i = 2L;
        while ( num!=1L) {
            if (isPrime(i) && num % i == 0 ) {
                factors.add(i);
                num=num/i;
            }else{
                i++;
            }
        }

        return factors;
    }

    boolean isPrime(long l) {
        if (l <= 1) return false;
        for (int i = 2; i < Math.sqrt(l); i++) {
            if (l % i == 0) return false;
        }
        return true;
    }
}
