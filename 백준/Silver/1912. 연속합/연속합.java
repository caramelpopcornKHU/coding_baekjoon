import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] dy;

	public int solution(int[] arr) {

		int max = arr[0];
		dy[0] = arr[0];

		for (int i = 1; i < n; i++) {
			// 마이너스가 되어도 양수면 이득이다
			// 더했는댕 음수면 새로

			// 발전 가능하냐
			if (arr[i] + dy[i - 1] > arr[i]) {
				dy[i] = arr[i] + dy[i - 1];
			}
			// 발전가능하지 못하면 스스로가 가장 최고다
			else {

				dy[i] = arr[i];

			}
			max = Math.max(max, dy[i]);

		}

		int answer = Arrays.stream(dy).max().getAsInt();
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		dy = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(T.solution(arr));

	}
}