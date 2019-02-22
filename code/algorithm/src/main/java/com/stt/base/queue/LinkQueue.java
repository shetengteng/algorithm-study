package com.stt.base.queue;

import java.util.Iterator;

/**
 * Created by ttshe2 on 2019/2/22.
 */
public class LinkQueue<T> implements Iterable<T> {

    private class Node{
        Node next;
        T data;
    }

    private Node head;
    private Node tail;
    private int n = 0;

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return head == null;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(T data){
        Node newNode = new Node();
        newNode.data = data;
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        n += 1;
        return true;
    }

    public T dequeue(){
        T re = head.data;
        head = head.next;
        if(isEmpty()){
            // 注意尾部的释放
            tail = null;
        }
        n -= 1;
        return re;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T re = current.data;
                current = current.next;
                return re;
            }
        };
    }

    public static void main(String[] args) {

        LinkQueue<String> queue = new LinkQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        queue.forEach(q -> System.out.println(q));

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("------");

        queue.enqueue("d");
        queue.forEach(q -> System.out.println(q));

    }

}
