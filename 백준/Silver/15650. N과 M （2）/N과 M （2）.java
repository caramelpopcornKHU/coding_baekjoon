
import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int N, M;

	public void combination(int L, int s) {
		if (L == M) {
			
			for(int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = s; i <= N; i++) {
				arr[L] = i;
				combination(L + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		T.combination(0, 1);
	}

}