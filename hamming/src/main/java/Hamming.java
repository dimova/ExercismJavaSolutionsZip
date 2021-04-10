public class Hamming {
    private char[] leftStrand;
    private char[] rightStrand;
    private int length;
    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.isEmpty() && !rightStrand.isBlank()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        }
        if (rightStrand.isEmpty() && !leftStrand.isBlank()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        }
        length = leftStrand.length();
        if (length != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.leftStrand = leftStrand.toCharArray();
        this.rightStrand = rightStrand.toCharArray();
    }
    public int getHammingDistance() {
        int distance = 0;
        for(int i = 0; i < length; i++ ) {
            if (leftStrand[i] != rightStrand[i]) {
                distance++;
            }
        }
        return distance;
    }
}
