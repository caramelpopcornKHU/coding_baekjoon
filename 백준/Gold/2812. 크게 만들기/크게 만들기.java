import java.io.*;
import java.util.*;

public class Main {

	static int N, K;

	public void solution(String num) {

		char[] arr = num.toCharArray();

		Deque<Character> stack = new ArrayDeque<>();

		for (char c : arr) {

			while (!stack.isEmpty() && stack.peek() < c && K > 0) {
				K--;
				stack.pop();
			}
			stack.push(c);

		}
		
		while(K>0) {
			K--;
			stack.pop();
			}
		
		StringBuilder sb = new StringBuilder();
		
		for(char c : stack) {
			sb.append(c);
		}
		
		sb.reverse();
		System.out.println(sb.toString());

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		String num = br.readLine();

		T.solution(num);

	}
}
