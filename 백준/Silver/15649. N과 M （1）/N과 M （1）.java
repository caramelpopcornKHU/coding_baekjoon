
import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[] pm, ch;

	public void DFS(int L) {
		if (L == m) {
			for(int x : pm)
				System.out.print(x + " ");
			
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				if (ch[i] == 0) {
					ch[i] = 1;

					pm[L] = i;
					DFS(L + 1);
					ch[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		ch = new int[n + 1];
		pm = new int[m];

		T.DFS(0);

	}
}