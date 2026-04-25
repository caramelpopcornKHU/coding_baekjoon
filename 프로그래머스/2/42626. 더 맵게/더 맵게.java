import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        if(scoville.length == 0)
            return -1;
        
        if(scoville.length == 1){
            if(scoville[0] >= K)
                return 0;
            else
                return -1;
        }
        
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int x : scoville){
            pQ.offer(x);
        }
        int day = 0;
        while(pQ.size() >= 2){
            // 일단 하나 꺼내보기
            int output = pQ.poll();
            // 최소값이 이미 이상이면 값을 찾음
            if (output >= K)
                return day;
            // 만족을 못했으니 두번째도 꺼내기
            int secondOutput = pQ.poll();
            
            int mixture = output + secondOutput * 2;
            pQ.offer(mixture);
            
            day++;
        }
        int lastOut = pQ.poll();
        if(lastOut >= K)
            return day;
        else
            answer = -1;
        
        return answer;
    }
}