package com.experiment07;

import java.util.concurrent.locks.ReentrantLock;

public class Main_7179 {
    public static void main(String[] args) {
        new Thread(new Animal(Animal.ANIMAL_TYPE.Rabbit)).start();
        new Thread(new Animal(Animal.ANIMAL_TYPE.Turtle)).start();
    }
}

class Animal implements Runnable {
    static int progress_Rabbit = 0, progress_Turtle = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();
    enum ANIMAL_TYPE {
        Rabbit, Turtle
    }

    static final int finishDistance = 100;
    ANIMAL_TYPE type;

    public Animal(ANIMAL_TYPE type) {
        this.type = type;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        while (true) {
            switch (type) {
                case Rabbit:
                    progress_Rabbit += 10;
                    break;
                case Turtle:
                    progress_Turtle += 1;
                    break;
            }
            if (type == ANIMAL_TYPE.Rabbit) {
                System.out.println("兔子距终点还有 " + (finishDistance - progress_Rabbit) + "米。");
                if (progress_Rabbit > progress_Turtle) {
                    System.out.println("我跑得快，睡一觉");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(progress_Rabbit >= finishDistance) {
                    System.out.println(type.name() + " Finished!");
                    break;
                }
            } else if (type == ANIMAL_TYPE.Turtle) {
                System.out.println("乌龟距终点还有 " + (finishDistance - progress_Turtle) + "米。");
                if(progress_Turtle >= finishDistance) {
                    System.out.println(type.name() + " Finished!");
                    break;
                }
            }
        }
        reentrantLock.unlock();
    }
}