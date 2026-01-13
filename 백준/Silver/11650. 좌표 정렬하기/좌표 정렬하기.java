import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {

	public int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if (this.x == o.x)
			return this.y - o.y;
		else {
			return this.x - o.x;
		}

	}

}

public class Main {

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		ArrayList<Point> arr = new ArrayList<Point>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Point(x, y));
		}

		Collections.sort(arr);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (Point o : arr) {
			bw.write(o.x + " " + o.y + "\n");
		}

		bw.flush();

	}

}