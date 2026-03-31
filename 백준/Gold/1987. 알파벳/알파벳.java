
import java.io.*;
import java.util.*;

public class Main {

	static int R, C;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static char[][] map;
	static HashMap<Character, Integer> ch;

	public static int answer = 1;

	public void DFS(int x, int y, int L) {
		if (answer == ch.size()) {
			return;
		} else {

			char c = map[x][y];
			answer = Math.max(answer, L);
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				boolean con1 = (nx > -1) && (nx < R);
				boolean con2 = (ny > -1) && (ny < C);

				if (con1 && con2 && ch.get(map[nx][ny]) == 0) {
					ch.put(map[nx][ny], 1);
					DFS(nx, ny, L + 1);
					ch.put(map[nx][ny], 0);
				}

			}

		}

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		ch = new HashMap<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
			for (char c : s.toCharArray())
				ch.put(c, 0);
		}
		ch.put(map[0][0], 1);
		T.DFS(0, 0, 1);
		
		
		System.out.println(answer);
	}
}