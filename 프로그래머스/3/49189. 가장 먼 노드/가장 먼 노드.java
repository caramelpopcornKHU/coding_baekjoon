import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    
    public int BFS(int start){
        
        Deque<Integer> Q = new ArrayDeque<>();
        ch[1] = 1;
        Q.offer(1);
        
        //각 레벨 별 사이즈
        int sizePerLevel = 0;
        
        while(!Q.isEmpty()) {
            int size = Q.size();
            sizePerLevel = size;
            while(size-- > 0){
                int nowNode = Q.poll();
                
                for (int nextNode : graph.get(nowNode)) {
                    if(ch[nextNode] == 0){
                        ch[nextNode] = 1;
                        Q.offer(nextNode);
                    }
                }
                
                
            }
        }
        
        return sizePerLevel;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList<>();
        // 중복 방문 방지용 ch배열
        ch = new int[n+1];
        
        // 0번:무시 || 1번부터 n번까지 그래프
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < edge.length; i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
            
        }
        
       answer = BFS(1);
        
        return answer;
    }
}