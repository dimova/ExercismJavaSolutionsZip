import java.util.stream.Collectors;

class Atbash
{
    String encode(String data)
    {
        return transform(data).replaceAll(".{5}(?=.)", "$0 ");
    }
    String decode(String encodedData)
    {
        return transform(encodedData);
    }
    private String transform(String data)
    {
        return data.toLowerCase().chars().mapToObj(c -> (char)c).
                filter(Character::isLetterOrDigit).
                map(c -> Character.isLetter(c) ? (char)(122 - (c - 97)) : c).
                map(String::valueOf).
                collect(Collectors.joining());
    }
}
