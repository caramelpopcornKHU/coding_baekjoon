import java.util.*;

class Solution {
    
    public long executableTime(long time, int[] times){
        
        // time일때 처리할 수 있는 n은?
        long num = 0;
        
        for(int x : times){
            num += time / x;
        }
        
        return num;
       
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        
        long a = 1;
        long b = (long) times[times.length-1] * n;
        
        while(a <= b){
            long mid = (a + b) / 2;
            
            if(n > executableTime(mid, times)){
                a = mid + 1;
            } else{
                b = mid - 1;
                
            }
            
            
        }
        
        answer = a;
        return answer;
    }
}