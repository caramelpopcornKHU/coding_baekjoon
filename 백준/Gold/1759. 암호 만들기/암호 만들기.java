import java.io.*;
import java.util.*;

public class Main {

	static int L, C;

	static char[] arr;

	static ArrayList<Character> chars;

	static BufferedWriter bw;

	public void DFS(int lv, int s) throws IOException {
		if (lv == L) {

			int moCnt = 0;
			int jaCnt = 0;
			for (char mo : arr) {
				if ((mo == 'a') || (mo == 'e') || (mo == 'i') || (mo == 'o') || (mo == 'u')) {
					moCnt++;
				} else {
					jaCnt++;
				}
			}

			if (moCnt >= 1 && jaCnt >= 2) {
				String answer = String.valueOf(arr);

				bw.write(answer + "\n");

			}
		} else {
			for (int i = s; i < chars.size(); i++) {
				arr[lv] = chars.get(i);
				DFS(lv + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[L];
		chars = new ArrayList<Character>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			char x = st.nextToken().toCharArray()[0];
			chars.add(x);
		}

		Collections.sort(chars);

		T.DFS(0, 0);

		bw.flush();
		bw.close();
		br.close();
	}
}