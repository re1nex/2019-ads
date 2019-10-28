package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class t2 {
    static void sort(int []arr,int n)
    {
        int swap;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (arr[i] % 10 > arr[j] % 10) {
                    swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;

                } else if (arr[i] % 10 == arr[j] % 10) {
                    if (arr[i] > arr[j]) {
                        swap = arr[i];
                        arr[i] = arr[j];
                        arr[j] = swap;
                    }
                }
            }
        }

    }

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
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
         sort(arr,n);


        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
