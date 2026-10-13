class MyHashMap {

    private final int[] values;
    private final boolean[] present;

    public MyHashMap() {
        values = new int[1_000_001];
        present = new boolean[1_000_001];
    }
    
    public void put(int key, int value) {
        values[key] = value;
        present[key] = true;
    }
    
    public int get(int key) {
        return present[key] ? values[key] : -1;
    }
    
    public void remove(int key) {
        present[key] = false;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */