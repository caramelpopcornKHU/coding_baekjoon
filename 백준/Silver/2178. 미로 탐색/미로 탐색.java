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

	static int answer = Integer.MAX_VALUE;
	static int n, m;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] map, ch;

	public void BFS(int x, int y) {

		Deque<Point> Q = new ArrayDeque<Point>();
		Q.offer(new Point(x, y));

		int level = 1;

		while (!Q.isEmpty()) {

			int size = Q.size();
			

			while (size-- > 0) {

				Point nowPoint = Q.poll();

				if (nowPoint.x == (n - 1) && nowPoint.y == (m - 1)) {

					answer = Math.min(answer, level);

				}
				
				for (int i = 0; i < 4; i++) {

					int nx = nowPoint.x + dx[i];
					int ny = nowPoint.y + dy[i];

					boolean condition1 = (nx > -1) && (nx < n);
					boolean condition2 = (ny > -1) && (ny < m);

					if (condition1 && condition2 && map[nx][ny] == 1) {
						if (ch[nx][ny] == 0) {
							ch[nx][ny] = 1;
							Q.offer(new Point(nx, ny));
						}
					}

				}

			}

			level++;

		}

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		ch = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {

				char c = input.charAt(j);
				String x = Character.toString(c);
				map[i][j] = Integer.parseInt(x);
			}
		}

		ch[0][0] = 1;
		T.BFS(0, 0);

		System.out.println(answer);

	}
}