import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n+2];
        
        Arrays.fill(students,1);
        for(int x : lost){
            students[x] = 0;
        }
        for(int x : reserve){
            students[x] += 1;
        }
        
        for(int i = 1; i <= n; i++){
            if(students[i] == 0){
                
                if(students[i-1] == 2){
                    students[i-1] -= 1;
                    students[i] = 1;
                } else if(students[i+1] == 2){
                    students[i+1] -= 1;
                    students[i] = 1;
                }
                
            }
        }
        
        for(int x : students){
            if(x!=0) answer++;
        }
        
        return answer-2;
    }
}