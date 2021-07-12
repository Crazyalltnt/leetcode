package other;

import java.util.*;

/**
 * No.460 LFU Cache
 * https://leetcode-cn.com/problems/lfu-cache
 *
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 *
 * 示例：
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lFUCache.get(1);      // 返回 1
 *                       // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 *                       // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lFUCache.get(2);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 *                       // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 *                       // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lFUCache.get(1);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 *                       // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lFUCache.get(4);      // 返回 4
 *                       // cache=[3,4], cnt(4)=2, cnt(3)=3
 *
 * 提示：
 * 0 <= capacity, key, value <= 104
 * 最多调用 105 次 get 和 put 方法
 *
 * 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？
 *
 * @author Neil
 * @version v1.0
 * @date 2021/7/6 16:14
 */
public class L0460LFUCache {
    public static void main(String[] args) {

    }
}

/**
 * LFU 缓存 哈希表 + 平衡二叉树
 */
// class LFUCache {
//     /**
//      * 缓存容量 时间戳
//      */
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
//         // 如果哈希表中没有键Key，返回-1
//         if (!keyTable.containsKey(key)) {
//             return -1;
//         }
//         // 从哈希表中得到旧的缓存
//         Node cache = keyTable.get(key);
//         s.remove(cache);
//         // 更新旧缓存
//         cache.cnt += 1;
//         cache.time = ++time;
//         // 将新缓存重新放入哈希表和平衡二叉树中
//         s.add(cache);
//         keyTable.put(key, cache);
//
//         return cache.value;
//     }
//
//
//     public void put(int key, int value) {
//         if (capacity == 0) {
//             return;
//         }
//         if (!keyTable.containsKey(key)) {
//             // 如果到达缓存容量上限
//             if (keyTable.size() == capacity) {
//                 // 从哈希表和平衡二叉树中删除最近最少使用的缓存
//                 keyTable.remove(s.first().key);
//                 s.remove(s.first());
//             }
//             // 创建新的缓存
//             Node cache = new Node(1, ++time, key, value);
//             // 将新缓存放入哈希表和平衡二叉树中
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
//     Node(int cnt, int time, int key, int value) {
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
//             Node anotherObject = (Node)anObject;
//             return this.cnt == anotherObject.cnt && this.time == anotherObject.time;
//         }
//         return false;
//     }
//
//     @Override public int compareTo(Node anObject) {
//         return cnt == anObject.cnt ? time - anObject.time : cnt - anObject.cnt;
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
                Node node = freqTable.get(minFreq).peekLast();
                keyTable.remove(node.key);
                freqTable.get(minFreq).pollLast();
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