class MyHashSet {
    private boolean[] arr;
    public MyHashSet() {
        arr = new boolean[1_000_001];
    }
    
    public void add(int key) {
        if(!this.arr[key]) this.arr[key] = true;
    }
    
    public void remove(int key) {
        this.arr[key] = false;
    }
    
    public boolean contains(int key) {
        return this.arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */