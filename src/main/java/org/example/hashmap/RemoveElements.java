package org.example.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RemoveElements {
    public static void main(String[] args) {
        int arr[]={1,2,2,1,11,33,444};
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Boolean> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])) continue;
            else{
                ans.add(arr[i]);
                mp.put(arr[i],true);
            }
        }

        System.out.println("Final ans..........");
        System.out.println(ans);
    }


}
