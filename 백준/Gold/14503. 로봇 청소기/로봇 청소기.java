import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;
	int dir;

	Point(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", dir=" + dir + "]";
	}

}

public class Main {

	// 0 북
	// 1 동
	// 2 남
	// 3 서

	static Map<Integer, Integer> dx = Map.of(0, -1, 1, 0, 2, 1, 3, 0);

	static Map<Integer, Integer> dy = Map.of(0, 0, 1, 1, 2, 0, 3, -1);

	static int[][] map;

	public int simulation(int n, int m, Point robot) {
		int answer = 0;

		Deque<Point> Q = new ArrayDeque<Point>();
		Q.offer(robot);

		while (!Q.isEmpty()) {

			Point now = Q.poll();

			if (map[now.x][now.y] == 0) {
				map[now.x][now.y] = 2;
				answer++;
			}

			boolean flag = false;

			for (int i = 0; i < 4; i++) {

				int nx = now.x + dx.get(i);
				int ny = now.y + dy.get(i);
				// 벽 조건
				boolean con1 = (nx > -1) && (nx < n);
				boolean con2 = (ny > -1) && (ny < m);

				// 튕겨나가는 조건은 배재
				if (con1 && con2 && map[nx][ny] == 0)
					flag = true;

			}

			if (flag) {

				if (now.dir != 0) {
					now.dir--;
				} else {
					now.dir = 3;
				}
				int moveX = now.x + dx.get(now.dir);
				int moveY = now.y + dy.get(now.dir);
				if (map[moveX][moveY] == 0) {
					Q.offer(new Point(moveX, moveY, now.dir));
				} else {
					Q.offer(new Point(now.x, now.y, now.dir));
				}

			}

			// 4바퀴 동안 flag가 false : 청소할게 없다
			if (!flag) {

				int nx = now.x - dx.get(now.dir);
				int ny = now.y - dy.get(now.dir);

				if (map[nx][ny] != 1) {
					// 후진
					Q.offer(new Point(nx, ny, now.dir));
				} else {
					break;
				}

			}

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		// 로봇 초기화 위치
		st = new StringTokenizer(br.readLine());
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int robotDir = Integer.parseInt(st.nextToken());
		Point robot = new Point(robotX, robotY, robotDir);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(T.simulation(n, m, robot));

	}
}
// 4 4
// 1 1 0
// 1 1 1 1
// 1 0 0 1
// 1 0 0 1
// 1 1 1 1