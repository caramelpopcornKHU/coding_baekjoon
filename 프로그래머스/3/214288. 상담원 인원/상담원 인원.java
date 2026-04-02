import java.util.*;
class Solution {
    
    static int[] pm;
    static ArrayList<Deque<Request>> requests;
    static int globalAns = Integer.MAX_VALUE;
    
    
    // 1 0 k n
    public void DFS(int L, int s, int k, int n){
        if(s > n) return;
        if(L == k+1){
            
            if(s != n)
                return;
            
            int tempAns1 = 0;
            int tempAns2 = 0;
            
            for(int i = 1; i <= k; i++) {
                int server = pm[i]; // k번 분과는 상담원이 pm[i] 명
                int timeWait = 0;
                
                PriorityQueue<Integer> Q = new PriorityQueue<>();
                
                // 최소 종업원 1명~ 추가 증원된 종업원
                for(int j = 0; j < server; j++) {
                    Q.offer(0); 
                }
                
                // 남은 요청 털어버리기
                // 순서대로 꺼내고
                for(Request req : requests.get(i)){
                    
                    int nextEnd = Q.poll();
                    
                    if(nextEnd > req.startTime){
                        timeWait += nextEnd - req.startTime;
                        Q.offer(nextEnd + req.dur);
                    } else{
                        Q.offer(req.startTime + req.dur);
                    }
                    
                }
               
                tempAns1 += timeWait;
            }
            
            // 최소값
            globalAns = Math.min(globalAns,tempAns1);
        } else{
            for(int i = 1; i <= n; i++){
                pm[L] = i;
                DFS(L+1, s+ i,k,n);
            }
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
    
        
        // 0번 + 1 ~ k번
        requests = new ArrayList<>();
        
        for(int i = 0; i <= k; i++)
            requests.add(new ArrayDeque<Request>());
        
        for (int i = 0; i < reqs.length; i++){
            int startTime = reqs[i][0];
            int dur = reqs[i][1];
            int type = reqs[i][2];
            requests.get(type).offer(new Request(startTime,dur));
        }
        
         
        
        pm = new int[k+1];
        
        // 종업원 분배 k번째 분과 - n개를 쪼개기
        DFS(1, 0, k, n);
        
        answer = globalAns;
        
        return answer;
    }
}

class Request {
    int startTime;
    int dur;
   
    
    Request(int startTime, int dur){
        this.startTime  = startTime;
        this.dur = dur;
        
    }
    
   
}
