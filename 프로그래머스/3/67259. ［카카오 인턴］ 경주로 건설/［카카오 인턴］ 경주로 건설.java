import java.util.*;

class Solution {
    static int n;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer;

    static int[][] lowCostMap;

    // 직선 100 코너 500 최소 비용 계산

    public void DFS(int[][] board,int x, int y, int cost, int beforeState){
        if(cost >= answer)
            return;


        if((x == (n-1)) && ( y == (n-1)) ){
            answer = Math.min(answer,cost);
            return;
        } else {
            int costCopy = cost;

            for(int i = 0; i < 4; i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                boolean con1 = (nx > -1) && (nx < n);
                boolean con2 = (ny > -1) && (ny < n);

                if(con1 && con2 && board[nx][ny] == 0){
                    board[nx][ny] = 1;

                // 직선방향이냐
                if(beforeState == i && (lowCostMap[nx][ny] >= costCopy+100)){
                    lowCostMap[nx][ny] = costCopy+100;
                    DFS(board,nx,ny,costCopy+100,i);
                }
                // 꺽임이냐
                else{
                    if(beforeState == -1){
                        if(lowCostMap[nx][ny] >= costCopy+100) {
                            lowCostMap[nx][ny] = costCopy+100;
                            DFS(board,nx,ny,costCopy+100,i);
                        }
                    } else{
                        if(lowCostMap[nx][ny] >= costCopy-500) {
                            lowCostMap[nx][ny] = costCopy+600;
                            DFS(board,nx,ny,costCopy+600,i);
                        }
                    }
                }
                    board[nx][ny] = 0;
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        lowCostMap = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(lowCostMap[i],Integer.MAX_VALUE);
        }
        lowCostMap[0][0] = 0;
        DFS(board,0,0,0,-1);
        return answer;
    }
}