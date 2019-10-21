package ru.mail.polis.ads;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class t5 {
    private static Elem[] arr;
    private static Elem[] sortSub;


    private static void solve(final BufferedReader in, final PrintWriter out) throws IOException {
       int numElem = Integer.parseInt(in.readLine());
        arr = new Elem[numElem];
        sortSub = new Elem[numElem];

        readElems(in, numElem);
        sort(0, arr.length-1);
        printElems(out);

        out.close();
        in.close();
    }

    private static class Elem {
        int mainNumber;
        int subNumber;

        Elem() {
        }

        Elem setNumber(int mainNumber) {
            this.mainNumber = mainNumber;
            return this;
        }

        Elem setSubNumber(int subNumber) {
            this.subNumber = subNumber;
            return this;
        }
    }


    private static void readElems(final BufferedReader in, final int numElem) throws IOException{

        for (int i = 0; i < numElem; i++) {
            String[] ElemInfo = in.readLine().split(" ");
            arr[i] = new Elem()
                    .setNumber(Integer.parseInt(ElemInfo[0]))
                    .setSubNumber(Integer.parseInt(ElemInfo[1]));
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
                System.arraycopy(arr, rPoint, sortSub, sortArrPoint, r-rPoint+1);
                rPoint = r+1;
            } else if (rPoint == r+1) {
                System.arraycopy(arr, lPoint, sortSub, sortArrPoint, middle-lPoint+1);
                lPoint = middle+1;
            } else if (arr[rPoint].mainNumber < arr[lPoint].mainNumber) {
                sortSub[sortArrPoint] = arr[rPoint];
                sortArrPoint++;
                rPoint++;
            } else {
                sortSub[sortArrPoint] = arr[lPoint];
                sortArrPoint++;
                lPoint++;
            }
        }


        System.arraycopy(sortSub, 0, arr, l, r-l+1);
    }


    private static void printElems(final PrintWriter out) {
        for (Elem Elem : arr) {
            out.println(
                    Elem.mainNumber + " " + Elem.subNumber
            );
        }
    }


    public static void main(final String[] arg) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out =  new PrintWriter(new BufferedOutputStream(System.out));

        try {
            solve(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
