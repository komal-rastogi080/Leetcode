class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        q.add(t);
        int up = t-3000;
        while(q.peek()<up) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */