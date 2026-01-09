import java.util.*;
import java.io.*;

public class Main {

	public int[] solution(int[] arr) {
		int[] answer = new int[2];

		for (int i = -999; i <= 999; i++) {
			for (int j = -999; j <= 999; j++) {
				if (arr[0] * i + arr[1] * j == arr[2]) {
					if (arr[3] * i + arr[4] * j == arr[5]) {
						answer[0] = i;
						answer[1] = j;
					}
				}
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int a : T.solution(arr)) {
			System.out.print(a + " ");
		}

	}

}