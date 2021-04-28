package com.experiment06;

import java.util.Scanner;

public class Main_8701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            triangle(sc.nextInt(),sc.nextInt(), sc.nextInt());
            System.out.println("ok");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    public static void triangle(int a,int b,int c) throws IllegalArgumentException {
        if(a+b>c&&b+c>a&&a+c>b)return;
        throw new IllegalArgumentException("a,b,c不能构成三角形");
    }
}
