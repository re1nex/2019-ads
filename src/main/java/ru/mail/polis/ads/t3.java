package ru.mail.polis.ads;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Index {
            int in;
            public Index(int a) {
                in = a;
            }
        }

        public class t3
        {
            public static void get_levels(char[] Expr, Index index, int depth, String[] Answer) {
                Answer[depth] += Expr[index.in];
                index.in--;
                if (Character.isUpperCase(Expr[index.in + 1])) {
                    get_levels(Expr, index, depth + 1, Answer);
                    get_levels(Expr, index, depth + 1, Answer);
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
             static void solve () throws java.lang.Exception
            {
                FastScanner in = new FastScanner(System.in);
                int n = in.nextInt();
                String str ;

                for (int k = 0; k < n; k++) {
                    str = in.next();
                    char[] Expr = str.toCharArray();
                    String[] Answer = new String[Expr.length];
                    Arrays.fill(Answer, "");
                    Index index = new Index(Expr.length - 1);
                    get_levels(Expr, index, 0, Answer);
                    for (int j = Expr.length - 1; j >= 0; j--)
                        System.out.print(Answer[j]);
                    System.out.println();
                }
            }
        }
