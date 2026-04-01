import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;
	int data;

	Point(int x, int y, int data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}

}

public class Main {

	static int N, L, R;
	static int[][] map;

	static int[][] ch;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static ArrayList<ArrayList<Point>> mergeList;
	static ArrayList<Integer> meanList;
	
	
	public void resetCheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ch[i][j] = 0;
			}
		}
	}

	public void BFS(int x, int y, int mark) {
		ch[x][y] = mark;
		mergeList.add(new ArrayList<Point>());
		// 초기화
		int sum = 0;
		int landCnt = 0;

		Deque<Point> Q = new ArrayDeque<Point>();

		Q.offer(new Point(x, y, map[x][y]));

		while (!Q.isEmpty()) {
			Point nv = Q.poll();
			
			landCnt++;
			sum += nv.data;

			int i = nv.x;
			int j = nv.y;
			
			for (int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];

				boolean con1 = (nx > -1) && (nx < N);
				boolean con2 = (ny > -1) && (ny < N);

				if (con1 && con2 && ch[nx][ny] == 0) {

					boolean con3 = Math.abs(map[i][j] - map[nx][ny]) >= L;
					boolean con4 = Math.abs(map[i][j] - map[nx][ny]) <= R;

					if (con3 && con4) {
						ch[nx][ny] = mark;
						Q.offer(new Point(nx, ny, map[nx][ny]));
					}
				}
			}
			
			mergeList.get(mark).add(nv);

		}

		int mean = sum / landCnt;
		meanList.add(mean);
		

	}
	
	public void mergeListTransaction(int islandCnt) {
		for (int i = 1; i <= islandCnt; i++) {
			int meanValue = meanList.get(i);
			for(Point p : mergeList.get(i)) {
				map[p.x][p.y]= meanValue;
			}
		}
	}

	public int solution() {
		int answer = 0;
		boolean flag = true;

		while (flag) {
			
			resetCheck();
			int islandCnt = 0;
			mergeList = new ArrayList<>();
			meanList = new ArrayList<>();
			
			mergeList.add(new ArrayList<Point>());
			meanList.add(0);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					for (int k = 0; k < 4; k++) {

						int nx = i + dx[k];
						int ny = j + dy[k];

						boolean con1 = (nx > -1) && (nx < N);
						boolean con2 = (ny > -1) && (ny < N);

						if (con1 && con2 && ch[nx][ny] == 0) {

							boolean con3 = Math.abs(map[i][j] - map[nx][ny]) >= L;
							boolean con4 = Math.abs(map[i][j] - map[nx][ny]) <= R;

							if (con3 && con4) {
								islandCnt++;
								BFS(i, j, islandCnt);
							}
						}
					}

				}
			}

			if (islandCnt == 0)
				break;
			else
				mergeListTransaction(islandCnt);

			answer++;

		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		ch = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				map[i][j] = x;
			}
		}

		System.out.println(T.solution());

	}
}
