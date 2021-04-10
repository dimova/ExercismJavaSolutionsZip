import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cipher {

  private String key;

  public Cipher(String key) {
    this.key = key;
  }

  public Cipher() {
    this(generateKey());
  }

  private static String generateKey() {
    return IntStream.range(0,100)
        .mapToObj(i -> Character.toString('a' + (int)(Math.random()*26)))
        .collect(Collectors.joining(""));
  }

  private char translate(char ch, int i, int sign) {
    return (char) ((ch - 'a' + sign * (key.charAt(i % key.length()) - 'a') + 26) % 26 + 'a');
  }

  public String getKey() {
    return key;
  }

  public String encode(String plainText) {
    return IntStream.range(0, plainText.length())
        .mapToObj( i -> Character.toString(translate(plainText.charAt(i), i, +1)))
        .collect(Collectors.joining(""));
  }

  public String decode(String cipherText) {
    return IntStream.range(0, cipherText.length())
        .mapToObj( i -> Character.toString(translate(cipherText.charAt(i), i, -1)))
        .collect(Collectors.joining(""));
  }
}
