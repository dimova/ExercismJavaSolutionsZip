public class Queen {

    final int i;
    final int j;
  
    public Queen(int i, int j) {
      validate(i, "row");
      validate(j, "column");
      this.i = i;
      this.j = j;
    }
  
    private void validate(int index, String name) {
      if (index < 0) {
        throw new IllegalArgumentException("Queen position must have positive " + name + ".");
      }
      if (index > 7) {
        throw new IllegalArgumentException("Queen position must have " + name + " <= 7.");
      }
    }
  }