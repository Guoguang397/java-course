package com.experiment06;

import java.util.Scanner;

public class Main_8702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Person p = new Person(sc.next(),sc.nextInt());
            System.out.println("姓名："+p.getName()+" 年龄："+p.getAge());
        }catch (IllegalArgumentException e) {
            System.out.println("Err");
        }
        sc.close();
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        if(age>200||age<0)throw new NoAgesException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

class NoAgesException extends IllegalArgumentException {

}