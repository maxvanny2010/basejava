package com.basejava.webapp;

public class MainThreadCurrency {
    private static int counter;

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " " + getState());
            }
        };
        thread0.start();
        //start second way Thread is better
        new Thread(() -> {
            //don't work cause the cod inside Runnable(have not method getName) not in Thread
             //   System.out.println(getName());
            //Right way. take current Thread and take getName
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());

        }).start();//lambda
        System.out.println(thread0.getState());
        // out 1 000 000 in one thread app
        for(int i = 0; i < 10000; i++) {
            for(int j = 0; j < 100; j++) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
