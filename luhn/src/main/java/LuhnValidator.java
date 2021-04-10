class LuhnValidator {

    boolean isValid(String candidate) {
        String cleanString = candidate.replace(" ", "");
        if (!cleanString.matches("\\d{2,}")) {
            return false;
        }
        String reversedString = new StringBuilder(cleanString).reverse().toString();
        int sumOfDigits = 0;
        for (int i = 0; i < reversedString.length(); i++) {
            int digit = Integer.parseInt(reversedString.substring(i, i + 1));
            if (i % 2 == 0) {
                sumOfDigits += digit;
            } else {
                int doubledDigit = 2 * digit;
                sumOfDigits += doubledDigit > 9 ? doubledDigit - 9 : doubledDigit;
            }
        }
        return sumOfDigits % 10 == 0;
    }
}
