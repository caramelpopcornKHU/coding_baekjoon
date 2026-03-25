
import java.util.*;
import java.io.*;

public class Main {

	static int[] dy;

	public int solution(int n, int[] arr) {

		// dynamic table
		dy[0] = 1;

		for (int i = 0; i < n; i++) {

			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j]) {
					dy[i] = Math.max(dy[i], dy[j] + 1);
				}
			}

			// 0이면 1채워
			if (dy[i] == 0)
				dy[i] = 1;
		}

		int answer = Arrays.stream(dy).max().getAsInt();
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		dy = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(T.solution(n, arr));

	}
}