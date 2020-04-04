package com.nick.algorithm.algorithm.lru;

/**
 * @author weizhong
 * @date 2020/3/28 3:48 PM
 * @package com.nick.algorithm.algorithm.lru
 * @description
 */
public class Node {

    public int key, value;
    public Node prev, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}
