import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class RunLengthEncoding
{
    String encode(String data)
    {
        char[] arr = data.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (i != arr.length - 1 && arr[i] == arr[i + 1]) {
                count++;
            } else {
                if (++count > 1)
                    result.append(count);
                result.append(arr[i]);
                count = 0;
            }
        }
        return result.toString();
    }

    String decode(String encoded)
    {
        StringBuilder result = new StringBuilder();
        List<String> compressedList = Pattern.compile("\\d*[a-zA-Z\\s]").
                            matcher(encoded).
                            results().
                            map(MatchResult::group).
                            collect(Collectors.toList());
        for (String s : compressedList)
        {
            int count = 1;
            if (s.length() > 1)
                count = Integer.parseInt(s.substring(0, s.length() - 1));
            char letter = s.charAt(s.length() - 1);
            result.append(String.valueOf(letter).repeat(count));
        }
        return result.toString();
    }
}
