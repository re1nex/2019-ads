package ru.mail.polis.ads;

import java.util.ArrayList;
import java.util.Scanner;

public class t4 {
    static void solve() {
        final Scanner reader = new Scanner(System.in);
        int num = 0;

        String buffer;
        ArrayList<Character> stack = new ArrayList<>();
        String s = reader.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.add(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && !stack.isEmpty() && stack.get(stack.size() - 1) == '(') {
                    stack.remove(stack.size() - 1);
                } else if (s.charAt(i) == '}' && !stack.isEmpty() && stack.get(stack.size() - 1) == '{') {
                    stack.remove(stack.size() - 1);
                } else if ((s.charAt(i) == '}' || s.charAt(i) == ')') && stack.isEmpty()) {
                    stack.add(s.charAt(i));
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}