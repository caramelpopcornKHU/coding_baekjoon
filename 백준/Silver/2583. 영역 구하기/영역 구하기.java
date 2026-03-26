
import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int M, N, K;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static int[][] paper;

	static int cnt;

	public void BFS(int x, int y) {
		Deque<Point> Q = new ArrayDeque<Point>();
		Q.offer(new Point(x, y));

		while (!Q.isEmpty()) {

			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				boolean condition1 = (nx > -1) && (nx < M);
				boolean condition2 = (ny > -1) && (ny < N);

				if (condition1 && condition2 && paper[nx][ny] == 0) {
					paper[nx][ny] = 1;
					cnt++;
					Q.offer(new Point(nx, ny));
				}

			}

		}

	}

	public void solution() {

		ArrayList<Integer> answer = new ArrayList<Integer>();

		// 더하는 로직

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				if (paper[i][j] == 0) {
					cnt = 1;
					paper[i][j] = 1;
					BFS(i, j);

					answer.add(cnt);
				}

			}
		}

		Collections.sort(answer);
		System.out.println(answer.size());
		for (int a : answer)
			System.out.print(a + " ");

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		paper = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int leftX = Integer.parseInt(st.nextToken());
			int leftY = Integer.parseInt(st.nextToken());
			int rightX = Integer.parseInt(st.nextToken());
			int rightY = Integer.parseInt(st.nextToken());

			// (0,2) 2행 0열
			// (4,4) 3행 3열
			for (int x = leftY; x < rightY; x++) {
				for (int y = leftX; y < rightX; y++) {
					paper[x][y] = 1;
				}
			}

		}

		T.solution();

	}
}