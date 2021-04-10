import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {

        if ((square <= 64) && (square >= 2)) {
            return new BigInteger("2").pow(square - 1);
        } else if (square == 1) {
            return new BigInteger("1");
        } else
            throw new IllegalArgumentException("square must be between 1 and 64");
    }

    BigInteger grainsOnBoard() {
        return new BigInteger("2").pow(64).subtract(new BigInteger("1"));
    }
}
