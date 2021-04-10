import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Alphametics {

	private static final List<Integer> DIGITS = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	private static final String NOT_LETTER = "[^A-Z]+";

	private final Map<Character, Integer> solution;

	Alphametics(final String problem) {

		final List<String> words = Stream.of(problem.split(NOT_LETTER)).collect(toList());

		final List<Character> chars = problem.replaceAll(NOT_LETTER, "").chars()
			.distinct()
			.mapToObj(i -> (char) i)
			.collect(toList());

		final List<Character> leadingChars = words.stream()
			.map(word -> word.charAt(0))
			.distinct()
			.collect(toList());

		final List<List<Integer>> permutations = this.partialPermutations(Collections.emptyList(), DIGITS, chars.size());

		this.solution = permutations.stream().parallel()
			.map(permutation -> IntStream.range(0, permutation.size()).boxed()
				.collect(toMap(chars::get, permutation::get)))
			.filter(this.hasNoLeadingZero(leadingChars).and(this.sumIsValid(words)))
			.findFirst()
			.orElse(Collections.emptyMap());
	}

	Map<Character, Integer> solve() throws UnsolvablePuzzleException {
		if (solution.isEmpty()) {
			throw new UnsolvablePuzzleException();
		}
		return this.solution;
	}

	private Predicate<Map<Character, Integer>> sumIsValid(final List<String> words) {
		return map -> words.subList(0, words.size() - 1).stream()
			.mapToLong(word -> this.wordToNumber(word, map))
			.sum() == this.wordToNumber(words.get(words.size() - 1), map);
	}

	private Predicate<Map<Character, Integer>> hasNoLeadingZero(final List<Character> leadingChars) {
		return map -> leadingChars.stream().noneMatch(c -> map.get(c) == 0);
	}

	private long wordToNumber(final String word, final Map<Character, Integer> solution) {
		return Long.parseLong(word.chars()
								  .mapToObj(c -> String.valueOf((solution.get((char) c))))
								  .collect(joining()));
	}

	private List<List<Integer>> partialPermutations(final List<Integer> permutation, final List<Integer> rest, int k) {
		return (k == 0)
			? List.of(permutation)
			: IntStream.range(0, rest.size()).parallel()
				.mapToObj(i -> this.partialPermutations(this.concat(permutation, rest.get(i)),
														this.remove(rest, i),
														k - 1).stream())
				.flatMap(identity())
				.collect(toList());
	}

	private List<Integer> remove(final List<Integer> list, final int i) {
		return Stream.concat(list.subList(0, i).stream(), list.subList(i + 1, list.size()).stream())
			.collect(toList());
	}

	private List<Integer> concat(final List<Integer> list, final int n) {
		return Stream.concat(list.stream(), Stream.of(n))
			.collect(toList());
	}

}