package com.sjenterprises.java.duplicate;

public class LambaDemo {

    public static void main(String[] args) {
        printMyname("Jack");
    }

    private static void printMyname(String name) {
        name = name+"Nelson";
        Runnable r = () ->{
            try {
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }
//            System.out.println("Welcome:"+name);
        };
    }
}
