class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return 1;
        else if(stones.length==2) return Math.abs(stones[0]-stones[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones){
            pq.add(ele);
        }
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();

            if(a!=b) pq.add(Math.abs(a-b));
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}