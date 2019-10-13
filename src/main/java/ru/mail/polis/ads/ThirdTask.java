package ru.mail.polis.ads;

import java.util.Scanner;

public class ThirdTask {
    public static void rec(int l, int r, int[][] dp, int[][] ep, String s) {
        if (l > r) return;

        if (l == r)

        {

            if (s.charAt(l) == '(' || s.charAt(r) == ')')

                System.out.print("()");

            else

                System.out.print("[]");

        } else if (ep[l][r] == -1)

        {
            System.out.print(s.charAt(l));


            rec(l + 1, r - 1,dp,ep,s);

            System.out.print(s.charAt(r));

        } else

        {
            rec(l , ep[l][r],dp,ep,s);
            rec(ep[l][r]+1 ,r ,dp,ep,s);


        }
    }
    public static void solve() {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int dp[][]=new int[s.length()][s.length()];
        int ep[][]=new int[s.length()][s.length()];
        int n = s.length();
        for (int r = 0; r < n; ++r)
            for (int l = r; l >= 0; --l){
                if (l == r)
                    dp[l][r] = 1;
                else{
                    int best = 1000000; int mk = -1;
                    if (s.charAt(l) == '(' && s.charAt(r) == ')' || s.charAt(l) == '[' &&
                            s.charAt(r) == ']' || s.charAt(l) == '{' && s.charAt(r) == '}')

                        best = dp[l + 1][r - 1];

                    for (int k = l; k < r; ++k)
                        if (dp[l][k] + dp[k + 1][r] < best){
                            best = dp[l][k] + dp[k + 1][r];
                            mk = k;
                        }
                    dp[l][r] = best; ep[l][r] = mk;
                }
            }



        rec(0, n - 1,dp,ep,s);
    }
}
