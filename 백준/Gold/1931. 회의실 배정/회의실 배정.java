
import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
	Long start;
	Long end;

	Meeting(Long start, Long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting ob) {

		if (this.end == ob.end)
			return Long.compare(this.start, ob.start);
		else
			return Long.compare(this.end, ob.end);
	}
}

public class Main {

	public int solution(int n, ArrayList<Meeting> arr) {
		int answer = 0;

		Long maxTime = Long.MIN_VALUE;

		for (Meeting m : arr) {
			if (m.start >= maxTime) {
				maxTime = m.end;
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
		ArrayList<Meeting> arr = new ArrayList<Meeting>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Long start = Long.parseLong(st.nextToken());
			Long end = Long.parseLong(st.nextToken());
			arr.add(new Meeting(start, end));
		}

		Collections.sort(arr);

		System.out.println(T.solution(n, arr));
	}
}