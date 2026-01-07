import java.io.*;
import java.util.*;

public class Main {

	public int solution(int n) {
		int answer = 0;

		boolean[] isNotPrime = new boolean[n + 1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;

		for (int i = 2; i * i <= n; i++) {
			if (!isNotPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isNotPrime[j] = true;
				}
			}
		}

		ArrayList<Integer> prime = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			if (!isNotPrime[i]) {
				prime.add(i);
			}
		}

		int lt = 0;
		int sum = 0;
		for (int rt = 0; rt < prime.size(); rt++) {

			sum += prime.get(rt);

			while (sum > n) {
				sum -= prime.get(lt);
				lt++;
			}

			if (sum == n) {
				answer++;
			}
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