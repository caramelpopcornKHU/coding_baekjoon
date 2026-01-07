import java.util.*;
import java.io.*;

public class Main {

	public int solution(String a, String b) {
		int p = Integer.parseInt(new StringBuilder(a).reverse().toString());
		int q = Integer.parseInt(new StringBuilder(b).reverse().toString());
		
		return Math.max(p, q);
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		
		System.out.println(T.solution(a,b));

	}

}
