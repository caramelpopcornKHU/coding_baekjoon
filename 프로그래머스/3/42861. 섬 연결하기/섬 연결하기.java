import java.util.*;

class Solution {
    static int[] unf;
    
    static int Find(int v){
        if(unf[v] == v){
            return v;
        } else{
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b){
        int findA = Find(a);
        int findB = Find(b);
        unf[findB] = findA;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        unf = new int[n];
        
        for(int i = 0; i < n; i++) unf[i] = i;
        
        Arrays.sort(costs, (a,b)->{
            return a[2] - b[2];
        });
        
        for(int i = 0;  i < costs.length; i++){
            int a = Find(costs[i][0]);
            int b = Find(costs[i][1]);
            
            if(a != b){
                Union(costs[i][0],costs[i][1]);
                answer += costs[i][2];
            }
            
        }
        
        return answer;
    }
}