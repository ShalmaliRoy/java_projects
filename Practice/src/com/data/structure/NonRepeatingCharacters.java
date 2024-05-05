package com.data.structure;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class NonRepeatingCharacters {

    public static void main(String ...args){
        String str="abaccd";
        char[] newStr=str.toCharArray();
        Queue<String> queue=new LinkedBlockingQueue<>();
for( int i=0 ;i< newStr.length;i++){
    String checkStr=String.valueOf(newStr[i]);
    if(queue.isEmpty())
      queue.add(checkStr);
    else {
        if(!(queue.contains(checkStr))){
           queue.add(checkStr);

        }
        else
            queue.remove(checkStr);
    }
}
System.out.println(queue.peek());
    }
}
