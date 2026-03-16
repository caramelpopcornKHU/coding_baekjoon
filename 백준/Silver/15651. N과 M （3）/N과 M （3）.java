
import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] pm;
	static BufferedWriter bw;

	public void DFS(int L) throws IOException {
		if (L == m) {
			for (int x : pm) {
				bw.write(x + " ");

			}
			bw.write("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pm = new int[m];

		T.DFS(0);

		bw.flush();
		bw.close();
		br.close();
	}
}