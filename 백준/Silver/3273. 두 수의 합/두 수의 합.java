import java.util.*;
import java.io.*;

public class Main {

	public int solution(int n, int[] arr, int x) {
		int answer = 0;

		Arrays.sort(arr);

		// 1 2 3 5 7 9 10 11 12 ---- 13
		// 1 2 7 8 11 13 14 ---- 9
		int lt = 0, rt = n-1;

		while(lt < rt) {
			
			if(arr[lt] + arr[rt] == x) {
				lt++;
				rt--;
				answer++;				
			} else if(arr[lt] + arr[rt] > x) {
				rt--;
			} else {
				lt++;
			}
		}

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
		int x = Integer.parseInt(br.readLine());
		System.out.println(T.solution(n, arr, x));

	}

}
