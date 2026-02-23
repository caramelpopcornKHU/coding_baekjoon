
import java.io.*;
import java.util.*;

public class Main {

	public void solution(int n, int[] arrN, int m, int[] arrM) {

		for (int i = 0; i < m; i++) {

			int lt = 0;
			int rt = n - 1;

			while (lt <= rt) {
				int mid = (lt + rt) / 2;

				if (arrM[i] == arrN[mid]) {
					System.out.println("1");
					break;
				} else if (arrM[i] < arrN[mid]) {
					rt = mid - 1;
				} else {
					lt = mid + 1;
				}

			}

			if (lt > rt) {
				System.out.println("0");
			}

		}

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] arrN = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrN);

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] arrM = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		T.solution(n, arrN, m, arrM);

	}
}