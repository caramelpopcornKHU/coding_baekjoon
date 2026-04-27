import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0;
        long totalAmount = 0;
        ArrayList<Long> list = new ArrayList<>();



        for(int x : queue1){
            totalAmount += (long)x;
            sum += x;
            list.add( (long) x);
        }
        
        for(int y : queue2){
            totalAmount += (long)y;
            list.add( (long) y);
        }
        
        for(int x : queue1){
            list.add( (long) x);
        }
        if(totalAmount % 2 == 1)
            return -1;

        long half = totalAmount / 2;

        if(sum == half)
            return 0;
        
        int lt = 0;


        
        while(sum > half){
            sum -= list.get(lt);
            lt++;
            answer++;
            if(sum == half)
                return answer;
        }
        
    

        for(int rt = queue1.length; rt < list.size(); rt++){

            sum += list.get(rt);
            answer++;

            if(sum == half){
                return answer;
            } 
            if(sum > half){
                   while(sum >= half){
                       sum -= list.get(lt);
                       lt++;
                       answer++;
                       if(sum == half)
                           return answer;
                       if(lt >= rt)
                           break;
                   }


            }


            if(rt == list.size() - 1)
                return -1;
        }

        // 3 2 7 2 0 4 6 5 1 0 3 2 7 2 0
        //15
        // 1 2 1 2 0 1 10 1 2 0 1 2 1 2
        // 
        // 20
        return answer;
    }
}