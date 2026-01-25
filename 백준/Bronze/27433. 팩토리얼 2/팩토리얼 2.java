import java.io.*;
import java.util.*;

public class Main {

	public long DFS(long n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		else {
			return n * DFS(n - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(T.DFS(n));
	}
}
