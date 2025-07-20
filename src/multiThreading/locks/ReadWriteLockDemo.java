package multiThreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockDemo {

    // The synchronized keyword doesn't know which one is read and which is write. (Must be synchronized in Writing)
    // Doing it manually takes a lot of time. So we use this read write lock.


    int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    // what is does is > allows multiple thread to "read" at the same time. But writing is done synchronously.


    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public void increment() {
        writeLock.lock(); // it also has tryLock() and tryLock(time, UNIT) method which does the same thing done by ReentrantLock tryLock()
        // note ReentrantReadWriteLock doesn't extends or implements ReentrantLock (has its own tryLock() fun defined)
        // while it does implement ReadWriteLock.

        try {
            ++ count;
        }
        finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock(); // multiple threads at the same time can acquire it
        try {
            return count;
        }
        finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        Runnable readTask = () -> { // If a writeLock has ran, will the read Lock wait untill it compeltes its execution ?
            for(int i = 0; i < 10; ++ i) {
                System.out.println(Thread.currentThread().getName() + " read " + demo.getCount() );
            }
        };

        Runnable writeTask = () -> { // what if multiple Thread acess this writeLock, what happens here ?
            for(int i = 0; i < 100; ++ i) {
                demo.increment();
                System.out.println(Thread.currentThread().getName() + " write " + "incemented" );
            }
        };

        Thread wt = new Thread(writeTask, "Wt 1");
        Thread rt1 = new Thread(readTask, "Rt 1");
        Thread rt2 = new Thread(readTask, "Rt 1");

        wt.start();
        rt1.start();
        rt2.start();

        try {
            wt.join();
            rt1.join();
            rt1.join();
        }
        catch (Exception e){
            System.out.println("exception during join");
        }
        System.out.println("Final OCunt " + demo.getCount());


 // I have many ques i here. Will clear it tomorrow




    }



}
