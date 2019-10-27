package ru.mail.polis.ads;
import java.io.*;
public class t3 {
    

    private static class Heap {
        private int[] data;
        private boolean min;
        private int size;

        Heap(int max, boolean min) {
            data = new int[max];
            size = 0;
            this.min = min;
        }

        void insert(int x) {
            size++;
            data[size - 1] = x;
            swim(size - 1);
        }

        int peek() {
            return data[0];
        }

        int extract() {
            int max = data[0];
            data[0] = data[size - 1];
            size--;
            sink(0);
            return max;
        }

        private void swim(int i) {
            while (min ? data[i] < data[(i - 1) / 2] : data[i] > data[(i - 1) / 2]) {
                swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        private void sink(int i) {
            int left;
            int right;
            int j;
            while (2 * i + 1 < size) {
                left = 2 * i + 1;
                right = 2 * i + 2;
                j = left;
                if (right <= size && min ? data[right] < data[left] : data[right] > data[left]) {
                    j = right;
                }
                if (min ? data[i] <= data[j] : data[i] >= data[j]) {
                    break;
                }
                swap(i, j);
                i = j;
            }
        }

        private void swap(int left, int right) {
            int t = data[left];
            data[left] = data[right];
            data[right] = t;
        }
    }

    public static void main(final String[] arg) {
        final InputStreamReader streamReader = new InputStreamReader(System.in);
        final BufferedReader in = new BufferedReader(streamReader);
        PrintWriter out = new PrintWriter(System.out);
        Heap max = new Heap(500001, false);
        Heap min = new Heap(500001, true);
        max.insert(Integer.MIN_VALUE);
        min.insert(Integer.MAX_VALUE);
        int median = -1;
        int Elem;
        while (true) {
            try {
                Elem = Integer.parseInt(in.readLine());
            } catch (Exception ex) {
                break;
            }
            if (median == -1) {
                if (Elem < max.peek()) {
                    median = max.extract();
                        max.insert(Elem);
                    } else if (Elem > min.peek()) {
                        median = min.extract();
                        min.insert(Elem);
                    } else {
                        median = Elem;
                    }
                } else {
                    if (Elem < median) {
                        min.insert(median);
                        max.insert(Elem);
                        median = -1;
                    } else {
                        max.insert(median);
                        min.insert(Elem);
                        median = -1;
                    }
                }
                out.println(median == -1 ? max.peek() + (min.peek() - max.peek()) / 2 : median);

        }
    }
}
