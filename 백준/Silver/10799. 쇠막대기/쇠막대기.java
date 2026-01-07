import java.util.*;
import java.io.*;

public class Main {

	public int solution(String a) {
		int answer = 0;
		Stack<Character> stack = new Stack<Character>();

		char[] c = a.toCharArray();

		for (int i = 0; i < a.length(); i++) {
			// '(' 이면 stack에 push
			if (c[i] == '(')
				stack.push(c[i]);

			// ')' 이면 stack에 pop 이후
			if (c[i] == ')') {
				stack.pop();

				// 바로 앞의 문자를 확인
				// i-1의 outOfBound 걱정X 처음에 ')' 들어올 일 X

				if (c[i - 1] == '(') {
					answer += stack.size(); // 레이저 쏘기니까 쇠막대기 개수 추가
				} else if (c[i - 1] == ')') {
					answer += 1; // 가장 상단 쇠막대기 1개 추가
				}
			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();

		System.out.println(T.solution(a));

	}

}