
import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int whiteAnswer = 0, blueAnswer = 0;

	public void partition(int row, int col, int size) {
		// 마지막 로직
		if (checkPartition(row, col, size)) {
			if (arr[row][col] == 1) {
				blueAnswer++;
			} else {
				whiteAnswer++;
			}
			return;
		}

		int newSize = size / 2;
		
		partition(row, col, newSize);
		partition(row, col + newSize, newSize);
		partition(row + newSize, col, newSize);
		partition(row + newSize, col + newSize, newSize);

	}

	public boolean checkPartition(int row, int col, int size) {

		int color = arr[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		T.partition(0, 0, n);

		System.out.println(whiteAnswer);
		System.out.println(blueAnswer);

	}
}