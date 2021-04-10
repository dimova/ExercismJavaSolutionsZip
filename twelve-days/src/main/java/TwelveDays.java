class TwelveDays {

    public TwelveDays() {
    }

    String verse(int verseNumber) {

        StringBuilder sentence = new StringBuilder(composeFirstSentence(convertNumbertoVerse(verseNumber)));

        for (int i = verseNumber; i > 0; i--) {
            if (verseNumber > 1 && i == 1) {
                sentence.append("and ");
            }
            sentence.append(gift(i));
            if (i != 1) {
                sentence.append(", ");
            }
        }
        sentence.append(".\n");
        return sentence.toString();
    }

    String verses(int startVerse, int endVerse) {
        StringBuilder verses = new StringBuilder();

        for (int i = startVerse; i < endVerse; i++) {
            verses.append(verse(i));
            verses.append("\n");
        }
        verses.append(verse(endVerse));
        return verses.toString();
    }

    String sing() {
        return verses(1, 12);
    }

    private String convertNumbertoVerse(int verse) {

        switch (verse) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "fourth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                return null;
        }
    }

    private String gift(int verse) {

        switch (verse) {
            case 1:
                return "a Partridge in a Pear Tree";
            case 2:
                return "two Turtle Doves";
            case 3:
                return "three French Hens";
            case 4:
                return "four Calling Birds";
            case 5:
                return "five Gold Rings";
            case 6:
                return "six Geese-a-Laying";
            case 7:
                return "seven Swans-a-Swimming";
            case 8:
                return "eight Maids-a-Milking";
            case 9:
                return "nine Ladies Dancing";
            case 10:
                return "ten Lords-a-Leaping";
            case 11:
                return "eleven Pipers Piping";
            case 12:
                return "twelve Drummers Drumming";
            default:
                return null;
        }
    }

    private String composeFirstSentence(String day) {
        return "On the " + day + " day of Christmas my true love gave to me: ";
    }
}
