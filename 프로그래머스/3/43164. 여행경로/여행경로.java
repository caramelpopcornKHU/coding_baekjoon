import java.util.*;

class Solution {

    static HashMap<String, ArrayList<Airport>> graph;
    
    static ArrayList<String> answerList;
    
    // ch hashmap 언급되면 증가시키자
    static HashMap<String, ArrayList<Integer>> ch;
    
    public String[] solution(String[][] tickets) {
        
        graph = new HashMap<>();
        ch = new HashMap<>();
        
        // 그래프 노드 자리 만들기
        for (int i = 0; i < tickets.length; i++){
            String city1 = tickets[i][0];
            String city2 = tickets[i][1];
            
            graph.putIfAbsent(city1, new ArrayList<Airport>());
            graph.putIfAbsent(city2, new ArrayList<Airport>());
           ch.putIfAbsent(city1, new ArrayList<Integer>()); 
            
            graph.get(city1).add(new Airport(city2));
           ch.get(city1).add(0);
        }
     
        
        for(String city : graph.keySet()){
            Collections.sort(graph.get(city));
        }
        
        
        answerList = new ArrayList<>();
        answerList.add("ICN");
        for(int i = 0; i < tickets.length; i++){
            answerList.add("");
        }
        
        DFS("ICN", 1, tickets.length);
    
        
        
        String[] answer = new String[answerList.size()];
        
        for(int i = 0; i < answerList.size(); i++){
             answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static boolean found = false;
    
    public void DFS(String city, int now ,int max){
        if(found == true)
            return;
            
        if(max+1 == now){
             found = true;
        } else{
            
            for(int i = 0; i < graph.get(city).size(); i++){
               if(ch.get(city).get(i) == 0)   {
                    ch.get(city).set(i, 1);
                   
                    answerList.set(now, graph.get(city).get(i).name);
                   DFS(graph.get(city).get(i).name, now+1,max);
                   if(found == true)
                       return;
                     ch.get(city).set(i, 0);
                }
            }
        }
            

    }
}

class Airport implements Comparable<Airport>{
    String name;
    
    Airport(String name){
        this.name = name;
    }
    
    @Override
    public int compareTo(Airport ob){
            return this.name.compareTo(ob.name);
    }
    
}

