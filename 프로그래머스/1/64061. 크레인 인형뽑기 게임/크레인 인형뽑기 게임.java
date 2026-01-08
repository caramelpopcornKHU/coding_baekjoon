import java.io.*;
import java.util.*;

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Deque<Integer> stack = new ArrayDeque<>();

		for (int j : moves) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j - 1] == 0)
					continue;

				if (stack.isEmpty())
					stack.push(board[i][j - 1]);
				else {
					if (stack.peek() == board[i][j - 1]) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(board[i][j - 1]);
					}
				}
				board[i][j - 1] = 0;
				break;

			}
		}
		return answer;
	}
}