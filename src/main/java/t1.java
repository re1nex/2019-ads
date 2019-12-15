import java.io.*;
import java.util.*;

public class t1 {
    private final static char BLACK = 'b';
    private final static char WHITE = 'w';
    private final static char GREY = 'g';

    private static List<Integer>[] array;
    private static char[] colors;
    private static Stack<Integer> answer;
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
    private static void topologicalSort(int current) {
        if (colors[current] == BLACK) {
            return;
        }
        if (colors[current] == GREY) {
            System.out.println(-1);
            System.exit(0);
            return;
        }

        colors[current] = GREY;

        for (Integer integer: array[current]) {
            topologicalSort(integer);
        }

        answer.push(current);
        colors[current] = BLACK;
    }

    public static void main(String[] args) {
        final FastScanner in = new FastScanner(System.in);
       PrintWriter out = new PrintWriter(System.out);

        final int n = in.nextInt();
        array = new LinkedList[n + 1];
        colors = new char[n + 1];
        for (int i = 0; i <= n; ++i) {
            array[i] = new LinkedList<>();
            colors[i] = WHITE;
        }

        final int m = in.nextInt();
        for (int i = 1; i <= m; ++i) {
            final int first = in.nextInt();
            final int second = in.nextInt();
            if (second > n || first > n) {
                out.println(-1);
                return;
            }
            array[first].add(second);
        }

        answer = new Stack<>();
        for (int i = 1; i <= n; ++i) {
            topologicalSort(i);
        }

        while (!answer.empty()) {
            System.out.print(answer.pop() + " ");
        }

    }
}
