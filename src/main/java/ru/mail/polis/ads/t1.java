package ru.mail.polis.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public final class t1 {


    static double f(double x)
    {
        return Math.pow(x,2)+Math.sqrt(x);
    }
    private static boolean solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        long a []= new long[n+1];
        for (int i = 1; i < n+1; i++) {
            a[i]=Long.parseLong(in.next());
        }
        for (int i = 1; i <n+1 ; i++) {
            if(2*i<=n)
                if(a[2*i]<a[i])
                    return false;
            if(2*i+1<=n)
                if(a[2*i+1]<a[i])
                    return false;
        }
        return true;
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
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            if(solve(in, out))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
