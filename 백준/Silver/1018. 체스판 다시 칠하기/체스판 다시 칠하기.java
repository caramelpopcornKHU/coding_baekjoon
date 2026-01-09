import java.util.*;
import java.io.*;

public class Main {

	public int solution(int m, int n, char[][] arr) {
		int answer = Integer.MAX_VALUE;

		// ij window가 돌아야 하는 경우의 수
		for (int i = 0; i < m - 7; i++) {
			for (int j = 0; j < n - 7; j++) {
				int cntA = 0; // BWB 패턴
				int cntB = 0; // WBW 패턴

				boolean flagA = true;
				boolean flagB = true;

				// 검사로직
				for (int p = i; p < i + 8; p++) {

					for (int q = j; q < j + 8; q++) {
						// WBW 패턴

						if (flagA) {
							if (arr[p][q] != 'W')
								cntA++;
							if (arr[p][q] != 'B')
								cntB++;

							flagA = false;
						} else {
							if (arr[p][q] != 'B')
								cntA++;
							if (arr[p][q] != 'W')
								cntB++;

							flagA = true;
						}

					}
					if (flagA)
						flagA = false;
					else
						flagA = true;
				}

				answer = Math.min(answer, Math.min(cntA, cntB));

			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		char[][] arr = new char[m][n];

		for (int i = 0; i < m; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				arr[i][j] = c[j];
			}
		}

		System.out.println(T.solution(m, n, arr));

	}

}