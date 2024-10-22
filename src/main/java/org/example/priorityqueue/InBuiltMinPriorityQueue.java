package org.example.priorityqueue;

import java.util.PriorityQueue;

public class InBuiltMinPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(10);
        pq.add(2);
        pq.add(3);
        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.size());
        System.out.println(pq.peek());
    }
}
