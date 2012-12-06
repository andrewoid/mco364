package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;

public class GoogleDownloader {

	private static final Pattern ANCHOR = Pattern.compile("<a .*?href=\"(.*?)\"");

	public static void main(String args[]) throws UnknownHostException,
			IOException {

		URL url = new URL("http://www.touro.edu");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		InputStream in = connection.getInputStream();
		String webpage = IOUtils.toString(in);
		in.close();

		System.out.println(webpage);

		Matcher anchorMatcher = ANCHOR.matcher(webpage);
		while (anchorMatcher.find()) {
			System.out.println(anchorMatcher.group(1));
		}

	}

}
