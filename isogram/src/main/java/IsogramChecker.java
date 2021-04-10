class IsogramChecker {

    boolean isIsogram(String phrase) {
        return !phrase.matches(".*(?i)([a-z]).*\\1.*|.*(?i)[^a-z- ].*");
    }

}
