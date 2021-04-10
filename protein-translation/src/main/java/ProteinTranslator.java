import java.util.List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

class ProteinTranslator {
    Map<String, String> dict = new HashMap<>();
    public ProteinTranslator(){
        dict.put("AUG","Methionine");
        dict.put("UUU","Phenylalanine");
        dict.put("UUC","Phenylalanine");
        dict.put("UUA","Leucine");
        dict.put("UUG","Leucine");
        dict.put("UCU","Serine");
        dict.put("UCC","Serine");
        dict.put("UCA","Serine");
        dict.put("UCG","Serine");
        dict.put("UAU","Tyrosine");
        dict.put("UAC","Tyrosine");
        dict.put("UGU","Cysteine");
        dict.put("UGC","Cysteine");
        dict.put("UGG","Tryptophan");
        dict.put("UAA","STOP");
        dict.put("UAG","STOP");
        dict.put("UGA","STOP"); 
    }
    
    ArrayList<String> translate(String rnaSequence) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<rnaSequence.length()-2;i+=3){
            String str = rnaSequence.substring(i,i+3);
            if(dict.get(str).equals("STOP")) break;
            list.add(dict.get(str));
        }
        return list;
    }   
}
