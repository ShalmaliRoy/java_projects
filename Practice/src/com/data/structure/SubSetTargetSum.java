package com.data.structure;

import java.util.*;

public class SubSetTargetSum {
    public static void main(String... args) {
        Deque<Integer> str = new ArrayDeque<>();
        int count = 0;
        int[] array = {10, 8,2,20, 30, 40, 50, 55, 60,5};
        int target = 60;
        //  ArrayDeque<Integer> stack=new ArrayDeque();
        findSubSets(array,new ArrayList<>(),target,0,0);
    }

    private static void findSubSets(int[] arr,List<Integer> set,int target,int sum,int j) {
        if (sum == target) {
            System.out.println(set + " ");
            sum = 0;

        }
        if(j + 1 <= arr.length - 1)
        findSubSets(arr, set, target, sum, j + 1);


        if (sum <= target && arr[j]<target) {
            sum += arr[j];
            set.add(arr[j]);


            if (j + 1 <= arr.length - 1)
                findSubSets(arr, set, target, sum, j + 1);
            if (!set.isEmpty())
                set.remove(set.size() - 1);

        }
    }

}
