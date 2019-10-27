package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class t4 {
    private static int[] arr;
    private static int[] sortArr;
    private static int res;



    private static void sort(final int l, final int r) {

        if(l == r) {
            return;
        }

        int median = (l+r)/2;
        sort(l, median);
        sort(median+1, r);

        int lp = l;
        int rp = median+1;
        int sortp = 0;
        while (lp <= median || rp <= r ) {
            if (lp == median+1) {
                System.arraycopy(arr, rp, sortArr, sortp, r-rp+1);
                rp = r+1;
            } else if (rp == r+1) {
                System.arraycopy(arr, lp, sortArr, sortp, median-lp+1);
                lp = median+1;
            } else if (arr[rp] < arr[lp]) {
                sortArr[sortp] = arr[rp];
                sortp++;
                rp++;
                res += (median - lp +1);
            } else {
                sortArr[sortp] = arr[lp];
                sortp++;
                lp++;
            }
        }


        System.arraycopy(sortArr, 0, arr, l, r-l+1);
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
        PrintWriter out = new PrintWriter(System.out);
        int numberOfElements = in.nextInt();
        arr = new int[numberOfElements];
        sortArr = new int[numberOfElements];
        res = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

        sort(0, arr.length-1);
        out.println(res);
        
    }
}
