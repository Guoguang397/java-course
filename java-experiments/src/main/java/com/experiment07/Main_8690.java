package com.experiment07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main_8690 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Random random = new Random();
        HashMap<Integer,Boolean> hashMap=new HashMap<>();
        int cnt=0;
        while(cnt<10) {
            int randInt= random.nextInt(100);
            if(hashMap.get(randInt)==null) {
                hashMap.put(randInt,true);
                names.add("编号"+random.nextInt(100)+"的人");
                cnt++;
            }
        }
        DMQ dmq = new DMQ();
        for(String s:names) {
            new Thread(dmq,s).start();
        }
    }
}

class DMQ implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 过独木桥");
        }
    }
}