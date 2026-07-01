class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int ele : asteroids){
            boolean survives = true;

            while(!st.isEmpty() && st.peek()>0 && ele<0){
                if(Math.abs(ele) > st.peek()){
                    st.pop();
                    continue;
                }
                else if(Math.abs(ele) == st.peek()){
                    st.pop();
                    survives = false;
                    break;
                }
                else {
                    survives = false;
                    break;
                }
            }

            if(survives) st.push(ele);
        }
        int[] result = new int[st.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = st.get(i);
        }
        return result;
    }
}