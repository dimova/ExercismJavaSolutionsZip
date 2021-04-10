public class PangramChecker {
    public boolean isPangram(String input)
    {
        return input.toLowerCase().chars().distinct().filter(Character::isAlphabetic).count() == 26;
    }

}
