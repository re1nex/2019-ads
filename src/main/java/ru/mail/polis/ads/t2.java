package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class t2 {
    
    private static void solve(FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        ArrayList<Integer>[] bucket= new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bucket[arr[i] % 10].add(arr[i]);
        }
        for (ArrayList<Integer> i :
                bucket) {
            if(!i.isEmpty()) {
                Collections.sort(i);
            }
        }
        for (ArrayList<Integer> i :
                bucket) {
            if(!i.isEmpty()){
                for (Integer j :
                        i) {
                    out.print(j);
                    out.print(' ');
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

    public static void main(final String[] arg) {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        solve(in, out);

    }
}
