class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int n) {
        var sum = n * (n + 1) / 2;
        return sum * sum;
    }

    int computeSumOfSquaresTo(int n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
