package org.example.hashmap;

import java.util.ArrayList;

public class Maps <K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int size;
    int numBuckets;
    public Maps(){
        numBuckets=5;
        buckets=new ArrayList<>();
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }
    }

    // search
    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(bucketIndex);
        while(head != null){
            if( head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }

        return null;
    }


    // removing element from the Map ......
    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                size--;
                if(prev == null){
                    buckets.set(bucketIndex, head.next);
                }else{
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head.next = head;
        }
        return null;
    }

    public int size(){
        return this.size;
    }




    // hash function implementation
    private int getBucketIndex(K key){
        int hashCode= key.hashCode();
        return hashCode % numBuckets; // compression
    }

    // re-hash

    public double loadFactor(){
        return (1.0 * size)/numBuckets;
    }
    private void rehash(){
        System.out.println("Rehashing : buckets "+ numBuckets+" size : "+size);
        ArrayList<MapNode<K, V>> temp=buckets;
        // creation part of double size ArrayList
        buckets = new ArrayList<>();
        for (int i=0; i<2*numBuckets; i++){
            buckets.add(null);
        }
        size=0;
        numBuckets *=2;
        for(int i=0;i< temp.size();i++){
            MapNode<K, V> head =  temp.get(i);
            while(head !=null){
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
     }

    // insert function....
    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head != null){ // iterate over the link-list
            if (head.key.equals(key)){
                head.value = value; // for updating the value
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newElementNode = new MapNode<>(key, value);
        newElementNode.next=head;
        buckets.set(bucketIndex, newElementNode); // arrayList pointed to the newElementNode
        size++;
        double loadFactor = (1.0*size)/numBuckets;
        if (loadFactor > 0.7){
            // re-hashing
            rehash();
        }

    }

}
