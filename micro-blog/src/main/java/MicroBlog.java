class MicroBlog {
     public String truncate(String input) {
        if (input.length() > 5)
            return input.substring(0,5);
        return input;
    }
}
