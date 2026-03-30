import java.io.*;
import java.util.*;

class Number implements Comparable<Number> {
	int val;
	int bin;

	Number(int val, int bin) {
		this.val = val;
		this.bin = bin;
	}

	@Override
	public int compareTo(Number ob) {
		if (this.bin == ob.bin)
			return this.val - ob.val;
		else
			return this.bin - ob.bin;
	}

}

public class Main {

	static int timer = 0;

	static int r, c, k;

	static int[][] arr;

	public boolean rFunction() {

		int cntMax = 0;

		ArrayList<PriorityQueue<Number>> newRow = new ArrayList<>();
		for (int j = 0; j <= arr.length; j++)

			newRow.add(new PriorityQueue<Number>());

		for (int i = 1; i < arr.length; i++) {

			HashMap<Integer, Integer> row = new HashMap<>();

			for (int num : arr[i]) {
				if (num == 0)
					continue;
				row.put(num, row.getOrDefault(num, 0) + 1);
			}
			for (int key : row.keySet()) {
				newRow.get(i).add(new Number(key, row.get(key)));
			}

			cntMax = Math.min(100, Math.max(newRow.get(i).size() * 2, cntMax));

		}

		arr = new int[arr.length][cntMax + 1];

		for (int i = 1; i < arr.length; i++) {
			int idx = 1;
			while (!newRow.get(i).isEmpty()) {
				Number n = newRow.get(i).poll();
				arr[i][idx++] = n.val;
				if (idx > 100)
					break;
				arr[i][idx++] = n.bin;
				if (idx > 100)
					break;
			}
		}

		if (r < arr.length && c < arr[0].length && arr[r][c] == k)
			return true;
		else
			return false;
	}

	public boolean cFunction() {
		int cntMax = 0;

		int oldColSize = arr[0].length;

		ArrayList<PriorityQueue<Number>> newCol = new ArrayList<>();
		for (int j = 0; j < arr[0].length; j++)
			newCol.add(new PriorityQueue<Number>());

		for (int i = 1; i < arr[0].length; i++) {

			HashMap<Integer, Integer> col = new HashMap<>();

			for (int j = 1; j < arr.length; j++) {
				if (arr[j][i] == 0)
					continue;
				col.put(arr[j][i], col.getOrDefault(arr[j][i], 0) + 1);
			}

			for (int key : col.keySet()) {
				newCol.get(i).add(new Number(key, col.get(key)));
			}

			cntMax = Math.min(100, Math.max(newCol.get(i).size() * 2, cntMax));

		}

		arr = new int[cntMax + 1][oldColSize];

		for (int i = 1; i < arr[0].length; i++) {
			int idx = 1;
			while (!newCol.get(i).isEmpty()) {
				Number n = newCol.get(i).poll();
				arr[idx++][i] = n.val;
				if (idx > 100)
					break;
				arr[idx++][i] = n.bin;
				if (idx > 100)
					break;
			}
		}

		if (r < arr.length && c < arr[0].length && arr[r][c] == k)
			return true;
		else
			return false;

	}

	public void solution() {

		while (timer <= 100) {
			timer++;
			if (arr.length >= arr[0].length) {
				if (rFunction()) {
					System.out.println(timer);
					return;
				}
			} else {
				if (cFunction()) {
					System.out.println(timer);
					return;
				}
			}
		}

		System.out.println(-1);

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[4][4];

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (r < arr.length && c < arr[0].length && arr[r][c] == k) {
			System.out.println(0);
		} else {
			T.solution();
		}

	}
}
