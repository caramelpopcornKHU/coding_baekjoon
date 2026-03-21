
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Collections.reverseOrder());

		int n = Integer.parseInt(st.nextToken());


		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			pQ.offer(x);
			
			if (x == 0) {
				int output = pQ.poll();
				bw.write(output + "\n");
			}
				
			
		}

		

		bw.flush();
		bw.close();
		br.close();
	}
}
