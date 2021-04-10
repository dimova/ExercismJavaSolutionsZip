import java.util.*;


@SuppressWarnings("ALL")
public class Say{
    final static long MAX_NUMBER = 999_999_999_999L;
    private static final String HYPHEN = "-";
    private static final String hundred = "hundred";
    private static final String thousand = "thousand";
    private static final String million = "million";
    private static final String billion = "billion";


    private static final Map<Long, String> NUMBERS = new HashMap<>(
    );
    private static void init(){
        NUMBERS.put(0L, "zero");
        NUMBERS.put(1L, "one");
        NUMBERS.put(2L, "two");
        NUMBERS.put(3L, "three");
        NUMBERS.put(4L, "four");
        NUMBERS.put(5L, "five");
        NUMBERS.put(6L, "six");
        NUMBERS.put(7L, "seven");
        NUMBERS.put(8L, "eight");
        NUMBERS.put(9L, "nine");
        NUMBERS.put(10L, "ten");
        NUMBERS.put(11L, "eleven");
        NUMBERS.put(12L, "twelve");
        NUMBERS.put(13L, "thirteen");
        NUMBERS.put(14L, "fourteen");
        NUMBERS.put(15L, "fifteen");
        NUMBERS.put(16L, "sixteen");
        NUMBERS.put(17L, "seventeen");
        NUMBERS.put(18L, "eighteen");
        NUMBERS.put(19L, "nineteen");
        NUMBERS.put(20L, "twenty");
        NUMBERS.put(30L, "thirty");
        NUMBERS.put(40L, "forty");
        NUMBERS.put(50L, "fifty");
        NUMBERS.put(60L, "sixty");
        NUMBERS.put(70L, "seventy");
        NUMBERS.put(80L, "eighty");
        NUMBERS.put(90L, "ninety");
    }

    private static String handleTens(long x) {
        if(x<=20)
            return NUMBERS.getOrDefault(x, "Not found");
        else
            return NUMBERS.getOrDefault(x/10*10, "Not found")+
                    HYPHEN+NUMBERS.get(x%(x/10*10));
    }
    private static String handleHundreds(long x) {
        if(x==100)
            return "one hundred";
        else if (NUMBERS.containsKey(x % ((x / 100) * 100)))
            return NUMBERS.get(x / 100) + " " + hundred + " " + NUMBERS.get(x % (x / 100 * 100));
        else {
            String s = "";
            long y = x / 100;
            s += NUMBERS.get(y) + " " + hundred + " ";
            y = x % (y * 100);
            s += NUMBERS.getOrDefault(y / 10 * 10, "Not found") +
                    HYPHEN + NUMBERS.get(y % (y / 10 * 10));
            return s;
        }
    }

    private static String handleThousands(long x) {
        if(x==1000)
            return "one thousand";
        else {
            String s = "";
            long y = x / 1000;
            if (y < 100)
                s += handleTens(y);
            else s += handleHundreds(y);

            s += " " + thousand + " ";

            return s + handleHundreds(x % (y * 1000));
        }
    }
    @SuppressWarnings("SuspiciousNameCombination")
    private static String handleMillions(long x){
        if(x == 1_000_000)
            return "one million";
        else {
            String s = "";
            long y = x / 1_000_000;
            if (y < 100)
                s += handleTens(y);
            else s += handleHundreds(y);

            s += " " + million + " ";
            return s + handleThousands(x % (y * 1_000_000));
        }
    }

    private static String handleBillions(long x){
        if(x == 1_000_000_000)
            return "one billion";
        else {
            String s = "";
            long y = x / 1_000_000_000;
            if (y < 100)
                s += handleTens(y);
            else s += handleHundreds(y);

            s += " " + billion + " ";
            return s + handleMillions(x % (y * 1_000_000_000));
        }
    }

    public static String say(final long x) {
        init();
        if(x<0 || x>MAX_NUMBER)
            throw new IllegalArgumentException();
        if(x<100)
           return handleTens(x);
        else if(x<1000) {
           return handleHundreds(x);
        }
        else if(x<1_000_000)
            return handleThousands(x);
        else if(x<1_000_000_000)
            return handleMillions(x);
        else
            return handleBillions(x);
    }
}

