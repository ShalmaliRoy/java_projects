package com.data.structure;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> data=new ArrayList<>();

    public void add(int item){
        this.data.add(item);
        if(data.size()>1)
        upheapify(this.data.size()-1);
    }

    private void upheapify(int ci){
        int pi=(ci-1)/2;
        if(this.data.get(pi) > this.data.get(ci) && pi!=ci) {
            swap(pi, ci);
            upheapify(pi);
        }
    }

    private void swap(int pi,int ci){
        int pdata=this.data.get(pi);
        int cdata=this.data.get(ci);
        this.data.set(ci,pdata);
        this.data.set(pi,cdata);
    }

    public int remove(int item){
        if(this.data.isEmpty()){
            throw new RuntimeException("No elements");
        }
        swap(0,this.data.size()-1);
        int rv=data.remove(this.data.size()-1);
        downheapify(0);
        return rv;
    }
    private void downheapify(int pa){
        int ch=2*(pa-1);
        if(this.data.get(ch) < this.data.get(pa))
            swap(ch,pa);
        downheapify(pa);
    }

    public static void main(String ...args){
        Heap heap=new Heap();
        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(40);
        heap.add(0);
        System.out.println("heap");
    }

}
