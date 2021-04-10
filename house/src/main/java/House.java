class House{
    static final String[] thisIs={
            "the house that Jack built",
            "the malt",
            "the rat",
            "the cat",
            "the dog","the cow with the crumpled horn",
            "the maiden all forlorn",
            "the man all tattered and torn",
            "the priest all shaven and shorn",
            "the rooster that crowed in the morn",
            "the farmer sowing his corn",
            "the horse and the hound and the horn"
    };

    static final String[] that={
            "lay in the house that Jack built",
            "ate the malt",
            "killed the rat",
            "worried the cat",
            "tossed the dog",
            "milked the cow with the crumpled horn",
            "kissed the maiden all forlorn",
            "married the man all tattered and torn",
            "woke the priest all shaven and shorn",
            "kept the rooster that crowed in the morn",
            "belonged to the farmer sowing his corn"
    };
    String verse(int num){
        StringBuilder verse=new StringBuilder();
        verse.append("This is ").append(thisIs[num-1]);
        for (int i = num-2; i >=0 ; i--) {
            verse.append(" that ").append(that[i]);
        }
        return verse.append(".").toString();
    }

    String verses(int start,int end){
        StringBuilder verses=new StringBuilder();
        for (int i = start; i <end ; i++) {
            verses.append(verse(i)).append("\n");
        }
        verses.append(verse(end));
        return verses.toString();
    }
    String sing(){
        return verses(1,12);
    }
}