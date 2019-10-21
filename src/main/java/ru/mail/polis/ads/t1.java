package ru.mail.polis.ads;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;

public class t1 {
    private static int[] arr;
    private static int[] subarr;

    
        private static void solve(final BufferedReader in, final PrintWriter out) throws IOException{
            final int numElem = Integer.parseInt(in.readLine());
            arr = new int[numElem];
            subarr = new int[numElem];

            read(in, numElem);
            sort(0, arr.length-1);
            printArray(out, arr);

            in.close();
            out.close();
        }


        private static void read(final BufferedReader in, final int numElem) throws IOException{
            final String[] elem = in.readLine().split(" ");

            for (int i = 0; i < numElem; i++) {
                arr[i] = Integer.parseInt(elem[i]);
            }
        }



        private static void sort(final int l, final int r) {

            if(l == r) {
                return;
            }

            int middle = l+(r-l)/2;
            sort(l, middle);
            sort(middle+1, r);

            int lPoint = l, rPoint = middle+1, sortArrPoint = 0;
            while (lPoint <= middle || rPoint <= r ) {
                if (lPoint == middle+1) {
                    System.arraycopy(arr, rPoint, subarr, sortArrPoint, r-rPoint+1);
                    rPoint = r+1;
                } else if (rPoint == r+1) {
                    System.arraycopy(arr, lPoint, subarr, sortArrPoint, middle-lPoint+1);
                    lPoint = middle+1;
                } else if (arr[lPoint] < arr[rPoint]) {
                    subarr[sortArrPoint] = arr[lPoint];
                    sortArrPoint++;
                    lPoint++;
                } else {
                    subarr[sortArrPoint] = arr[rPoint];
                    sortArrPoint++;
                    rPoint++;
                }
            }


            System.arraycopy(subarr, 0, arr, l, r-l+1);
        }


        private static void printArray(final PrintWriter out, final int[] elem) {
            StringBuilder result = new StringBuilder();

            for (Integer element: elem) {
                result.append(element.toString());
                result.append(" ");
            }

            out.println(result.toString().trim());
        }


        public static void main(final String[] arg) {
            final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out =  new PrintWriter(new BufferedOutputStream(System.out));

            try {
                solve(in, out);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
}
