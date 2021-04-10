import static java.util.function.Function.identity;

import java.util.stream.IntStream;

class RectangleCounter {

	private static final char CORNER = '+';
	private static final char HORIZONTAL_LINE = '-';
	private static final char VERTICAL_LINE = '|';

	int countRectangles(final String[] inputGrid) {

		final int width = inputGrid.length > 0 ? inputGrid[0].length() : 0;
		final int height = inputGrid.length;

		return IntStream.range(0, width - 1)
			.mapToObj(left -> IntStream.range(0, height - 1)
				.filter(top -> this.isCorner(inputGrid, left, top))
				.mapToObj(top -> IntStream.range(left + 1, width)
					.filter(right -> this.isCorner(inputGrid, right, top))
					.mapToObj(right -> IntStream.range(top + 1, height)
						.filter(bottom -> this.isRectangle(inputGrid, left, top, right, bottom))
						.count())))
			.flatMap(identity())
			.flatMapToInt(list -> list.mapToInt(Long::intValue))
			.sum();
	}

	private boolean isRectangle(final String[] inputGrid, final int left, final int top, final int right, final int bottom) {
		return this.isCorner(inputGrid, left, bottom)
			&& this.isCorner(inputGrid, right, bottom)
			&& this.isHorizontalLine(inputGrid, top, left, right)
			&& this.isHorizontalLine(inputGrid, bottom, left, right)
			&& this.isVerticalLine(inputGrid, left, top, bottom)
			&& this.isVerticalLine(inputGrid, right, top, bottom);
	}

	private boolean isCorner(final String[] inputGrid, final int x, final int y) {
		return inputGrid[y].charAt(x) == CORNER;
	}

	private boolean isHorizontalLine(final String[] inputGrid, final int y, final int left, final int right) {
		return IntStream.range(left + 1, right)
			.allMatch(x -> (inputGrid[y].charAt(x) == HORIZONTAL_LINE || inputGrid[y].charAt(x) == CORNER));
	}

	private boolean isVerticalLine(final String[] inputGrid, final int x, final int top, final int bottom) {
		return IntStream.range(top + 1, bottom)
			.allMatch(y -> (inputGrid[y].charAt(x) == VERTICAL_LINE || inputGrid[y].charAt(x) == CORNER));
	}

}
