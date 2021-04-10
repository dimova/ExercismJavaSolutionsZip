import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PythagoreanTriplet {

	final int a;
	final int b;
	final int c;

	PythagoreanTriplet(final int a, final int b, final int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	static PythagoreanTripletBuilder makeTripletsList() {
		return new PythagoreanTripletBuilder();
	}

	static class PythagoreanTripletBuilder {

		private int max;
		private int sum;

		PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(final int max) {
			this.max = max;
			return this;
		}

		PythagoreanTripletBuilder thatSumTo(final int sum) {
			this.sum = sum;
			return this;
		}

		List<PythagoreanTriplet> build() {
			return IntStream.rangeClosed(1, this.max - 2)
				.mapToObj(i -> new double[] {i, this.sum *(2.0 * i - this.sum) / (2.0 * (i - this.sum))})
				.filter(pair -> pair[1] == (int) pair[1] && pair[0] < pair[1])
				.map(pair -> new PythagoreanTriplet((int) pair[0], (int) pair[1], (int) (this.sum - pair[0] - pair[1])))
				.collect(Collectors.toList());
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final PythagoreanTriplet that = (PythagoreanTriplet) o;
		return a == that.a && b == that.b && c == that.c;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b, c);
	}
}