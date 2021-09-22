import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

/**
 * No.460 LFU 缓存
 *
 * @author Neil
 * @version v1.0
 * @date 2021/9/22 20:13
 */
public class L0460LFUCache {
    public static void main(String[] args) {

    }
}

// class LFUCache {
//     int capacity, time;
//     Map<Integer, Node> keyTable;
//     TreeSet<Node> s;
//
//     public LFUCache(int capacity) {
//         this.capacity = capacity;
//         this.time = 0;
//         keyTable = new HashMap<>();
//         s = new TreeSet<>();
//     }
//
//     public int get(int key) {
//         if (capacity == 0) {
//             return -1;
//         }
//         if (!keyTable.containsKey(key)) {
//             return -1;
//         }
//
//         Node cache = keyTable.get(key);
//         s.remove(cache);
//         cache.cnt++;
//         cache.time = ++time;
//         s.add(cache);
//         keyTable.put(key, cache);
//         return cache.value;
//     }
//
//     public void put(int key, int value) {
//         if (capacity == 0) {
//             return;
//         }
//         if (!keyTable.containsKey(key)) {
//             if (keyTable.size() == capacity) {
//                 keyTable.remove(s.first().key);
//                 s.remove(s.first());
//             }
//             Node cache = new Node(1, ++time, key, value);
//             keyTable.put(key, cache);
//             s.add(cache);
//         } else {
//             Node cache = keyTable.get(key);
//             s.remove(cache);
//             cache.cnt += 1;
//             cache.time = ++time;
//             cache.value = value;
//             s.add(cache);
//             keyTable.put(key, cache);
//         }
//     }
// }
//
// class Node implements Comparable<Node> {
//     int cnt, time, key, value;
//
//     public Node(int cnt, int time, int key, int value) {
//         this.cnt = cnt;
//         this.time = time;
//         this.key = key;
//         this.value = value;
//     }
//
//     @Override public boolean equals(Object anObject) {
//         if (this == anObject) {
//             return true;
//         }
//         if (anObject instanceof Node) {
//             Node rhs = (Node) anObject;
//             return this.cnt == rhs.cnt && this.time == rhs.time;
//         }
//         return false;
//     }
//
//     @Override public int compareTo(Node rhs) {
//         return cnt == rhs.cnt ? time - rhs.time : cnt - rhs.cnt;
//     }
//
//     @Override public int hashCode() {
//         return cnt * 1000000007 + time;
//     }
// }

class LFUCache {
    int minFreq, capacity;
    Map<Integer, Node> keyTable;
    Map<Integer, LinkedList<Node>> freqTable;

    public LFUCache(int capacity) {
        this.minFreq = 0;
        this.capacity = capacity;
        keyTable = new HashMap<>();
        freqTable = new HashMap<>();
    }

    public int get(int key) {
        if (capacity == 0) {
            return -1;
        }
        if (!keyTable.containsKey(key)) {
            return -1;
        }
        Node node = keyTable.get(key);
        int val = node.val, freq = node.freq;
        freqTable.get(freq).remove(node);
        // 如果当前链表为空，我们需要在哈希表中删除，并更新minFreq
        if (freqTable.get(freq).size() == 0) {
            freqTable.remove(freq);
            if (minFreq == freq) {
                minFreq += 1;
            }
        }
        // 插入到 freq+1 中
        LinkedList<Node> list = freqTable.getOrDefault(freq + 1, new LinkedList<>());
        list.offerFirst(new Node(key, val, freq + 1));
        freqTable.put(freq + 1, list);
        keyTable.put(key, freqTable.get(freq + 1).peekFirst());

        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (!keyTable.containsKey(key)) {
            // 缓存已满，需要进行删除
            if (keyTable.size() == capacity) {
                // 通过minFreq拿到freqTable[minFreq]链表的末尾
                Node node = freqTable.get(minFreq).pollLast();
                keyTable.remove(node.key);
                if (freqTable.get(minFreq).size() == 0) {
                    freqTable.remove(minFreq);
                }
            }
            LinkedList<Node> list = freqTable.getOrDefault(1, new LinkedList<>());
            list.offerFirst(new Node(key, value, 1));
            freqTable.put(1, list);
            keyTable.put(key, freqTable.get(1).peekFirst());
            minFreq = 1;
        } else {
            Node node = keyTable.get(key);
            int freq = node.freq;
            freqTable.get(freq).remove(node);
            if (freqTable.get(freq).size() == 0) {
                freqTable.remove(freq);
                if (minFreq == freq) {
                    minFreq += 1;
                }
            }
            LinkedList<Node> list = freqTable.getOrDefault(freq + 1, new LinkedList<>());
            list.offerFirst(new Node(key, value, freq + 1));
            freqTable.put(freq + 1, list);
            keyTable.put(key, freqTable.get(freq + 1).peekFirst());
        }
    }
}

class Node {
    int key, val, freq;

    Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */