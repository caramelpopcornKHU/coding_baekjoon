
import java.io.*;
import java.util.*;

public class Main {

	public ArrayList<Integer> solution(int n, int m) {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// 1부터 m까지 정수
		int[] num = new int[m + 1];

		for (int i = 2; i <= m; i++) {
			if (num[i] == 0 && i >= n) {
				answer.add(i);
			}
			for (int j = i; j <= m; j = j + i) {
				num[j] = 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int x : T.solution(n, m)) {
			System.out.println(x);
		}
	}
}