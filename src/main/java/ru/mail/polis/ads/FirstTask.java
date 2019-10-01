package ru.mail.polis.ads;

import java.util.Scanner;

public class FirstTask {
    void solve(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(num / 10 + " " + num % 10);
    };
}
