public class WordProblemSolver {

    public int solve(String input) {
        if (!input.matches("^What is -?\\d+( (plus|minus|multiplied by|divided by) (-?\\d+))*\\?$")) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        String[] entries = input.replaceAll("(What is | by|\\?)", "").split(" ");

        //The following works with the provided test cases i.e. only when input and result are within int range.
        //Every element at an uneven index will be an operator, followed by and operand.
        int result = Integer.parseInt(entries[0]);    //The first operand needs to be set before applying the operator and other operand.
        for (int i = 1; i + 1 < entries.length; i += 2) {
            switch (entries[i]) {
                case "plus" -> result += Integer.parseInt(entries[i + 1]);
                case "minus" -> result -= Integer.parseInt(entries[i + 1]);
                case "multiplied" -> result *= Integer.parseInt(entries[i + 1]);
                case "divided" -> result /= Integer.parseInt(entries[i + 1]);
            }
        }
        return result;
    }
}
