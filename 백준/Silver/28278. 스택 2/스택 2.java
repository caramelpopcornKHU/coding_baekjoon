
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());

		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int query = Integer.parseInt(st.nextToken());

			if (query == 1) {
				int x = Integer.parseInt(st.nextToken());
				stack.push(x);
			} else if (query == 2) {
				if (!stack.isEmpty()) {
					bw.write(stack.pop() + "");
					bw.write("\n");
				} else {
					bw.write("-1\n");
				}
			} else if (query == 3) {
				int size = stack.size();
				bw.write(size + "");
				bw.write("\n");
			} else if (query == 4) {
				if (!stack.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write("1\n");
				}
			} else if (query == 5) {
				if (!stack.isEmpty()) {
					bw.write(stack.peek() + "");
					bw.write("\n");
				} else {
					bw.write("-1\n");
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();

	}
}