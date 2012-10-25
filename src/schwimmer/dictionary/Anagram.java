package schwimmer.dictionary;

import java.util.Arrays;

public class Anagram {
	public boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}

		return Arrays.equals(sortString(a), sortString(b));
	}

	public char[] sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return c;
	}
}
