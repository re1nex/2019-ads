package ru.mail.polis.ads;

import java.util.Scanner;

public class t2 {
    static void solve(){
        Scanner reader = new Scanner(System.in);

        int n  = reader.nextInt();
        int[] arr=new int[n];
        int[] res =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=reader.nextInt();
        }
        res[0]=arr[0];
        int step = reader.nextInt();
        int max=0;
        int result;
        for (int i = 0; i < n; i++)
        {
            max=0;
            if(i>=step) {
                for (int j = i - step; j < i; j++) {
                    if(res[j]>max)
                        max=res[j];

                }
                res[i]=max+arr[i];
            }
            else{
                for (int j = 0; j <i ; j++) {
                    if(res[j]>max)
                        max=res[j];

                }
                res[i]=max+arr[i];
            }
        }
        max=0;
        for(int i=n-step;i<n;i++) {
            if (max < res[i])
                max = res[i];
        }

        System.out.println(max);

    }
}
