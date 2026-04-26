class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){ 
            leftMax = Math.max(sizes[i][0],leftMax);
            rightMax = Math.max(sizes[i][1],rightMax);
            
        }
        answer = leftMax * rightMax;
        return answer;
    }
}