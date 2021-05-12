package com.experiment07;

public class Main_7180 {
    public static void main(String[] args) {
        Station s = new Station();
        new Thread(s, "售票点 1").start();
        new Thread(s, "售票点 2").start();
        new Thread(s, "售票点 3").start();
    }
}

class Station implements Runnable {
    static int ticketCount = 200;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("[" + Thread.currentThread().getName() + "] 售票,剩余 " + ticketCount + " 张。");
            if (ticketCount > 0) {
                ticketCount--;
            }
        }
    }
}