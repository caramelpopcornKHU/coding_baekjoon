import java.util.*;
import java.io.*;

public class Main {

	public int solution(String n) {
		int answer = 0;
		int nInt = Integer.parseInt(n);

		for (int i = 1; i < nInt; i++) {

			int mock = i;
			int sum = 0;

			while (mock > 0) {
				sum += mock % 10;
				mock /= 10;
			}

			if (nInt == sum + i)
				return i;

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String n = st.nextToken();

		System.out.println(T.solution(n));

	}

}