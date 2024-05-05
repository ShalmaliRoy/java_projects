package com.data.structure;

import java.util.*;
import java.util.stream.Collectors;

public class FewestCoinTarget {

    public static void main(String ...args) {
        Integer[] array = {55,8,5,40,4,2};
        Arrays.sort(array,Collections.reverseOrder());
        int target = 60;
        List<Integer> list= Arrays.stream(array).collect(Collectors.toList());
        List<Integer> sumList=new ArrayList<>();
        List<Integer> childList=new ArrayList<>();
        Map<Integer,List> map=new TreeMap<>();

        for(int i=0;i< list.size();i++) {
            int sum=0;

            int item= list.get(i);
            if(item==target) {
                sumList.add(item);
                map.put(1, sumList);
            }
            if (item < target) {
                int rem = target / array[i];
                 sum += rem * array[i];
                for (int j = 0; j < rem; j++) {
                    sumList.add(list.get(i));
                }


                int sum1=list.get(i);
                boolean isChecked=false;
                boolean isChildChecked=false;
                childList.add(list.get(i));
                if(sum==target) {
                    map.put(sumList.size(), sumList);
                    isChecked=true;
                }
                for (int j = i + 1; j < list.size(); j++) {
                     if(sum1<target){
                         sum1=sum1+list.get(j);
                         childList.add(list.get(j));
                     }
                     if(sum1==target&& !isChildChecked){
                         map.put(childList.size(),childList);
                         childList=new ArrayList<>();
                         isChildChecked=true;
                     }
                    if(sum1>target){
                        sum1-=list.get(j);
                        if(childList.size()>1)
                        childList.remove(childList.size()-1);

                    }
                     if(sum<target){
                         sum=sum+list.get(j);
                     }
                     if(sum==target && !isChecked) {
                         sumList.add(list.get(j));
                         map.put(sumList.size(),sumList);
                         isChecked=true;
                     }
                     if(sum>target)
                         sum-=list.get(j);
                }
            }
            System.out.println(map);

            sumList=new ArrayList<>();
            childList=new ArrayList<>();

        }
        System.out.println(map);

    }

    private static void findFewestCoins(int[] array, List<Integer> sumList, int target, int sum, int i){

        if(!sumList.isEmpty() && sum<=target) {
            System.out.println(sumList);
        }
        if(i+1<= array.length-1) {
            findFewestCoins(array, new ArrayList<>(), target, sum, i + 1);
        }

           if(sum<=target && array[i]<=target) {
                   int rem = target / array[i];
                   sum += rem * array[i];
                   for (int j = 0; j < rem; j++) {
                       sumList.add(array[i]);
                   }



           }

        if(i+1<= array.length-1)
           findFewestCoins(array,sumList,target,sum,i+1);
           if(!sumList.isEmpty()) {
               sumList.remove(sumList.size() - 1);
           }

    }
}
