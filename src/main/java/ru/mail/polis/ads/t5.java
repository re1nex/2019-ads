package ru.mail.polis.ads;

import java.io.*;
import java.util.StringTokenizer;

public class t5 {
    static void swap(int[]a, int i, int j)
    {
        int s = a[i];
        a[i] = a[j];
        a[j] = s;
    }
    static boolean NextSet(int[] a, int n)
    {
        int j = n - 2;
        while (j != -1 && a[j] >= a[j + 1]) j--;
        if (j == -1)
            return false;
        int k = n - 1;
        while (a[j] >= a[k]) k--;
        swap(a, j, k);
        int l = j + 1, r = n - 1;
        while (l<r)
            swap(a, l++, r--);
        return true;
    }


    private static void solve(final FastScnanner in, final PrintWriter out) {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < n; i++)
            out.print( arr[i]+" ");
        out.println();
        while (NextSet(arr, n))
        {
            for (int i = 0; i < n; i++)
               out.print( arr[i]+" ");
           out.println();
        }

    }
    private static class FastScnanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScnanner(final InputStream in) {
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
        final FastScnanner in = new FastScnanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
