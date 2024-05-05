package com.data.structure;

public class CountBS {

    public static void main(String ...args){
        solve(0,5);
    }

    private static int solve(int prev,int n){
        if(n==0)
            return 0;
        if(n==1){
            if(prev==0)
                return 2;
            if(prev==1)
                return 1;
        }
        if(prev==0)
            return solve(0,n-1)+solve(1,n-1);
        else
           return solve(0,n-1);
    }

    private static int solveBU(int n){
        int[]a= new int[n+1];
        int[]b=new int[n+1];
        a[0]=0;
        b[0]=0;
        a[1]=b[1]=1;
        for(int i=2;i<a.length;i++){
            a[i]=a[i-1]+b[i-1];
            b[i]=a[i-1];
       }
        return a[n-1]+b[n-1];
    }
}
