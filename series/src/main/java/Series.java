import java.util.ArrayList;
import java.util.List;

class Series{
    private String serie;
    Series (String serie){
        this.serie=serie;
    }
    List<String> slices(int slice){
        List<String> slices=new ArrayList<>();
        if(slice>serie.length()) throw new IllegalArgumentException("Slice size is too big.");
        else if(slice<=0) throw new IllegalArgumentException("Slice size is too small.");
        else{
            for (int i = 0; i <=serie.length()-slice; i++) {
                slices.add(this.serie.substring(i,i+slice));
            }
        }
        return slices;
    }
}
