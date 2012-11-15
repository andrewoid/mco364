package schwimmer.dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class LargestAnagramSet {

	HashMap<String, List<String>> anagrams;

	public LargestAnagramSet(String filename) throws FileNotFoundException,
			IOException {
		anagrams = new HashMap<String, List<String>>();
		List<String> list = IOUtils.readLines(new FileInputStream(filename));
		for (String word : list) {
			String key = Anagram.getSortedWord(word);
			List<String> anagramList = anagrams.get(key);
			if (anagramList == null) {
				anagramList = new ArrayList<String>();
				anagrams.put(key, anagramList);
			}

			anagramList.add(word);
		}
	}

	public List<List<String>> getLargestSets() {
		List<List<String>> sets = new ArrayList<List<String>>();
		List<String> largestSet = new ArrayList<String>();
		for (List<String> l : anagrams.values()) {
			if (l.size() == 1) {
				continue;
			}
			if (l.size() > largestSet.size()) {
				largestSet = l;
				sets.clear();
				sets.add(largestSet);
			} else if (l.size() == largestSet.size()) {
				sets.add(l);
			}
		}
		return sets;
	}

}
