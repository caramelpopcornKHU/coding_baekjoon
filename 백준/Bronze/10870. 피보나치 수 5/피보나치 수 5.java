import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public int DFS(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 1;
		else {
			if (arr[n] == 0) {
				int a = DFS(n - 1) + DFS(n - 2);
				arr[n] = a;
				return a;
			} else {
				return arr[n];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		System.out.println(T.DFS(n));
	}
}