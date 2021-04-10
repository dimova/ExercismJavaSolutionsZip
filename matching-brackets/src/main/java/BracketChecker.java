import java.util.*;

public class BracketChecker {

    static final Map<Character, Character> bracketsMap;

    static {
        Map<Character, Character> h = new HashMap<>();

        h.put('}', '{');
        h.put(')', '(');
        h.put(']', '[');

        bracketsMap = h;
    }

    boolean bracketsMatchedAndNestedCorrectly = true;

    public BracketChecker(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (bracketsMap.containsValue(c))
                stack.push(c);

            if (bracketsMap.containsKey(c))
                if (!stack.empty() && bracketsMap.get(c).equals(stack.peek()))
                    stack.pop();
                else bracketsMatchedAndNestedCorrectly = false;
        }

        if (!stack.empty())
            bracketsMatchedAndNestedCorrectly = false;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        return bracketsMatchedAndNestedCorrectly;
    }
}
