package com.experiment06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_8691 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        try {
            n=sc.nextInt();
            System.out.println(10-n);
        }catch (InputMismatchException e) {
            System.out.println("not int");
        }
        finally {
            System.out.println("end");
        }
        sc.close();
    }
}
