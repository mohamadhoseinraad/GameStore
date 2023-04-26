package ir.ac.kntu;

import java.util.Scanner;

public class Scan {
    private final static Scanner sc = new Scanner(System.in);

    private Scan(){

    }

    public int getInt(){
        return sc.nextInt();
    }
    public String getLine(){
        return sc.nextLine();
    }
    public String getNext(){
        return sc.next();
    }
    public void scanClose(){
        sc.close();
    }
}
