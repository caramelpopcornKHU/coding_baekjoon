import java.util.*;
import java.io.*;

public class Main {

	static int N, K;

	public int solution(Integer[] arr) {
		int answer = 0;

		for (int x : arr) {

			while ((K / x) > 0) {
				K -= x;
				answer++;
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		System.out.println(T.solution(arr));

	}
}