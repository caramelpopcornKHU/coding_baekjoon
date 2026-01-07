import java.util.*;
import java.io.*;

public class Main {

	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		Arrays.sort(arr);

		// -99 -2 -1 4 98
		// 1 2 3 4 5
		// -5 -4 -3 -2 -1 1

		// 합이 0인경우
		// 합이 음수인 경우 - 왼쪽을 늘려
		// 합이 양수인 경우 - 오른쪽을 줄이고

		int lt = 0, rt = n - 1;
		int la = arr[lt], ra = arr[rt];
		int minAbs = Integer.MAX_VALUE;

		while (lt < rt) {
			int sum = arr[lt] + arr[rt];

			if (Math.abs(sum) < minAbs) {
				minAbs = Math.abs(sum);
				la = arr[lt];
				ra = arr[rt];
			}
			
			if(sum==0) {
				break;
			}
			
			if(sum<0) {
				lt++;
			} else {
				rt--;
			}
			
		}

		answer.add(la);
		answer.add(ra);

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken(), 10);
		}

		for (int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
