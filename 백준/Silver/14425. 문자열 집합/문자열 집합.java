
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] ch;
	
	public int solution(int n, int m, String[] nArr, String[] mArr) {
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(nArr[i].equals(mArr[j])) {
//					System.out.println(mArr[j]);
					answer++;
					
				}
			}
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] nArr = new String[n];
		String[] mArr = new String[m];
		ch = new int[m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nArr[i] = st.nextToken();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			mArr[i] = st.nextToken();
		}
		
		System.out.println(T.solution(n,m,nArr,mArr));
		
		
	}
}