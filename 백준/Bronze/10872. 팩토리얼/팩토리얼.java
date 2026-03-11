import java.io.*;
import java.util.*;

public class Main {

	
	public int factorial(int n) {
		if(n == 0)
			return 1;
		else {
			return n * factorial(n-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		System.out.println(T.factorial(n));

	}

}