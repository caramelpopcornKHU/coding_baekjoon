import java.io.*;
import java.util.*;

class Point {
	public int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n, m, answer = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[][] arr;

	static Deque<Point> Q;

	public void BFS() {
		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int i = 0; i < size; i++) {

				Point tmp = Q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];

					boolean con1 = nx > -1 && nx < m;
					boolean con2 = ny > -1 && ny < n;

					if (con1 && con2 && arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						Q.offer(new Point(nx, ny));
					}

				}

			}

			answer++;
		}

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m][n];

		Q = new ArrayDeque<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int rot = Integer.parseInt(st.nextToken());
				if (rot == 1) {
					Q.offer(new Point(i, j));
				}
				arr[i][j] = rot;
			}
		}

		T.BFS();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(answer - 1);
	}

}