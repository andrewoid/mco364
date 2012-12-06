package schwimmer.dictionary;

public class MultiThreadedDictionaryLookup {

	public static void main(String args[]) {

		SequentialSearchThread thread = new SequentialSearchThread();

		System.out.println("About to start Thread");
		thread.start();
		System.out.println("I just started a Thread");
		
	}

}
