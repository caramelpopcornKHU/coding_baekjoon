import java.util.*;
import java.io.*;

public class Main {

	static int[] unf;

	public static int Find(int v) {
		if (v == unf[v])
			return v;
		else {
			return unf[v] = Find(unf[v]);
		}
	}

	public static void Union(int a, int b) {
		int elementA = Find(a);
		int elementB = Find(b);
		unf[elementA] = elementB;
	}

	public String isSet(int elementA, int elementB) {
		String answer = "NO";

		if (Find(elementA) == Find(elementB)) {
			answer = "YES";
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		unf = new int[n + 1];

		// v == unf[v] 에 맞게 세팅
		for (int i = 0; i <= n; i++) {
			unf[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int query = Integer.parseInt(st.nextToken());

			int elementA = Integer.parseInt(st.nextToken());
			int elementB = Integer.parseInt(st.nextToken());

			if (query == 0) {
				Union(elementA, elementB);
			} else {
				bw.write(T.isSet(elementA, elementB));
				bw.write("\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}