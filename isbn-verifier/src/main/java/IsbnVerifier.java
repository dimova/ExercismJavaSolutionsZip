class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        stringToVerify = stringToVerify.replaceAll("-", "");
        char[] symbols = stringToVerify.toCharArray();
        if (symbols.length != 10)
            return false;

        int[] numbers = new int[10];
        for (int pos = 0; pos < 10; pos++) {
            if (pos == 9 && symbols[pos] == 'X') {
                numbers[9] = 10;
                continue;
            }

            numbers[pos] = Character.getNumericValue(symbols[pos]);
            if (numbers[pos] < 0 || numbers[pos] > 9)
                return false;
        }

        return verify(numbers);
    }

    private boolean verify(int[] numbers) {
        return (numbers[0] * 10
                + numbers[1] * 9
                + numbers[2] * 8
                + numbers[3] * 7
                + numbers[4] * 6
                + numbers[5] * 5
                + numbers[6] * 4
                + numbers[7] * 3
                + numbers[8] * 2
                + numbers[9] * 1)
                % 11 == 0;
    }
}