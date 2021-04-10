import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FoodChain {

	private static final String I_KNOW_SENTENCE = "I know an old lady who swallowed a %s.\n";
	private static final String LAST_SENTENCE = "I don't know why she swallowed the fly. Perhaps she'll die.";
	private static final String SWALLOWED_SENTENCE = "She swallowed the %s to catch the %s%s.\n";
	private static final String[] ANIMALS = {"fly", "spider", "bird", "cat", "dog", "goat", "cow", "horse"};
	private static final String[] AFTERMATH_SENTENCES = {
		"",
		"It wriggled and jiggled and tickled inside her.\n",
		"How absurd to swallow a %s!\n",
		"Imagine that, to swallow a %s!\n",
		"What a hog, to swallow a %s!\n",
		"Just opened her throat and swallowed a %s!\n",
		"I don't know how she swallowed a %s!\n",
		"She's dead, of course!"};

	private static final Map<String, String> DESCRIPTIONS =
		Collections.singletonMap("spider", " that wriggled and jiggled and tickled inside her");

	String verse(final int verseNumber) {
		return String.format(I_KNOW_SENTENCE, ANIMALS[verseNumber - 1])
			+ String.format(AFTERMATH_SENTENCES[verseNumber - 1], ANIMALS[verseNumber - 1])
			+ this.getSwallowSentences(verseNumber - 1)
			+ (verseNumber < 8 ? LAST_SENTENCE : "");
	}

	String verses(final int startVerse, final int endVerse) {
		return IntStream.rangeClosed(startVerse, endVerse)
			.mapToObj(this::verse)
			.collect(Collectors.joining("\n\n"));
	}

	private String getSwallowSentences(final int verseNumber) {
		return (verseNumber == 0 || verseNumber == 7)
			? ""
			: IntStream.range(0, verseNumber)
				.mapToObj(animal -> String.format(SWALLOWED_SENTENCE,
												  ANIMALS[verseNumber - animal],
												  ANIMALS[verseNumber - animal - 1],
												  DESCRIPTIONS.getOrDefault(ANIMALS[verseNumber - animal - 1], "")))
				.collect(Collectors.joining());
	}
}