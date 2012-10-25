package schwimmer.dictionary;

import junit.framework.Assert;

import org.junit.Test;


public class AnagramTest {

	@Test
	public void testAnagram() {
		Anagram anagram = new Anagram();
		
		Assert.assertTrue(anagram.isAnagram("care", "race"));
		Assert.assertFalse(anagram.isAnagram("car", "race"));
		Assert.assertFalse(anagram.isAnagram("carre", "race"));
		
	}
	
	
}
