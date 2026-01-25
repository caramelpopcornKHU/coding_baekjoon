import java.io.*;
import java.util.*;

public class Main {

	static int count;

	public static int recursion(String s, int l, int r, int cnt) {
		count = cnt;
		if (l >= r) {
			return 1;
		} else if (s.charAt(l) != s.charAt(r)) {
			return 0;
		} else {
			return recursion(s, l + 1, r - 1, cnt + 1);
		}
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1, 1);
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (String x : arr) {
			bw.write(isPalindrome(x) + " " + count);
			bw.write("\n");
		}
		bw.flush();

//		System.out.println("ABBA: " + isPalindrome("ABBA"));
//		System.out.println("ABC: " + isPalindrome("ABC"));

	}
}