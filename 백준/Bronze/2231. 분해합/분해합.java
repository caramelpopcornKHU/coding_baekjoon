import java.util.*;
import java.io.*;

public class Main {

	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i < n; i++) {

			int mock = i;
			int sum = 0;

			while (mock > 0) {
				sum += mock % 10;
				mock /= 10;
			}
			
			if(sum + i == n)
				return i;

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		System.out.println(T.solution(n));

	}

}