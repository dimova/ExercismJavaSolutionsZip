import java.util.ArrayList;
import java.util.List;

class NaturalNumber {
    private int num;

    NaturalNumber(int num) {
        if(num<1) throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        this.num = num;
    }

    Classification getClassification() {
        if(num==1) return Classification.DEFICIENT;
        List<Integer> factors = findFactorsWithoutTheNumber(this.num);
      
        int sum = 0;
        for (int x :
                factors) {
            sum += x;
        }


        if(sum==this.num) return Classification.PERFECT;
        if(sum>this.num) return Classification.ABUNDANT;

        return Classification.DEFICIENT;

    }

    List<Integer> findFactorsWithoutTheNumber(int input) {
        List<Integer> fac = new ArrayList<>();
        fac.add(1);
        int square = (int) Math.floor(Math.sqrt(input));
        for (int i = 2; i <= square; i++) {
            if (input % i == 0) {
                int k=input / i;
                if(i!=k){
                    fac.add(input / i);
                }
                fac.add(i);
            }
        }
        return fac;
    }


}
enum Classification {

    DEFICIENT, PERFECT, ABUNDANT

}
