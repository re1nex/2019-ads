package ru.mail.polis.ads;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class t5 {
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

    public static void solve() {
        FastScanner reader = new FastScanner(System.in);
        int num=0;

        String buffer;

        ArrayList<Integer> que = new ArrayList<>() ;

        do{
            buffer=reader.next();
            switch (buffer) {
                case "push": {
                    num = Integer.parseInt(reader.next());
                    que.add(num);
                    System.out.println("ok");
                    break;
                }
                case "pop": {
                    if (que.size()==0) {
                        System.out.println("error");
                        break;
                    }
                    System.out.println(que.get(que.size()-1));
                    que.remove(que.size()-1);
                    break;
                }
                case "back": {
                    if (que.size()==0) {
                        System.out.println("error");
                        break;
                    }
                    System.out.println(que.get(que.size()-1));
                    break;
                }
                case "size": {
                    System.out.println(que.size());
                    break;
                }
                case "clear": {
                    que.clear();
                    System.out.println("ok");
                    break;
                }
                default:
                    break;
            }


        }
        while (!buffer.equals("exit"));

        System.out.println("bye");
    }
}
