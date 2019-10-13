package ru.mail.polis.ads;

import ru.mail.polis.ads.SolveTemplate.FastScanner;

import java.util.ArrayList;

public class SecondTask {
    void solve(){
        final FastScanner reader = new FastScanner(System.in);
        int num=0;

        String buffer;

        ArrayList<Integer> que = new ArrayList<>() ;

        do{
            buffer=reader.next();
            switch (buffer) {
                case "push": {
                    num = reader.nextInt();
                    que.add(num);
                    System.out.println("ok");
                    break;
                }
                case "pop": {
                    System.out.println(que.get(0));
                    que.remove(0);
                    break;
                }
                case "front": {
                    System.out.println(que.get(0));
                    break;
                }
                case "size": {
                    System.out.println(que.size());
                    break;
                }
                case "clear": {
                    que.clear();
                    System.out.println("ok");
                    break;
                }
                default:
                    break;
            }


        }
        while (!buffer.equals("exit"));

        System.out.println("bye");
    }
}
