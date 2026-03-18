import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] arr;

	public void combination(int L, int start) {
		if (L == m) {
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = start; i <= n; i++) {
				arr[L] = i;
				combination(L + 1, i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];

		T.combination(0, 1);

	}
}