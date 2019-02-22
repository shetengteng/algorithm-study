package com.stt.base.queue;

/**
 * 循环队列
 * 判断为空还是满的2种情况
 * 情况1：单独设置一个标识区判断队列是满还是空
 * 情况2：少用一个元素空间，约定 队列的head在tail的下一个位的位置上 为满
 * Created by ttshe2 on 2019/2/22.
 */
public class CircularQueue<T> {

    private Object[] items;
    private int head = 0;
    private int tail = 0;
    private int n;

    CircularQueue(int capcity){
        n = capcity + 1;
        items = new Object[n];
    }

    public int size(){
        return (tail - head + n) % n;
    }

    /**
     * 入队操作
     * @param item
     * @return
     */
    public boolean enqueue(T item){
        if(nextIndex(tail) == head){ // 表示满了，tail的下一个是head
            return false;
        }
        items[tail] = item;
        tail = nextIndex(tail); // tail + 1操作
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public T dequeue(){
        if(tail == head) {
            return null;
        }
        Object re = items[head];
        head = nextIndex(head);
        return (T)re;
    }


    /**
     * 获取当前位置的下一个位置，由于是环形，使用取余数在最后一个位置+1的时候可以返回到头部
     * @param current
     * @return
     */
    private int nextIndex(int current){
        return (current + 1) % n;
    }

    public static void main(String[] args) {

        CircularQueue<String> queue = new CircularQueue<>(3);
        queue.enqueue("a");
        queue.enqueue("b");
        System.out.println(queue.enqueue("c"));
        System.out.println(queue.enqueue("d"));
        System.out.println(queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
