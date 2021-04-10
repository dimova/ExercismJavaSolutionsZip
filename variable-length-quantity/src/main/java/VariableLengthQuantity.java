import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class VariableLengthQuantity {

  private static final String HEX_PATTERN = "0x%x";

  List<String> encode(List<Long> numbers) {
    List<String> encoded = new ArrayList<>();
    for (Long number : numbers) {
      encoded.addAll(encodeOne(number));
    }
    return encoded;
  }

  private List<String> encodeOne(Long number) {
    List<String> encoded = new ArrayList<>();
    if (number == 0) {
      encoded.add(String.format(HEX_PATTERN, 0));
    }
    while (number > 0) {
      int bits = (int) (number & 127);
      number >>= 7;
      if (!encoded.isEmpty()) {
        bits |= 128;
      }
      encoded.add(String.format(HEX_PATTERN, bits));
    }
    Collections.reverse(encoded);
    return encoded;
  }

  List<String> decode(List<Long> bytes) {
    List<String> decoded = new ArrayList<>();
    List<Long> encoded = new ArrayList<>();
    for (Long aByte : bytes) {
      encoded.add(aByte);
      if ((aByte & 128) != 128) {
        decoded.add(decodeOne(encoded));
        encoded.clear();
      }
    }
    if (!encoded.isEmpty()) {
      throw new IllegalArgumentException("Invalid variable-length quantity encoding");
    }
    return decoded;
  }

  private String decodeOne(List<Long> bytes) {
    long decoded = 0;
    for (Long aByte : bytes) {
      decoded <<= 7;
      aByte &= 127;
      decoded |= aByte;
    }
    return String.format(HEX_PATTERN, decoded);
  }
}
