import java.io.*;
import java.util.*;

public class Main {

	static int n, answer = 0;
	static int[] arr;

	static int[] dy;

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		dy = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (n == 1) {

			dy[1] = arr[1];
		} else if (n == 2) {

			dy[1] = arr[1];
			dy[2] = arr[1] + arr[2];
		} else if (n == 3) {

			dy[1] = arr[1];
			dy[2] = arr[1] + arr[2];
			dy[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
		} else {
			dy[1] = arr[1];
			dy[2] = arr[1] + arr[2];
			dy[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
			
			for (int i = 4; i <= n; i++) {
				int x = dy[i-3] + arr[i-1] + arr[i];
				int y = dy[i-2] + arr[i];
				dy[i] = Math.max(x, y);
			}
			
		}

		System.out.println(dy[n]);

	}
}