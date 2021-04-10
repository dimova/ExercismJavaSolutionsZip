import java.util.ArrayList;
import java.util.List;

class Transpose {
    Transpose() {

    }

    String transpose(String matrix) {
        List<List<Character>> matOfChar = new ArrayList<>();
        List<Character> line = new ArrayList<>();
        int maxSizeline = 0;

        char[] chars = matrix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\n' || i == chars.length  -1) {
                if(i == chars.length  -1) line.add(chars[i]);
                maxSizeline = Math.max(maxSizeline, line.size());
                System.out.println(line.toString());
                matOfChar.add(line);
                line = new ArrayList<>();
            } else {
                line.add(chars[i]);
            }
        }
        System.out.println(maxSizeline);
        System.out.println(matOfChar.size());
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < maxSizeline; i++) {
            StringBuilder stLine = new StringBuilder();

            for (int j = 0; j <matOfChar.size(); j++) {
                if (i < matOfChar.get(j).size() ) {
                    stLine.append(matOfChar.get(j).get(i));
                }else{
                    stLine.append(" ");
                }
            }

            if (i != maxSizeline - 1) stLine.append("\n");
            st.append(stLine);


        }

        return st.toString().trim();
    }
}