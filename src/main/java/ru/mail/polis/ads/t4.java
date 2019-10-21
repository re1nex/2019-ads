package ru.mail.polis.ads;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class t4 {
    private static BigInteger[] Elem;
    private static BigInteger[] smallElem;
    private static BigInteger[] bigElem;
    


    private static void solve(final BufferedReader in, final PrintWriter out) throws IOException {
        final int k = Integer.parseInt(in.readLine());
        final String[] ElemList = in.readLine().split(" ");

        InitArr(ElemList.length);

        convElem(ElemList);

        out.println( findOrderStatistic(Elem.length - k) );

        in.close();
        out.close();
    }


    private static void InitArr(final int size) {
        Elem = new BigInteger[size];
        smallElem = new BigInteger[size];
        bigElem = new BigInteger[size];
    }



    private static void convElem(final String[] ElemList) {
        for (int i = 0; i < ElemList.length; i++) {
            Elem[i] = new BigInteger(ElemList[i]);
        }
    }


    private static BigInteger findOrderStatistic(final int index) {
        int left = 0;
        int right = Elem.length-1;

        int pivot = left+(right-left)/2;

        int pivotPosition = rearElem(left, right, pivot);
        while (pivotPosition != index) {
            if (pivotPosition < index) {
                if(right-left == 1) {
                    ++left;
                } else {
                    left = pivotPosition;
                }
            } else {
                right = pivotPosition;
            }
            pivot = left+(right-left)/2;
            pivotPosition = rearElem(left, right, pivot);
        }

        return Elem[index];
    }


    private static int rearElem(final int left, final int right, final int pivot) {
        int smallElemPointer = 0;
        int bigElemPointer = 0;


        for (int i = left; i <= right; i++) {
            if (i != pivot) {
                if (Elem[i].compareTo(Elem[pivot]) < 0) {
                    smallElem[smallElemPointer] = Elem[i];
                    smallElemPointer++;
                } else {
                    bigElem[bigElemPointer] = Elem[i];
                    bigElemPointer++;
                }
            }
        }
        smallElem[smallElemPointer] = Elem[pivot];
        smallElemPointer++;

        System.arraycopy(smallElem, 0, Elem, left, smallElemPointer);
        System.arraycopy(bigElem, 0, Elem, left+smallElemPointer, bigElemPointer);

        return left + smallElemPointer-1;
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
