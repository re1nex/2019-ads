package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class t3 {

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int a []= new int[n];
        int d []= new int[n];
        int  max =0;
        int ans=1;
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }
        d[0]=1;
        for (int i = 0; i <n ; i++) {
            max =0;
            for (int j = 0; j < i; j++) {
                if(a[j]!=0)
                    if(a[i]%a[j]==0&& d[j]>max)
                        max = d[j];
            }
            d[i]=max+1;
            if (d[i]>ans)
                ans=d[i];
        }
        System.out.println(ans);
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
            solve(in, out);
        }
    }
}
