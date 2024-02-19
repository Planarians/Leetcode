package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-19 01:34
 **/
public class NumberOfEquivalentDominoPairs1128E {
    public int numEquivDominoPairs1(int[][] dominoes) {
        int res = 0;
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(Math.min(dominoes[i][1], dominoes[i][0]));
            list.add(Math.max(dominoes[i][0], dominoes[i][1]));
            res += map.getOrDefault(list, 0);
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        return res;
    }
        public int numEquivDominoPairs(int[][] dominoes) {
            int res=0;
            HashMap<ArrayList<Integer>,Integer> map=new HashMap<>();
            HashMap<ArrayList<Integer>,Integer> pairs=new HashMap<>();
            for(int i=0;i<dominoes.length;i++){
                ArrayList<Integer> list=new ArrayList<>();
                if(dominoes[i][0]>=dominoes[i][1]){
                    list.add(dominoes[i][1]);
                    list.add(dominoes[i][0]);
                }else{
                    list.add(dominoes[i][0]);
                    list.add(dominoes[i][1]);
                }
                if(map.containsKey(list)){
                    map.put(list,map.get(list)+1);
                    if(map.get(list)==2){
                        pairs.put(list,1);
                        res+=1;
                    }
                    if(map.get(list)>2){
                        int k=map.get(list);
                        int count=pairs.get(list)*k/(k-2);
                        res-=pairs.get(list);
                        res+=count;
                        pairs.put(list,count);
                    }
                }else{
                    map.put(list,1);

                }
            }
            return res;

    }



/**
 10^4=ten raised to the power of four /ten to the power of four

 "4x10^4" can be read as "four times ten to the power of four"
 or "four multiplied by ten to the power of four." It can also be expressed as "forty thousand."

 20000 pairs

 n!/2(n-2)!

 1-0
 2=1  1/1  0x2/0
 3=3  3/1 =3  3   1x3/1
 4=6 4x3/1x2=6  2x3=6
 5=10 5x4x3/1x2x3 2x5 =10 = 6 x5/3  a[i-1]xi/i-2
 6=6x5x4x3/1x2x3x4  3x5=15 = 10 x6/4

 3x5/5 x7

 a[i]=a[i-1]xi/(i-2)

 1 3 6 10 15
 +(i-1)
 c32
 */
}
