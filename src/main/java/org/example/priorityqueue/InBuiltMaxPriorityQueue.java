package org.example.priorityqueue;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MaxPQComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){  // implementing MaxPriorityQueue Logic
            return 1;
        }else if (o1 > o2){
            return -1;
        }
        return 0;
    }
}

public class InBuiltMaxPriorityQueue {
    public static void main(String[] args) {
        MaxPQComparator maxPQComparator = new MaxPQComparator();
        PriorityQueue<Integer> pq=new PriorityQueue<>(maxPQComparator);
        pq.add(2);
        pq.add(0);
        pq.add(1);
        pq.add(111);
        pq.add(11);
        System.out.println(pq.size());
        System.out.println(pq.peek());

        /**
         * In Java, MaxComparator already exists in Collections class
         */
        PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq1.add(22);
        pq1.add(2);
        pq1.add(1);
        pq1.add(0);
        pq1.add(33);
        System.out.println(pq1.size());
        System.out.println(pq1.peek());
        /**
         * PriorityQueue of String type
         */
        PriorityQueue<String> pq2=new PriorityQueue<>(Collections.reverseOrder());
        String str[]={"aa","msn","mks","ikm"};
        Arrays.stream(str).forEach(e->{
            pq2.add(e);
        });
        System.out.println("size is : "+ pq2.size());

        while (!pq2.isEmpty()){
            System.out.println(pq2.remove());
        }

        Arrays.sort(str, Collections.reverseOrder());
        System.out.println();
        Arrays.stream(str).forEach(e->{
            System.out.print(e+" ");
        });
        Arrays.sort(str);
        System.out.println();
        Arrays.stream(str).forEach(e->{
            System.out.print(e+" ");
        });

    }
}
