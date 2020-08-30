/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        // 先把新节点 x 做出来
        Node x = new Node(key, value);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        // 在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node node) {
            if (head == null) {
                head = tail = node;
            } else {
                Node n = head;
                n.prev = node;
                node.next = n;
                head = node;
            }
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node node) {
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                node.next.prev = null;
                head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        // 删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
