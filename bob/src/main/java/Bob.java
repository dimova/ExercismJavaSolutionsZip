public class Bob {

    private final static String DEFAULT_RESPONSE = "Whatever.";
    private final static String WHOA_RESPONSE = "Whoa, chill out!";
    private final static String SURE_RESPONSE = "Sure.";
    private final static String INDIGNANT_RESPONSE = "Fine. Be that way!";

    public String hey(String request){
        if (request.trim().length() == 0) return INDIGNANT_RESPONSE;
        if (isYelling(request)) return WHOA_RESPONSE;
        if (request.endsWith("?")) return SURE_RESPONSE;
        return DEFAULT_RESPONSE;
    }

    private boolean isYelling(String request){
        String yelled = request.toUpperCase();
        String whispered = request.toLowerCase();
        return !request.equals(whispered) && request.equals(yelled);
    }
}
