package org.praveen.test;

public class App {
    public static void main(String[] args) {

    }

    public int addTwoNumbers(int a,int b){
        if(a == b)
            throw new RuntimeException("Sample error thrown");
        else
            return a+b;
    }
}
