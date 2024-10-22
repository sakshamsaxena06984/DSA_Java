package org.example.hashmap;

public class UseMap {
    public static void main(String[] args) {
        Maps<String, Integer> map = new Maps<>();
        for(int i=0;i<20;i++){
            map.insert("abc"+i, 1+i);
            System.out.println("i= "+i + " if = "+map.loadFactor());
        }
        /**
         * i= 0 if = 0.2
         * i= 1 if = 0.4
         * i= 2 if = 0.6
         * Rehashing : buckets 5 size : 4
         * i= 3 if = 0.4
         * i= 4 if = 0.5
         * i= 5 if = 0.6
         * i= 6 if = 0.7
         * Rehashing : buckets 10 size : 8
         * i= 7 if = 0.4
         * i= 8 if = 0.45
         * i= 9 if = 0.5
         * i= 10 if = 0.55
         * i= 11 if = 0.6
         * i= 12 if = 0.65
         * i= 13 if = 0.7
         * Rehashing : buckets 20 size : 15
         * i= 14 if = 0.375
         * i= 15 if = 0.4
         * i= 16 if = 0.425
         * i= 17 if = 0.45
         * i= 18 if = 0.475
         * i= 19 if = 0.5
         */

        for(int i=0;i<20;i++){
            System.out.println("abc "+ i + " : "+ map.getValue("abc"+i));
        }
        map.removeKey("abc1");
        for(int i=0;i<20;i++){
            System.out.println("abc "+ i + " : "+ map.getValue("abc"+i));
        }
        System.out.println(map.getValue("abc33"));
    }
}
