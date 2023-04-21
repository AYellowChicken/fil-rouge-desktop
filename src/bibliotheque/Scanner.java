package bibliotheque;

public class Scanner {

	private static java.util.Scanner sc;

	public static java.util.Scanner getSc() {
		if (sc==null) {
			sc = new java.util.Scanner(System.in);
		}
		return sc;
	}
}
