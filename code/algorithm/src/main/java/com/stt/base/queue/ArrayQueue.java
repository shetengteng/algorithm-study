package com.stt.base.queue;

import java.util.ArrayList;

/**
 * 数组队列
 * Created by ttshe2 on 2019/2/22.
 */
public class ArrayQueue {

    private Object[] items;
    private int n;
    private int tail=0;
    private int head=0;

    ArrayQueue(int capacity){
        items = new Object[capacity];
        n = capacity;
    }

    /**
     * 入队操作
     * @param item
     * @return
     */
    public boolean enqueue(Object item){
        // 表示满了
        if(tail == n){
            return false;
        }
        items[tail]=item;
        tail += 1;
        return true;
    }

    /**
     * 入队操作改，原先的入队操作有重复出队入队后不能再操作的问题，这里进行修改，在满栈的时候进行数据转移操作
     * @param item
     * @return
     */
    public boolean enqueue2(Object item){
        if(tail == n){
            // 进行数据转移判断
            if(head == 0){
                // 表示队列真的满了
                return false;
            }
            // 进行数据的搬移
            for(int i = head;i<tail;i++){
                items[i-head]=items[i];
            }
            // 对tail和head进行重置
            tail -= head;
            head = 0;
        }
        items[tail]=item;
        tail +=1;
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public Object dequeue(){
        // 表示空了
        if(tail == head){
            return null;
        }
        Object re = items[head];
        head += 1;
        return re;
    }

    public static void main(String[] args) {

//        ArrayQueue<String> test = new ArrayQueue<>(3);
//        test.enqueue("a");
//        test.enqueue("b");
//        test.enqueue("c");
//        boolean isOk = test.enqueue("d");
//        System.out.println(isOk);
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        System.out.println(test.dequeue());
//        isOk = test.enqueue("d");
//        System.out.println(isOk);

        ArrayQueue test = new ArrayQueue(3);
        test.enqueue2("a");
        test.enqueue2("b");
        test.enqueue2("c");
        boolean isOk = test.enqueue2("d");
        System.out.println(isOk);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        isOk = test.enqueue2("d");
        System.out.println(isOk);

    }

}


