package schwimmer.dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SequentialSearchThread extends Thread {

	public void run() {
		int numberOfTests = 10000;
		DictionaryLookup lookup;
		try {
			lookup = new DictionaryLookup("word_list_moby_crossword.flat.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		long start = System.currentTimeMillis();

		String s;
		for (int i = 0; i < numberOfTests; i++) {
			s = lookup.getRandomWordInDictionary();
			lookup.containsSequential(s);
		}
		for (int i = 0; i < numberOfTests; i++) {
			s = lookup.getRandomString();
			lookup.containsSequential(s);
		}

		System.out.println(System.currentTimeMillis() - start);
	}

}
