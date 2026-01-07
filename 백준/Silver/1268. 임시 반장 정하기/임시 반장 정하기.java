import java.io.*;
import java.util.*;

public class Main {

	public int solution(int n, int[][] arr) {
		int answer = 0;
		int cntMax = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				if(i==j)
					continue;
				
				for(int k = 0; k < 5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
				
			}
			
			if(cnt > cntMax) {
				cntMax = cnt;
				answer = i+1;
			}
			
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][5];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		

		System.out.println(T.solution(n, arr));
//		for (int x : T.solution(n, arr)) {
//			System.out.print(x + " ");
//		}

	}
}