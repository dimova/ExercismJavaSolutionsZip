import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char ch) {
        if (!Character.isLetter(ch)) return Collections.emptyList();
        int diff = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
        int length = 2 * diff + 1;
        int halfLength = length / 2;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strings.add(" ".repeat(length));
        }

        char a = 'A';
        for (int i = 0; i <= halfLength; i++, a++) {
            int leftIndex = halfLength - i;
            int rightIndex = halfLength + i;
            char[] upperString = strings.get(i).toCharArray();
            char[] lowerString = strings.get(strings.size() - 1 - i).toCharArray();

            upperString[leftIndex] = a;
            upperString[rightIndex] = a;
            lowerString[leftIndex] = a;
            lowerString[rightIndex] = a;
            strings.set(i, new String(upperString));
            strings.set(strings.size() - 1 - i, new String(lowerString));
        }
        return strings;
    }
}
