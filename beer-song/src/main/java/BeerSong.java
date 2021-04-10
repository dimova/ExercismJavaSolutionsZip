public class BeerSong {

    private static class BeerBuilder {
        private StringBuilder result = new StringBuilder();
        private int n;
        private boolean addSpace = false;

        public static BeerBuilder with(int n) {
            return new BeerBuilder(n);
        }

        private BeerBuilder(int n) {
            this.n = n;
        }

        private BeerBuilder add(String s) {
            if (addSpace) {
                result.append(" ");
            }

            result.append(s);
            addSpace = true;
            return this;
        }

        public BeerBuilder count() { return add(n == 0 ? "no more" : Integer.toString(n)); }

        public BeerBuilder bottles() { return add(n == 1 ? "bottle" : "bottles"); }

        public BeerBuilder ofBeer() { return add("of beer"); }

        public BeerBuilder onTheWall() { return add("on the wall"); }

        public BeerBuilder takeOneDownOrGoToTheStore() {
            String s;

            if (n == 0) {
                s = "Go to the store and buy some more";
            } else {
                s = "Take " + (n == 1 ? "it" : "one") + " down and pass it around";
            }

            n = n == 0 ? 99 : n - 1;
            return add(s);
        }

        public BeerBuilder comma() {
            result.append(",");
            return this;
        }

        public BeerBuilder endLine() {
            result.append(".\n");
            addSpace = false;
            return this;
        }

        @Override
        public String toString() {
            String res = result.toString();
            return Character.toUpperCase(res.charAt(0)) + res.substring(1);
        }
    }

    public static String verse(int n) {
        return BeerBuilder.with(n)
                .count().bottles().ofBeer().onTheWall().comma().count().bottles().ofBeer().endLine()
                .takeOneDownOrGoToTheStore().comma().count().bottles().ofBeer().onTheWall().endLine()
                .toString() + "\n";
    }

    public static String sing(int n1, int n2) {
        StringBuilder res = new StringBuilder();
        for (int i = n1; i>=n2; i--) {
            res.append(verse(i));
        }

        return res.toString();
    }

    public static String singSong() {
        return sing(99, 0);
    }
}