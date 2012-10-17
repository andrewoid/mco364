package schwimmer.dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DictionaryLookupTest {

	private DictionaryLookup lookup;
	
	@Before
	public void givenDictionaryLookup() throws FileNotFoundException, IOException {
		lookup = new DictionaryLookup("word_list_moby_crossword.flat.txt");
	}
	
	@Test
	public void testContainsSequential() {
		Assert.assertTrue(lookup.containsSequential("computer"));
		Assert.assertFalse(lookup.containsSequential("BLAHBLAHBLAH"));
	}
	

	@Test
	public void testContainsBinary() {
		Assert.assertTrue(lookup.containsBinary("computer"));
		Assert.assertFalse(lookup.containsBinary("BLAHBLAHBLAH"));
	}

	@Test
	public void testContainsHash() {
		Assert.assertTrue(lookup.containsHash("computer"));
		Assert.assertFalse(lookup.containsHash("BLAHBLAHBLAH"));
	}
	
	@Test 
	public void testBatchEfficiency() {
		long sequential = batchTestSequential(1000);
		long binary = batchTestBinary(1000000);
		long hash = batchTestHash(1000000);
		
		Assert.assertTrue( sequential > binary && binary > hash );
		
	}
	
	public long batchTestSequential(int numberOfTests) {
		
		long start = System.currentTimeMillis();
		
		String s;
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomWordInDictionary();
			lookup.containsSequential(s);
		}
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomString();
			lookup.containsSequential(s);
		}
		
		return System.currentTimeMillis() - start;
	}
	
	public long batchTestBinary(int numberOfTests) {
		
		long start = System.currentTimeMillis();
		
		String s;
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomWordInDictionary();
			lookup.containsBinary(s);
		}
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomString();
			lookup.containsBinary(s);
		}
		
		return System.currentTimeMillis() - start;
	}
	
	public long batchTestHash(int numberOfTests) {
		
		long start = System.currentTimeMillis();
		
		String s;
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomWordInDictionary();
			lookup.containsHash(s);
		}
		for ( int i=0; i<numberOfTests; i++ ) {
			s = lookup.getRandomString();
			lookup.containsHash(s);
		}
		
		return System.currentTimeMillis() - start;
	}

}
