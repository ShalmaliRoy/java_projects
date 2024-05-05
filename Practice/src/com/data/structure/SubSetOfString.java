package com.data.structure;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class SubSetOfString {
    public static void main(String ...args) {
        String str = "abcd";
        char[] charStr = str.toCharArray();
        char temp =charStr[charStr.length - 1];
        char tempStore=0;
        List<Character> characterList=new ArrayList<>();
        for(int j=0;j<4;j++) {
            characterList.add(charStr[charStr.length - 1]);
            for (int i = 0; i < charStr.length - 1; i++) {
                characterList.add(charStr[i]);
            }
            charStr=characterList.toString().toCharArray();
            String str1=characterList.toString().replaceAll(",", "");
            charStr = str1.substring(1, str1.length()-1).replaceAll(" ", "").toCharArray();
            System.out.println(characterList);
            characterList=new ArrayList<>();
        }
    }

}
