import java.util.*;



class Solution {

    static int answer, n;

    

    static int[][] ch;

    

    public int solution(int[][] triangle) {

        answer = 0;

        n = triangle.length;

        

        if(n==1)

            return triangle[0][0];

        

        ch = new int[n+1][n+1];

       

        for(int j = 0; j < n; j++){

            ch[n-1][j] = triangle[n-1][j];

        }

        // n=5

        for(int i = n-2; i >= 0; i--){

            //i는 레밸

            for(int j=0; j<=i; j++){

                ch[i][j] = triangle[i][j] + Math.max(ch[i+1][j],ch[i+1][j+1]);

                

            }

        }

        if(n != 1)

            answer = triangle[0][0] + Math.max(ch[1][0],ch[1][1]);

        return answer;

    }

}