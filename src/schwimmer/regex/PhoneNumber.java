package schwimmer.regex;

import java.util.regex.Pattern;

public class PhoneNumber {

	private static final String LEADING_1 = "(1[- ])?";
	private static final String AREA_CODE = "(\\(?\\d{3}\\)?[- ])?";
	private static final String NUMBER = "\\d{3}[- ]\\d{4}";
	private static final Pattern PATTERN = Pattern.compile("(" + LEADING_1
			+ AREA_CODE + ")?" + NUMBER);

	public boolean isValid(String phoneNumberString) {
		return PATTERN.matcher(phoneNumberString).matches();
	}

}
