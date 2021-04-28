package com.experiment06;

import java.util.Scanner;

public class Main_8700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ship s = new Ship();
        try {
            while(true) {
                int l=sc.nextInt();
                if(l==0)break;
                s.load(l);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Go!");
        }
        sc.close();
    }
}

class Ship {
    int load=0,total=1000;

    public void load(int weight) throws Exception {
        if(load+weight>total)throw new Exception("Overload!");
        load+=weight;
        System.out.println(weight+" Loaded.");
    }
}
