package com.nick.concurrence.juejin.reentrantlock.blockqueue;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weizhong
 * @date 2020/4/19 4:28 PM
 * @package com.nick.concurrence.juejin.reentrantlock.blockqueue
 * @description
 *  阻塞队列是一种特殊的先进先出队列，它有以下几种特点：
 *  1.入队和出队线程安全
 *  2.
 *
 */
@Slf4j
public class MyBlockingQueue<E> {

    int size;
    LinkedList<E> list = Lists.newLinkedList();

    ReentrantLock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int size) {
        this.size = size;
    }

    public void enqueue(E e) throws InterruptedException {
        lock.lock();
         try {
             while(list.size() == size) {
                 notFull.await();
             }
            list.add(e);
            log.info("------->>>>>>> 入队:{}", e);
            notEmpty.signal();
         } finally {
             lock.unlock();
         }
    }

    public E dequeue() throws InterruptedException {
        E e;
        lock.lock();
        try {
            while(CollectionUtils.isEmpty(list)) {
                notEmpty.await();
            }
            e = list.removeFirst();
            log.info("-------<<<<<<< 出队:{}", e);
            notFull.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        int size = 2;
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue(size);
        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(() -> {
                try {
                    myBlockingQueue.enqueue(data);
                } catch (InterruptedException e) {
                    log.error("MyBlockingQueue Enqueue,", e);
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    int data = myBlockingQueue.dequeue();
                } catch (InterruptedException e) {
                    log.error("MyBlockQueue Dequeue,", e);
                }
            }).start();
        }
    }
}
