public class PhoneNumber {
    private final String cleanedPhoneNumber;

    PhoneNumber(String input) {
        String strippedPhoneNumber = input.replaceAll("[-+.() ]", "");
        int l = strippedPhoneNumber.length();
        if (l < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (l == 11) {
            if (strippedPhoneNumber.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
            cleanedPhoneNumber = strippedPhoneNumber.substring(1);
        } else {
            cleanedPhoneNumber = strippedPhoneNumber;
        }
        if (l > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (cleanedPhoneNumber.matches(".*[a-z]+.*")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (cleanedPhoneNumber.matches(".*[@!:]+.*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
        if (cleanedPhoneNumber.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (cleanedPhoneNumber.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (cleanedPhoneNumber.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (cleanedPhoneNumber.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }

    public String getNumber() {
        return cleanedPhoneNumber;
    }
}
