import java.io.*;
import java.util.*;

public class Main {

	public Integer[] solution(String s) {
		int len = s.length();
		Integer[] arr = new Integer[len];
		int n = Integer.parseInt(s);
		len--;

		while (n > 0) {
			arr[len] = n % 10;
			n /= 10;

			len--;
		}
		Arrays.sort(arr,Collections.reverseOrder());
		return arr;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		for (int x : T.solution(s)) {
			bw.write(String.valueOf(x));
		}
		bw.flush();

	}

}