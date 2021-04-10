class RotationalCipher {

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public String rotate(String data) {
        char[] chars = data.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (Character.isAlphabetic(chars[i])) {
                if (Character.isLowerCase(chars[i]))
                    chars[i] = (char) (((int) chars[i] + this.shiftKey - 97) % 26 + 97);
                else if (Character.isUpperCase(chars[i]))
                    chars[i] = (char) (((int) chars[i] + this.shiftKey - 65) % 26 + 65);
            }
        }
        return new String(chars);
    }
}