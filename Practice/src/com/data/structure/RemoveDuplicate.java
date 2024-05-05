package com.data.structure;

public class RemoveDuplicate {

    public static void main(String ...args){
        String str="abbdca";
        System.out.println(removeElements(str));
    }

    public static String removeElements(String str){
        char[] c =str.toCharArray();
        char temp = 0;
        String str1="";
        int i=0;
        while(i<c.length-1){
            if(c[i]==c[i+1] || temp==c[i]) {
                temp=c[i+1];
                if(i>0&&temp!=str1.charAt(i-1)) {
                    str = str1 + str.substring(i + 2, str.length());
                }else {
                    str = str.substring(i + 2, str.length());
                }
                c=str.toCharArray();
                i=0;
            }
            else{
                 str1=str1+String.valueOf(c[i]);
                 i++;
            }
        }
        return str;
    }
}
