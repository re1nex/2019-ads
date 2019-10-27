package ru.mail.polis.ads;
import java.io.*;
import java.util.StringTokenizer;

public class t7 {
  

    private static long dist(long[] arr, int k) {
        long l = 0;
        long r = arr[arr.length - 1] - arr[0];
        long mid;
        int count;
        int i;
        if (k == 2) {
            return r;
        }
        while (l != r) {
            count = 1;
            mid = l + (r - l) / 2;
            i = 0;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > mid) {
                    i = j;
                    count++;
                }
            }
            if (count < k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        out.println(dist(arr, k));
    }
}
