package schwimmer.dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class LargestAnagramSetTest {

	@Test
	public void testGetLargestSet() throws FileNotFoundException, IOException {
		LargestAnagramSet las = new LargestAnagramSet("word_list_moby_crossword.flat.txt");
		List<List<String>> largestSets = las.getLargestSets();
		System.out.println(largestSets.size());
		for ( List<String> l : largestSets ) {
			System.out.println(l.size());
			System.out.println(l);
		}
	}

}
