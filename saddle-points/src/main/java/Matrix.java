import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Matrix {

    private List<List<Integer>> data;

    Matrix(List<List<Integer>> data) {
        this.data = data;
    }

    Set<MatrixCoordinate> getSaddlePoints() {

        if (data.size() == 0) return new HashSet<>();
        final List<Integer> rowMaxVals = data.stream()
            .mapToInt(row -> row.stream()
                .reduce((val1, val2) -> val1 < val2 ? val2 : val1).get())
            .boxed().collect(Collectors.toList());


        int maxColLen = data.stream().mapToInt(List::size).max().getAsInt();

        final List<Integer> colMinVals = IntStream.range(0, maxColLen)
            .mapToObj(i -> data.stream().map(row -> i < row.size() ? row.get(i) : null).collect(Collectors.toList())) // we have transposed matrix here
            .mapToInt(col -> col.stream().reduce((i1, i2) -> i1 < i2 ? i1 : i2).get())
            .boxed().collect(Collectors.toList());

        // map each row into a set of saddle points, then reduce them into one set
        return
            IntStream.range(0, data.size())
                .mapToObj(row ->
                    // map each row into a set of saddle point
                    IntStream.range(0, data.get(row).size())
                        .mapToObj(col ->
                            // map to coordinate if a saddle point, otherwise null
                            (data.get(row).get(col).equals(colMinVals.get(col))
                                && data.get(row).get(col).equals(rowMaxVals.get(row))) ?
                               new MatrixCoordinate(row+1, col+1) : null
                        )
                        .filter(Objects::nonNull).collect(Collectors.toSet())
                )
                .reduce((set1, set2) -> {set1.addAll(set2); return set1; }).get();
    }
}