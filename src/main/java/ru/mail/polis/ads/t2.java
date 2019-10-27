package ru.mail.polis.ads;
import java.io.*;

import java.util.StringTokenizer;


public class t2 {
    static class BinaryHeap {

        private int[] elements;

        public BinaryHeap( int elem) {
            elements=new int[1];
            elements[0]=elem;
        }

        public void add(int element) {
            int[] newElements = new int[elements.length + 1];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            newElements[newElements.length - 1] = element;
            elements = newElements;

            siftUp(elements.length - 1);
        }

        public int extractMax() {


            int result = elements[0];
            elements[0] = elements[elements.length - 1];
            deleteLast();

            if (elements.length>1) {
                siftDown(0);
            }

            return result;
        }

        public boolean isEmpty() {
            return elements.length == 0;
        }

        private void deleteLast() {
            if (elements.length > 1) {
                int[] newElements = new int[elements.length - 1];
                System.arraycopy(elements, 0, newElements, 0, elements.length - 1);
                elements = newElements;
            } else {
                elements = new int[0];
            }
        }

        private void siftDown(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            int largest = i;
            if (left < elements.length && elements[left] > elements[i]) {
                largest = left;
            }
            if (right < elements.length && elements[right] > elements[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(i, largest);
                siftDown(largest);
            }
        }

        private void siftUp(int i) {
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (elements[i] < elements[parent])
                    return;
                swap(i, parent);
                i = parent;
            }
        }




        private void swap(int index1, int index2) {
            int temp = elements[index1];
            elements[index1] = elements[index2];
            elements[index2] = temp;
        }

        public int[] getElements() {
            int[] elementsCopy = new int[elements.length];
            System.arraycopy(elements, 0, elementsCopy, 0, elements.length);
            return elementsCopy;
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

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n=sc.nextInt();
        int k;
        k=sc.nextInt();
        k=sc.nextInt();
        BinaryHeap bh=new  BinaryHeap(k);
        for (int i = 0; i <n-1 ; i++) {
            k=sc.nextInt();
            if(k==0)
            {
                k=sc.nextInt();
                bh.add(k);
            }else
                System.out.println(bh.extractMax());
        }

    }
}
