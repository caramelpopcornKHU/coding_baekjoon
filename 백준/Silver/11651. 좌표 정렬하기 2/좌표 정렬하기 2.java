import java.io.*;
import java.util.*;

public class Main {

	public void solution(int[][] data) {
		Arrays.sort(data, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] data = new int[n][2];

		// 입력 받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2차원 정렬
		T.solution(data);

		// 출력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				bw.write(data[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}

}