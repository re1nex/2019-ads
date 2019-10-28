package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class t2 {

    
    private static void solve(final Fastinanner in, final PrintWriter out) {
        
        long w=in.nextInt();
        long h=in.nextInt();
        long  n=in.nextInt();
        long l = Math.max(w,h);
        long r= n*l;
        long m;
        long v;
        while (l<r){
            m=(l+r)/2;
            v = (m/w)*(m/h);
            if (v>=n){
                r=m;
            } else {
                l=m+1;
            }
        }
        System.out.println(r);
    }

    private static class Fastinanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        Fastinanner(final InputStream in) {
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
        final Fastinanner in = new Fastinanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}
