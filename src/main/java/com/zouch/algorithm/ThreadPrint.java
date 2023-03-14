package com.zouch.algorithm;

class Test1{
    int num=0;
    Object o = new Object();

    private void  print(int targetNum) throws InterruptedException {
        while(true) {
            synchronized (o) {
                //注意while不能写成if -----》会造成虚假唤醒
                while (num % 3 != targetNum) {
                    o.wait();
                }
                if (num >=100){
                    break;
                }
                num++;
                System.out.println(Thread.currentThread().getName() + num);
                o.notifyAll();

            }
        }
    }
    public static void main(String[] args) {
        Test1 main = new Test1();
        new Thread(() -> {
            try {
                main.print(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                main.print(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                main.print(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();

    }
}
