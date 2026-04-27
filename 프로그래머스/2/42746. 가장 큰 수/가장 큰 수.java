import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        PriorityQueue<MyNumber> pQ = new PriorityQueue<>();
        for(int x : numbers){
            pQ.offer(new MyNumber(String.valueOf(x)));
        }
        StringBuilder sb = new StringBuilder();
        
        String s = pQ.poll().num;
        
        if(s.equals("0"))
                return "0";
        else
            sb.append(s);
        
        while(!pQ.isEmpty()){
            
            
            
            
            sb.append(pQ.poll().num);
        }
        
        
        String answer = sb.toString();
        return answer;
    }
}

class MyNumber implements Comparable<MyNumber> {
    String num;
    
    MyNumber(String num){
        this.num = num;
    }
    
    @Override
    public int compareTo(MyNumber ob){
        
        // 10 9
        
        String a = this.num + ob.num; // 109
        String b = ob.num + this.num; // 910
        
        return b.compareTo(a);
    }
    
}