import java.util.*;
import java.io.*;

public class Main {

	public int solution(int n) {
		
		int cnt = 0;
		for (int i = 666; i <= 2666799; i++) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}
			if(cnt==n)
				return i;
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(T.solution(n));

	}

}