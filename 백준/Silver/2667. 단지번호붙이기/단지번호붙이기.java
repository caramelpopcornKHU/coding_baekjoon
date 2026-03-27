import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int[][] arr;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public int BFS(int x, int y, int n) {
		int cnt = 0;

		Deque<Point> Q = new ArrayDeque<Point>();
		Q.offer(new Point(x, y));

		while (!Q.isEmpty()) {

			Point np = Q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {

				int nx = np.x + dx[i];
				int ny = np.y + dy[i];
				boolean condition1 = (nx > -1) && (nx < n);
				boolean condition2 = (ny > -1) && (ny < n);

				if (condition1 && condition2 && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					Q.offer(new Point(nx, ny));
				}

			}

		}

		return cnt;
	}

	public void solution(int n) {
		ArrayList<Integer> houseCnt = new ArrayList<Integer>();

		int house;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (arr[i][j] == 1) {
					arr[i][j] = 0;
					house = BFS(i, j, n);
					houseCnt.add(house);
				}

			}
		}

		Collections.sort(houseCnt);
		System.out.println(houseCnt.size());
		for (int x : houseCnt)
			System.out.println(x);

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				char c = line.charAt(j);
				arr[i][j] = Integer.parseInt(String.valueOf(c));
			}
		}

		T.solution(n);

	}
}