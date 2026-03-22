import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();

		int n = Integer.parseInt(st.nextToken());

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if (x != 0)
				pQ.offer(x);

			if (x == 0) {
				if (!pQ.isEmpty()) {
					int output = pQ.poll();
					bw.write(output + "\n");
				} else {
					bw.write(0 + "\n");

				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
}