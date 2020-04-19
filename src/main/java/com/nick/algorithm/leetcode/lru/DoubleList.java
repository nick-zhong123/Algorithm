package com.nick.algorithm.leetcode.lru;

/**
 *
 * @author weizhong
 * @date 2020/3/28 3:50 PM
 * @package com.nick.algorithm.algorithm.lru
 * @description
 *
 *
 */
public class DoubleList {

    private Node head, tail;
    private int capacitySize;

    public DoubleList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 在链表头部添加节点
     */
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        capacitySize++;
    }

    /**
     * 删除节点，默认节点存在
     * @param x
     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        capacitySize--;
    }

    public Node removeLast() {
        if (head == tail) {
            return null;
        }
        Node x = tail.prev;
        remove(x);
        return x;
     }

     public int size() {
        return capacitySize;
     }

}
