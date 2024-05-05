package com.data.structure;

import java.lang.reflect.Array;

public class MaxValueRecusrion {


    public static void main(String ...args){
        int[] a={20,-2,-40,5,-1,6,5,12,10,14,4};
        int max=0;
       // System.out.println(findMaxValue(a,0));
        //printSubString("abc","");
  //     System.out.println(findElement(a,6,a.length-1));
      // printAsciSubStringCombo("abc","");
      a= sortArray(a,0,a.length-1);
      System.out.println(a);
    }
    
    public static int findMaxValue(int[] a,int index){
        if(index==a.length-1)
        return a[index];
        int result=findMaxValue(a,index+1);
        return Math.max(a[index],result);
    }

    public static void printSubString(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch =str.charAt(0);
        String partialString=str.substring(1);
        printSubString(partialString,ans+ch);
        printSubString(partialString,ans);


    }

    public static void printAsciSubStringCombo(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        char ch =str.charAt(0);
        int ascii=(int)ch;
        String partialString=str.substring(1);
        printAsciSubStringCombo(partialString,ans+ch);
        printAsciSubStringCombo(partialString,ans+ascii);
        printAsciSubStringCombo(partialString,ans);
    }


    public static boolean findElement(int []arr,int element,int index){
        if(element==arr[index]){
            return true;
        }else {
            if (index >= 1) {
                index = index - 1;
               return findElement(arr, element, index);
            }
        }
         return false;
    }

    public static int[] sortArray(int[] a,int left,int right){
        if(left <right) {
            System.out.println(left);
            swap(a, 0, right);
            left++;
            sortArray(a, left , right);
        }

      return a;
    }

    public static void swap(int[] a,int left,int right) {
        int temp;
        if (left <right){
            if (a[left] > a[left + 1]) {
                temp = a[left];
                a[left] = a[left + 1];
                a[left + 1] = temp;

            }
            left++;
            swap(a,left,right);
        }
    }
}
