package design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuqiang
 * @create: 2020-05-18 21:00
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 *  
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache(2);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode146 {

    public static final class CacheNode {
        public int key;
        public int value;
        public CacheNode previous;
        public CacheNode next;

        public CacheNode() {

        }

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int capacity;
    public int size;
    public CacheNode head;
    public CacheNode tail;
    private final Map<Integer, CacheNode> cacheMap;

    public Leetcode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cacheMap = new HashMap(capacity);
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        CacheNode cacheNode = cacheMap.get(key);
        if (cacheNode == null) {
            return -1;
        }
        moveToHead(cacheNode);
        return cacheNode.value;
    }

    private void addNode(CacheNode cacheNode) {
        CacheNode tmp = head.next;

        head.next = cacheNode;
        cacheNode.previous = head;

        cacheNode.next = tmp;
        tmp.previous = cacheNode;
    }

    private void removeNode(CacheNode cacheNode) {
        cacheNode.previous.next = cacheNode.next;
        cacheNode.next.previous = cacheNode.previous;
    }

    private void moveToHead(CacheNode cacheNode) {
        removeNode(cacheNode);
        addNode(cacheNode);
    }

    private CacheNode popTail() {
        CacheNode cacheNode = tail.previous;
        removeNode(cacheNode);
        return cacheNode;
    }

    public void put(int key, int value) {
        CacheNode cacheNode = cacheMap.get(key);
        if (cacheNode != null) {
            cacheNode.value = value;
            moveToHead(cacheNode);
        }else {
            CacheNode newCacheNode = new CacheNode(key, value);
            cacheMap.put(key, newCacheNode);
            addNode(newCacheNode);
            ++size;

            if (size > capacity) {
                CacheNode tailCacheNode = popTail();
                cacheMap.remove(tailCacheNode.key);
                --size;
            }
        }

    }
}
