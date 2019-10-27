package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class t6 {
    private static int[] arr;



    private static boolean findElement(final int element) {
        int l = 0;
        int r = arr.length - 1;
        int median = l + (r-l)/2;

        while (l != r && element != arr[median]) {
            if (element > arr[median]) {
                l = (median == l) ? r : median;
            } else {
                r = median;
            }

            median = l + (r-l)/2;
        }

        return element == arr[median];
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
            int n = in.nextInt();
            int num = in.nextInt();

            arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }

            for (int i = 0; i < num; i++) {
                if(findElement(in.nextInt()))
                    out.println("YES");
                else out.println("NO");

            }
    }
}
