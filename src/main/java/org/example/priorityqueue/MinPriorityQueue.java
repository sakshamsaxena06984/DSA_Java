package org.example.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MinPriorityQueue {
    private ArrayList<Integer> heap;

    public MinPriorityQueue(){
        this.heap=new ArrayList<Integer>();
    }

    // isEmpty()
    public boolean isEmpty(){
        return this.heap.size()==0;
    }

    // getSze()
    public int getSize(){
        return this.heap.size();
    }

    // getMin()
    public int getMin() throws Exception {
        if(this.isEmpty()){
            throw new Exception();
        }
        return this.heap.get(0);
    }

    // insert()
    public void insert(int element){
        heap.add(element);
        // up-heapify
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;
        while (childIndex>0){
            if(heap.get(childIndex)<heap.get(parentIndex)){
                // swapping
                int temp=heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }
            else{
                return;
            }
        }
    }

    // removeMin()
    int removeMin() throws Exception{
        if( isEmpty() ){
            throw new Exception();
        }
        int temp=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        // down-heapify
        int index=0;
        int minIndex=index;
        int leftIndex=1;
        int rightIndex=2;
        while(leftIndex<heap.size()){
            if(heap.get(leftIndex)<heap.get(minIndex)){
                minIndex=leftIndex;
            }
            if(rightIndex<heap.size() && heap.get(rightIndex)<heap.get(minIndex)){
                minIndex=rightIndex;
            }
            if (minIndex==index) break;
            else{
                // swapping
                int temp1=heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex,temp1);
                index=minIndex;
                leftIndex=(2*index+1);
                rightIndex=(2*index+2);
            }
        }

        return temp;
    }

    public void printing(){
        for(int i=0;i<heap.size();i++){
            System.out.print(heap.get(i)+ " : ");
            if((2*i+1) < heap.size()){
                System.out.print(" L "+ heap.get(2*i+1));
            }
            else{
                System.out.print(" L "+ "null");
            }
            if((2*i+2) < heap.size()){
                System.out.print(" R "+ heap.get(2*i+2));
            }
            else{
                System.out.print(" R "+ "null");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
         MinPriorityQueue obj=new MinPriorityQueue();
        int arr[]={2,4,5,62,6};
        Arrays.stream(arr).forEach(e->{
            obj.insert(e);
        });

        obj.printing();
        System.out.println("removed element is : "+obj.removeMin());
        obj.printing();
    }

}
