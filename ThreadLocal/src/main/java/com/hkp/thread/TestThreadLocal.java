package com.hkp.thread;

public class TestThreadLocal
{
    public static void main(String[] args)
    {
        ThreadDemo td = new ThreadDemo();
        Thread t1 = new Thread(td, "a");
        Thread t2 = new Thread(td, "b");
        t1.start();
        t2.start();
    }
}
