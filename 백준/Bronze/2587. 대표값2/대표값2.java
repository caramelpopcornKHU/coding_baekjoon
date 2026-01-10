import java.util.*;
import java.io.*;

public class Main {

	public void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public int[] solution(int n, int[] arr) {
		int[] answer = new int[2];
		int medianN = n / 2;

		while (n-- > 0) {
			
			answer[0] += arr[n];
		}
		answer[0] /= 5;
		answer[1] = arr[medianN];
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//int n = Integer.parseInt(br.readLine());
		int[] arr = new int[5];

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 퀵 소트 nlogn
		Arrays.sort(arr);
		for (int x : T.solution(5, arr)) {
			System.out.println(x);
		}

	}

}