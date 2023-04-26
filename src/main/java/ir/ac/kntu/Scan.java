package ir.ac.kntu;

import java.util.Scanner;

public class Scan {
    private final static Scanner sc = new Scanner(System.in);

    private Scan(){

    }

    public static int getInt(){
        return sc.nextInt();
    }
    public static String getLine(){
        return sc.nextLine();
    }
    public static String getNext(){
        return sc.next();
    }
    public static void scanClose(){
        sc.close();
    }
}
