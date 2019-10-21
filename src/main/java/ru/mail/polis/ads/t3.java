package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import java.util.StringTokenizer;

public class t3 {
    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
    public static void main(final String[] arg) {
        FastScanner in = new FastScanner(System.in);
        int n=in.nextInt();

        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        int counter=0;
        int max;
        int index=0;
        boolean b=true;
        for (int i = 0; i <n ; i++) {
            max=arr[0];
            b=true;
            for (int j = 0; j <n-i-1 ; j++) {
                if(arr[j]>arr[j+1]) {
                    max=arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=max;
                    counter++;
                    b=false;
                }
            }
            if(b)
                i=n;
        }
        System.out.println(counter);



    }

}
