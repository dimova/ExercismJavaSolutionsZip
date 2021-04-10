import java.util.TreeMap;

/**
 * Created by iryna on 20.05.16.
 */
public class RomanNumeral {

    private final static TreeMap<Integer, String> mapper = new TreeMap<>();
    static {
        mapper.put(1000, "M");
        mapper.put(900, "CM");
        mapper.put(500, "D");
        mapper.put(400, "CD");
        mapper.put(100, "C");
        mapper.put(90, "XC");
        mapper.put(50, "L");
        mapper.put(40, "XL");
        mapper.put(10, "X");
        mapper.put(9, "IX");
        mapper.put(5, "V");
        mapper.put(4, "IV");
        mapper.put(1, "I");
        mapper.put(0, "");
    }

    private final int number;

    public RomanNumeral(int number) {
        this.number = number;
    }

    public String convertToRoman(int number) {
        Integer closestKey  = mapper.floorKey(number);
        if (closestKey == number) {
            return mapper.get(number);
        }
        return mapper.get(closestKey) + convertToRoman(number-closestKey);
    }

    public String getRomanNumeral() {
        return convertToRoman(number);
    }
}