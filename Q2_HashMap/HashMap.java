class MyHashMap {
    // Node class for handling collisions using chaining
    class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    private static final int INITIAL_CAPACITY = 1000;
    private Node[] buckets;
    private int size;
    private int capacity;
    
    public MyHashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.buckets = new Node[capacity];
        this.size = 0;
    }
    
    // Hash function to map key to bucket index
    private int hash(int key) {
        return key % capacity;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        
        // If bucket is empty, create new node
        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
            size++;
            return;
        }
        
        // Search for existing key in the chain
        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                // Update existing key
                current.value = value;
                return;
            }
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        
        // Add new node at the end of chain
        current.next = new Node(key, value);
        size++;
        
        // Check if resize is needed (load factor > 0.75)
        if (size > capacity * 0.75) {
            resize();
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];
        
        // Search through the chain
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        
        // If bucket is empty
        if (current == null) {
            return;
        }
        
        // If first node is the target
        if (current.key == key) {
            buckets[index] = current.next;
            size--;
            return;
        }
        
        // Search for the key in the chain
        while (current.next != null) {
            if (current.next.key == key) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
    
    // Resize the hash table when load factor exceeds threshold
    private void resize() {
        Node[] oldBuckets = buckets;
        int oldCapacity = capacity;
        
        // Double the capacity
        capacity = capacity * 2;
        buckets = new Node[capacity];
        size = 0;
        
        // Rehash all existing elements
        for (int i = 0; i < oldCapacity; i++) {
            Node current = oldBuckets[i];
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
    
    // Helper method to get current size
    public int size() {
        return size;
    }
    
    // Helper method to check if map is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Helper method to display the hash map (for debugging)
    public void display() {
        System.out.println("HashMap contents:");
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                Node current = buckets[i];
                while (current != null) {
                    System.out.print("(" + current.key + "," + current.value + ")");
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
        System.out.println("Size: " + size + ", Capacity: " + capacity);
    }
}

// Test class to demonstrate the HashMap functionality
public class MyHashMapTest {
    public static void main(String[] args) {
        System.out.println("=== Custom HashMap Test ===");
        
        MyHashMap obj = new MyHashMap();
        
        System.out.println("MyHashMap obj = new MyHashMap();");
        
        obj.put(1, 10);
        System.out.println("obj.put(1, 10);");
        
        obj.put(2, 20);
        System.out.println("obj.put(2, 20);");
        
        int result1 = obj.get(1);
        System.out.println("obj.get(1); // returns " + result1); // returns 10
        
        int result2 = obj.get(3);
        System.out.println("obj.get(3); // returns " + result2); // returns -1
        
        obj.put(2, 30);
        System.out.println("obj.put(2, 30); // update existing key");
        
        int result3 = obj.get(2);
        System.out.println("obj.get(2); // returns " + result3); // returns 30
        
        obj.remove(2);
        System.out.println("obj.remove(2);");
        
        int result4 = obj.get(2);
        System.out.println("obj.get(2); // returns " + result4); // returns -1
        
        System.out.println("\n=== Additional Test Cases ===");
        
        
        MyHashMap map = new MyHashMap();
        
   
        map.put(1, 100);
        map.put(1001, 200); 
        map.put(2001, 300); 
        
        System.out.println("Testing collision handling:");
        System.out.println("get(1): " + map.get(1));    
        System.out.println("get(1001): " + map.get(1001));
        System.out.println("get(2001): " + map.get(2001));
        
        // Test updating values in collision chain
        map.put(1001, 250);
        System.out.println("After updating 1001 to 250:");
        System.out.println("get(1001): " + map.get(1001));
        
        // Test removing from collision chain
        map.remove(1001);
        System.out.println("After removing 1001:");
        System.out.println("get(1001): " + map.get(1001));
        System.out.println("get(1): " + map.get(1)); 
        System.out.println("get(2001): " + map.get(2001));
        
        System.out.println("\n=== Performance Test ===");
        MyHashMap perfMap = new MyHashMap();
        long startTime = System.currentTimeMillis();
        
        // Insert 10000 key-value pairs
        for (int i = 0; i < 10000; i++) {
            perfMap.put(i, i * 10);
        }
        
        // Retrieve all values
        int retrievedCount = 0;
        for (int i = 0; i < 10000; i++) {
            if (perfMap.get(i) != -1) {
                retrievedCount++;
            }
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Inserted and retrieved " + retrievedCount + " items");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        System.out.println("HashMap size: " + perfMap.size());
    }
}