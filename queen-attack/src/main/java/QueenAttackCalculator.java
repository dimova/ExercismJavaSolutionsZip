import java.util.Objects;
import java.util.stream.Stream;

public class QueenAttackCalculator {

  private final Queen white;
  private final Queen black;

  public QueenAttackCalculator(Queen white, Queen black) {
    this.white = white;
    this.black = black;
    if (Stream.of(white, black).anyMatch(Objects::isNull)) {
      throw new IllegalArgumentException("You must supply valid positions for both Queens.");
    }
    if (white.i == black.i && white.j == black.j) {
      throw new IllegalArgumentException("Queens cannot occupy the same position.");
    }
  }

  public boolean canQueensAttackOneAnother() {
    return white.i == black.i
        || white.j == black.j
        || white.i - black.i == -(white.j - black.j)
        || white.i - black.i == white.j - black.j;
  }
}