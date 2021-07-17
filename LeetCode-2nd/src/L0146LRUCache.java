import java.util.HashMap;
import java.util.Map;

/**
 * No.146 LRU缓存机制
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/17 15:49
 */
public class L0146LRUCache {
    public static void main(String[] args) {

    }
}

// /**
//  * 使用封装好的双向链表+哈希表数据结构
//  *
//  * @author Neil
//  * @date 2021/7/17 20:08
//  * @version v1.0
//  */
// class LRUCache extends LinkedHashMap<Integer, Integer> {
//     private int capacity;
//
//     public LRUCache(int capacity) {
//         super(capacity, 0.75F, true);
//         this.capacity = capacity;
//     }
//
//     public int get(int key) {
//         return super.getOrDefault(key, -1);
//     }
//
//     public void put(int key, int value) {
//         super.put(key, value);
//     }
//
//     @Override protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return this.size() > this.capacity;
//     }
// }

/**
 * 自定义双向链表 + 哈希表
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/17 20:16
 */
class LRUCache {
    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;

        public DoubleLinkedNode() {
        }

        public DoubleLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    private DoubleLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DoubleLinkedNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value);
            if (size == capacity) {
                DoubleLinkedNode last = removeTail();
                cache.remove(last.key);
                System.out.println(size);
                size--;
            }
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
        }
    }

    public void moveToHead(DoubleLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void addToHead(DoubleLinkedNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

    }

    public void removeNode(DoubleLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
