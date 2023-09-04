package edu.allan.java.threads;

public class ThreadSample3 extends Thread {
    public static void main(String[] args) {
        ThreadSample3 thread = new ThreadSample3();
            thread.start();
            System.out.println("This code is outside of the thread");
    }
    public void run() {
        System.out.println("This code is running in a thread");
    }

}
