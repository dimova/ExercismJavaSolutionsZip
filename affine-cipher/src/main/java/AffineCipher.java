public class AffineCipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private static final int ALPH_LEN = ALPHABET.length();

    public String encode(String input, int a, int b) {

        this.assertKeyAAndAlphabetSizeAreCoprime(a);
        input = this.filterInput(input);
        StringBuilder encoded = new StringBuilder();
        int i = 0;

        for(char ch : input.toLowerCase().toCharArray()) {
            if(ALPHABET.indexOf(ch) != -1) {
                int alphIndex = ch - 97;
                int index = (a * alphIndex + b) % ALPH_LEN;
                encoded.append(ALPHABET.charAt(index));
            } else {
                encoded.append(ch);
            }

            i++;

            if(i%5 == 0) {
                encoded.append(" ");
            }

        }

        return this.rTrim(encoded.toString());
    }

    public String decode(String encoded, int a, int b) {

        this.assertKeyAAndAlphabetSizeAreCoprime(a);
        encoded = this.filterInput(encoded);
        StringBuilder decoded = new StringBuilder();

        for(char ch : encoded.toLowerCase().toCharArray()) {
            if(ALPHABET.indexOf(ch) != -1) {

                int alphIndex = ch - 97;
                int index = (this.findMMI(a) * (alphIndex - b)) % ALPH_LEN;
                if(index < 0) {
                    index += 26;
                }
                decoded.append(ALPHABET.charAt(index));
            } else {
                decoded.append(ch);
            }


        }

        return this.rTrim(decoded.toString());

    }


    private String filterInput(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }

    private String rTrim(String input) {
        return input.charAt(input.length() - 1) == ' ' ? input.substring(0, input.length() - 1) : input;
    }

    private void assertKeyAAndAlphabetSizeAreCoprime(int a) {
        int start = a > ALPH_LEN ? a : ALPH_LEN;
        for(int i = start - 1;i>1;i--) {
            if(ALPH_LEN % i == 0 && a % i == 0) {
                throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
            }
        }
    }

    private int findMMI(int a) {
        for(int i = ALPH_LEN - 1;i>1;i--) {
            if((a * i) % ALPH_LEN == 1) {
                return i;
            }
        }

        return a;
    }

}