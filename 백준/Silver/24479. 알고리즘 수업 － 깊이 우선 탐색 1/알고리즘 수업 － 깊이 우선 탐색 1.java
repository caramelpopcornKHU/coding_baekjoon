
import java.io.*;
import java.util.*;

public class Main {

	static int N, M, R;
	static int[] ch;
	static ArrayList<ArrayList<Integer>> graph;
	static int order = 1;

	public void DFS(int v) {
		order++;
		for (int nv : graph.get(v)) {
			if (ch[nv] == 0) {
				ch[nv] = order;
				DFS(nv);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();

		ch = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph.get(from).add(to);
			graph.get(to).add(from);

		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		ch[R] = 1;
		T.DFS(R);
		
		for (int i = 1; i <= N; i++) {
			System.out.println(ch[i]);
		}

	}

}