import java.util.*;
import java.io.*;

public class Main {

	public int solution(int n, int s, int[] arr) {
		int answer = Integer.MAX_VALUE;

		int lt = 0, sum = 0;
		// 1 2 3 4 8 1 3 ==== 6

		for (int rt = 0; rt < n; rt++) {
			sum += arr[rt];
			// 스스로가 이미 큰 경우
			if (arr[rt] >= s)
				return 1;

			while (sum >= s) {
				answer = Math.min(answer, rt - lt + 1);
				sum -= arr[lt++];
			}

		}
		if (answer == Integer.MAX_VALUE) return 0;
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken(), 10);
		}

		System.out.println(T.solution(n, s, arr));

	}

}
