import java.io.*;
import java.util.*;

public class Main {

	static char[] c;
	static int len;

	public void DFS(int lt, int rt) {

		int a = (rt - lt) / 3;
		int b = ((rt - lt) / 3) * 2;
		if (a == 0 || b == 0)
			return;
		for (int i = lt + a; i < lt + b; i++) {
			c[i] = ' ';
		}

		DFS(lt, lt + a);
		DFS(lt + b, rt);

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> arr = new ArrayList<Integer>();
		String st = "";

		while ((st = br.readLine()) != null && !st.isEmpty()) {
			arr.add(Integer.parseInt(st));
		}

		for (int x : arr) {
			int lt = 0;
			len = (int) Math.pow(3, x);

			c = new char[len];

			for (int i = 0; i < len; i++) {
				c[i] = '-';
			}

			T.DFS(lt, len);

			System.out.println(String.valueOf(c));
		}

	}
}