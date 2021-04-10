import java.math.BigInteger;
import java.util.Random;


public class DiffieHellman {
    
    private final Random random;
    
    public DiffieHellman() {
        this.random = new Random();
    }
    
    public BigInteger privateKey(BigInteger prime) {
        
        int pvk = 0;
        
        do {
            pvk = random.nextInt(prime.intValue());
        } while (pvk <= 1);
        
        return new BigInteger(String.valueOf(pvk));
    }

    BigInteger publicKey(BigInteger primeA, BigInteger primeB, BigInteger privateKey) {
        return primeB.modPow(privateKey, primeA);
    }

    BigInteger secret(BigInteger primeA, BigInteger otherPublicKey, BigInteger myPrivateKey) {
        return otherPublicKey.modPow(myPrivateKey, primeA);
    }
}
