package com.data.structure;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Pattern;

public class BooleanSearch {
    Map<String, String[]> map=new LinkedHashMap<>();
    String[] element=new String[10];
    String[] operator=new String[5];
    int[] temp=new int[10];
    public BooleanSearch(){
        this.map=addItem();
    }

    private Map addItem(){
    map.put("doc1", new String[]{"text1", "text2", "text3", "text4", "text5"});
   map.put("doc2", new String[]{"text1", "text3", "text8", "text9", "text10"});
    map.put("doc3", new String[]{"text2", "text3", "text7", "text8", "text10"});
    map.put("doc4", new String[]{"text5", "text7", "text3", "text4", "text99"});
   map.put("doc5", new String[]{"text10", "text1", "text5", "text3", "text8"});
   map.put("doc6", new String[]{"text9", "text1", "text5", "text3", "text8"});

        return map;
    }

    public void getAllCriteria(String searchString){
     String[] str=searchString.split(" ");
     int count=0;

     for(int i=0;i<str.length;i++){
         if(Pattern.matches("and",str[i]) && i< str.length){
             operator[i-1]="*";
         }
         else if(Pattern.matches("or",str[i] ) && i< str.length){
             operator[i-1]="+";
         }
         else{
             element[count]=str[i];
             temp[count]=0;
             count++;
         }
     }
        getAllDocumentsMatchingCriteria();
    }
    public Map getAllDocumentsMatchingCriteria(){
        Map<String,String[]> resultMap=new HashMap<>();

        map.forEach((key,value)-> {
            int count = operator[0].equals("*")?1 :0;;


            for (int i = 0; i < element.length; i++) {
                if(element[i]==null){
                    break;
                }
                for (int j = 0; j < value.length; j++) {
                    if (element[i].equals(value[j])) {
                        temp[i] = 1;
                        System.out.println("hello");
                        break;
                    }
                    else
                        temp[i]=0;

                }
            }
            for (int i = 0; i < element.length; i++) {
                if(element[i]==null){
                    break;
                }
                if (operator[0].equals("*")) {
                    count = count * temp[i];
                }if (operator[0].equals("+")) {
                    count+=  temp[i];
                }
            }
            if (count >= 1) {
                resultMap.put(key, value);
            }
        });
        return resultMap;
    }
    public static void main(String ...args){
    BooleanSearch booleanSearch=new BooleanSearch();
    String stringToSearch="text77 or text88 or text9";
    booleanSearch.getAllCriteria(stringToSearch);

    }
}
