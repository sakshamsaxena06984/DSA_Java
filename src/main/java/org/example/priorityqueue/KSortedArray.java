package org.example.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int arr[]={2,4,1,9,6,8};
        Arrays.stream(arr).forEach(e->{
            System.out.print(e+" ");
        });
        System.out.println();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        int k=3;
        for( ;i<k; i++){
            pq.add(arr[i]);
        }
        for( ;i < arr.length ; i++){
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
        }

        for(int j=arr.length-k; j<arr.length; j++){
            arr[j]=pq.remove();
        }
        System.out.println("after sorting ....");
        Arrays.stream(arr).forEach(e->{
            System.out.print(e+" ");
        });
        System.out.println();
    }
}
