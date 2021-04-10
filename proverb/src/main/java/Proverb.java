import java.util.*;

class Proverb {

    private StringBuilder text = new StringBuilder();


    Proverb(String[] words) {

         if (words.length > 0){
             if (words.length> 1) {
                 for (int i = 1; i < words.length; i++) {
                     text.append(String.format("For want of a %s the %s was lost.\n", words[i - 1], words[i]));
                 }
             }
             text.append(String.format("And all for the want of a %s.", words[0]));
         }

    }

    String recite() {
        System.out.println("text"+ text.toString());
        return text.toString();
    }

}
