import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> {
            return a[1] - b[1];
        });
        
        int idx = Integer.MIN_VALUE;
        
        for(int i = 0; i < routes.length; i++){
            if(routes[i][0] > idx){
                idx = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}
// -20 -15
// -18 -13
// -14 -5
// -5 -3