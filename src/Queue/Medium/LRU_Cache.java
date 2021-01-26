package Queue.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache lruCache = new LRUCache(capacity);
            String[] str = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;
            for (int i = 0; (i < queries) && (i < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    lruCache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.println(lruCache.get(key));
                }
            }
        }
    }
}

class LRUCache {
    static int capacity;

    static class Node {
        int value, key;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static Node head, tail;
    static Map<Integer, Node> cache;

    LRUCache(int cap) {
        this.capacity = cap;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    // This method works in O(1)
    public static int get(int key) {
        int value = -1;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            value = node.value;
            deleteNode(node);
            addToHead(node);
        }
        return value;
    }

    // This method works in O(1)
    public static void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key,value);
            if (capacity > cache.size()) {
                addToHead(node);
            } else {
                //remove least recently used
                cache.remove(tail.prev.key); // trying to remove least recently used from cache map
                deleteNode(tail.prev); // deleting from tail
                addToHead(node); // adding to head so that We can under stand, it is recently used.
            }
            cache.put(key, node);
        }
    }

    public static void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}