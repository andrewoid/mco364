package schwimmer.dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class DictionaryLookup {

	private String words[];
	private HashMap<String, Boolean> map;
	private Random random;

	public DictionaryLookup(String filename) throws FileNotFoundException,
			IOException {
		List<String> list = IOUtils.readLines(new FileInputStream(filename));
		words = (String[]) list.toArray();
		for (String s : words) {
			map.put(s, Boolean.TRUE);
		}
		random = new Random();
	}

	public boolean containsSequential(String word) {
		for (String s : words) {
			if (s.equals(word)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsBinary(String word) {
		return Arrays.binarySearch(words, word) != -1;
	}

	public boolean containsHash(String word) {
		return map.containsKey(word);
	}

	public String getRandomWordInDictionary() {
		return words[random.nextInt(words.length)];
	}

	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(10).toLowerCase();
	}

}
