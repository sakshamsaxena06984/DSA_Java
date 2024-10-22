package org.example.hashmap;

import java.util.HashMap;
import java.util.Set;

public class InbuiltHashTableMap {
    public static void main(String[] args) {
        HashMap<String,Integer> mp=new HashMap<>();
        mp.put("abc",1);
        mp.put("abc1",1);
        mp.put("abc2",1);
        System.out.println(mp.containsKey("abc"));
        System.out.println(mp.containsKey("abkk"));
        if(mp.containsKey("abc")){
            System.out.println("Present !");
        }
        mp.remove("abc");
        Set<String> st=mp.keySet();
        for(String s: st){
            System.out.println(s);
        }
    }
}
