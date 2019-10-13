package ru.mail.polis.ads;

import java.util.Scanner;

public class FourthTask {
    private static String[][] mtx;
    private static String input;
    
    private static String pack(final String minSubstr,int len, int left, int right) {
        String result = minSubstr;
        for (int period = 1; period < len; period++) {
            if (len%period == 0 && checkPeriod(left, period, right)) {
                final String tmp = len/period + "(" + mtx[left][left + period - 1] + ")";
                result = tmp.length() < result.length() ? tmp : result;
            }
        }
        return result;
    }



    private static String MinSubstr(String cur,int left,  int right) {

        String result= cur;
        for (int right1 = left; right1 < right; right1++) {
            final int left2 = right1 + 1;
            final String tmp = mtx[left][right1] + mtx[left2][right];

            if (tmp.length() < result.length()) {
                result = tmp;
            }
        }

        return result;
    }



    private static boolean checkPeriod( int left, int period, int right) {

        boolean checkPeriod = true;
        for (int i = left + period; i <= right; i++) {
            if (input.charAt(i) != input.charAt(i - period)) {
                checkPeriod = false;
                break;
            }
        }

        return checkPeriod;
    }


    public static void solve() {
        final Scanner in = new Scanner(System.in);
        input = in.nextLine();
        mtx = new String[input.length()][input.length()];


        for (int len = 1; len <= input.length(); len++) {

            for (int left = 0; left + len - 1 < input.length(); left++) {

                final int right = left + len -1;

                String minSubstr = input.substring(left, right+1);


                if(len > 4) {

                    minSubstr = MinSubstr(minSubstr, left, right);


                    minSubstr = pack(minSubstr, len, left, right);
                }

                mtx[left][right] = minSubstr;
            }
        }

        System.out.println(mtx[0][input.length()-1]);

    }

}
