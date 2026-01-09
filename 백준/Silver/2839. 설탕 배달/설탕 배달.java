import java.util.*;
import java.io.*;

public class Main {

	public int solution(int n) {
		int answer = -1;

		int cnt = 0;

		while (n > 0) {

			// 5의 배수냐
			if (n % 5 == 0) {
				cnt += n / 5;
				n %= 5;
			}
			// 5의 배수가 아니냐
			else {
				// 5의 배수가 아니라면 3의 배수여야한다.
				n -= 3;
				cnt++;
			}
		}
		if(n==0)
			return cnt;

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(T.solution(n));

	}

}