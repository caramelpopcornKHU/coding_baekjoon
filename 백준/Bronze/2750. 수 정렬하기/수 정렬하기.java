import java.util.*;
import java.io.*;

public class Main {

	public void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// 선택 정렬 풀이
	public int[] solution(int n, int[] arr) {

		int idx = 0; // 가장 작은 인덱스를 나타내는 변수

		for (int i = 0; i < n; i++) {
			idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[idx] > arr[j]) {
					idx = j;
				}
			}
			swap(idx, i, arr);
		}

		return arr;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 퀵 소트 nlogn
		Arrays.sort(arr);
		for (int x : arr) {
			System.out.println(x);
		}

	}

}
