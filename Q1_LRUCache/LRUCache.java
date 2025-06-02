import java.util.HashMap;
import java.util.Map;

class LRUCache {
    // Node class for doubly linked list
    class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Create dummy head and tail nodes
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move the accessed node to head (most recently used)
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToHead(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            
            if (cache.size() >= capacity) {
                // Remove least recently used node
                Node tail = removeTail();
                cache.remove(tail.key);
            }
            
            // Add new node to head and cache
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }
    
    //  method to add node right after head
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    //  method to remove a node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    //  method to move node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    // Helper method to remove the last node (before tail)
    private Node removeTail() {
        Node last = tail.prev;
        removeNode(last);
        return last;
    }
}

// Test class to demonstrate the LRU Cache
public class LRUCacheTest {
    public static void main(String[] args) {
        System.out.println("=== LRU Cache Test ===");
        
        LRUCache lru = new LRUCache(2);
        
        System.out.println("LRUCache lru(2);");
        
        lru.put(1, 1);
        System.out.println("lru.put(1, 1);");
        
        lru.put(2, 2);
        System.out.println("lru.put(2, 2);");
        
        int result1 = lru.get(1);
        System.out.println("lru.get(1); // returns " + result1);
        
        lru.put(3, 3);
        System.out.println("lru.put(3, 3); // evicts key 2");
        
        int result2 = lru.get(2);
        System.out.println("lru.get(2); // returns " + result2);
        
        lru.put(4, 4);
        System.out.println("lru.put(4, 4); // evicts key 1");
        
        int result3 = lru.get(1);
        System.out.println("lru.get(1); // returns " + result3);
        
        int result4 = lru.get(3);
        System.out.println("lru.get(3); // returns " + result4);
        
        int result5 = lru.get(4);
        System.out.println("lru.get(4); // returns " + result5); 
        
        System.out.println("\n=== Additional Test Cases ===");
        
       
        LRUCache lru2 = new LRUCache(1);
        lru2.put(5, 5);
        System.out.println("Single capacity cache - put(5,5), get(5): " + lru2.get(5));
        lru2.put(6, 6);
        System.out.println("After put(6,6), get(5): " + lru2.get(5));
        System.out.println("get(6): " + lru2.get(6)); 
    }
}