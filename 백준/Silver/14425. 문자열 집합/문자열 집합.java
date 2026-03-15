
import java.io.*;
import java.util.*;

public class Main {
	
	
	public int solution(int n, int m, Set<String> nSet, String[] mArr) {
		int answer = 0;
		
		for(String x : mArr) {
			if(nSet.contains(x)) {
				answer++;
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
		
		Set<String> nSet = new TreeSet<>();
		
		String[] mArr = new String[m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nSet.add(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			mArr[i] = st.nextToken();
		}
		
		System.out.println(T.solution(n,m,nSet,mArr));
		
		
	}
}