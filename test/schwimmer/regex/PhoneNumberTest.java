package schwimmer.regex;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Test;

public class PhoneNumberTest {

	@Test
	public void testIsValid() {

		PhoneNumber phoneNumber = new PhoneNumber();

		assertTrue(phoneNumber.isValid("123-4567"));
		assertTrue(phoneNumber.isValid("123 4567"));
		assertFalse(phoneNumber.isValid("1234567"));
		
		assertTrue(phoneNumber.isValid("890 123 4567"));
		assertTrue(phoneNumber.isValid("890-123 4567"));
		assertTrue(phoneNumber.isValid("890-123-4567"));
		
		assertTrue(phoneNumber.isValid("1 890 123 4567"));
		assertTrue(phoneNumber.isValid("1 (890) 123 4567"));
		assertTrue(phoneNumber.isValid("1-890 123 4567"));

	}

}
