import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;

	public boolean isLengthCuttable(long mid, int n) {
		boolean flag = false;

		long cnt = 0;
		// n개 이상을 충족해야해

		for (int cable : arr) {
			long numberOfCutten = cable / mid;
			cnt += numberOfCutten;
		}

		if (cnt >= n)
			flag = true;

		return flag;

	}

	public long solution(int k, int n, int[] arr) {
		long answer = 0;

		long lt = 1;
		long rt = Arrays.stream(arr).max().getAsInt();

		while (lt <= rt) {
			long mid = (lt + rt) / 2;

			// 이 작은 길이로 n개 가능하냐
			if (isLengthCuttable(mid, n)) {
				lt = mid + 1;
				answer = mid;
			}

			// 이 큰 길이로 n개 불가능 하냐
			else {
				rt = mid - 1;
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());

		arr = new int[k];

		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			arr[i] = length;
		}

		System.out.println(T.solution(k, n, arr));
	}
}