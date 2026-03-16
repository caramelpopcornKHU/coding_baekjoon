
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> map = new TreeMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(st.nextToken());
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int output = Integer.parseInt(st.nextToken());
//			System.out.print(map.getOrDefault(output, 0) + " ");
			bw.write(map.getOrDefault(output, 0) + " ");
		}
		bw.flush();

	}
}