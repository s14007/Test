package jp.ac.it_college.std.s14007.test;

import jp.ac.it_college.std.nakasone.lib.exam.Communicator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        System.out.print("名前を入力してください: ");
        String name = scan.next();
        Communicator comm = new Communicator((msg) -> {
            System.out.println("> " + msg);
        });
        comm.start();


            try {
                System.out.println("入力してください。");
                System.out.println("qで終了します。");
                while (true) {
                    String input = scan.next();
                    comm.send(name + ": " + input);
                    if (input.equals("q")) {
                        System.out.println("終了");
                        comm.finish();
                        System.exit(0);
                        break;
                    }
                }
            } catch (IOException var3) {
                var3.printStackTrace();
            }
    }
}
