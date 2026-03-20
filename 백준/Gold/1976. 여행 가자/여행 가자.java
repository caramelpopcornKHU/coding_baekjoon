
import java.util.*;
import java.io.*;

public class Main {

	static int[] unf;

	static int Find(int v) {
		if (v == unf[v])
			return v;
		else
			return unf[v] = Find(unf[v]);
	}

	static void Union(int a, int b) {
		int cityA = Find(a);
		int cityB = Find(b);
		unf[cityA] = cityB;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		unf = new int[n + 1];

		for (int i = 1; i <= n; i++)
			unf[i] = i;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1)
					Union(i+1,j+1);
			}
		}
		
		int[] travelArr = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int city = Integer.parseInt(st.nextToken());
			travelArr[i] = city;
		}
		boolean flag = true;
		for (int i = 0; i < m-1; i++) {
			if(Find(travelArr[i]) != Find(travelArr[i+1]))
				flag = false;
		}
		
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");			
		}
		
	}
}
