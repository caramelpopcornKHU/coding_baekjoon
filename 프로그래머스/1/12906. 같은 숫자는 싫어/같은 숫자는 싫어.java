import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> Q = new ArrayDeque<>();
        
        Q.offer(arr[0]);
        
        for(int x : arr){
            if(Q.peekLast() != x)
                Q.offer(x);
        }
        
        int[] answer = new int[Q.size()];
        int i = 0;
        while(!Q.isEmpty()){
            int val = Q.poll();
            answer[i] = val;
            i++;
        }
        
        return answer;
    }
}