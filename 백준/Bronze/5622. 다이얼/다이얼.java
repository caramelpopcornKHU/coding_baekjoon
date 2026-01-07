import java.util.*;
import java.io.*;

public class Main {

	public int solution(String a) {
		int answer = 0;
		
		// 65 66 67
		// 68 69 70
		// 71 72 73
		
		for(char x : a.toCharArray()) {
			if(65 <= x && 68 > x) // A B C
				answer += 3;
			else if(68 <= x && 71 > x) // D E F
				answer += 4;
			else if(71 <= x && 74 > x) // G H I
				answer += 5;
			else if(74 <= x && 77 > x) // J K L
				answer += 6;
			else if(77 <= x && 80 > x) // M N O
				answer += 7;
			else if(80 <= x && 84 > x) // P Q R S
				answer += 8;
			else if(84 <= x && 87 > x) // T U V
				answer += 9;
			else if(87 <= x && 90 >= x) // W X Y Z
				answer += 10;
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		
		System.out.println(T.solution(a));

	}

}