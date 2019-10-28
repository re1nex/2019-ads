package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class t1 {

    static double f(double x,double c)
    {
        return x*x+Math.sqrt(x)-c;
    }
    private static void solve(final FastScanner in, final PrintWriter out) {
        double eps =1;
        double c=Double.parseDouble(in.next());
        double l=0;
        double r = c;
        double x;

        eps = Math.abs(l-r);

        do{
            x=(l+r)/2;
            if(f(l,c)*f(x,c)<0)
            {
                r=x;
            }else
            {
                l=x;
            }
            eps = Math.abs(f(x,c));

        }while (eps>0.0000001d);
        out.println(String.format("%.6f",x));
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
