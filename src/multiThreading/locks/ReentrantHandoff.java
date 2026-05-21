package multiThreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantHandoff {
    private final Lock carALock = new ReentrantLock();
    // A Condition acts like a specific waiting room for this lock
    private final Condition bagsLoaded = carALock.newCondition();

    public void aliceTask() {
        carALock.lock();
        try {
            System.out.println("Alice: I have Car A. Starting the engine...");

            System.out.println("Alice: Waiting for Bob to load bags. Dropping the lock!");
            // await() releases carALock and puts Alice to sleep
            bagsLoaded.await();
            // NOTE after notify from bob is done,  thread start executing the line after await() --> yes --> "The lock on carLock gets acquired again"

            System.out.println("Alice: Got the lock back! Driving away. VROOM!");


//
//            // SAY waiting is too long alice needs to proceed (t1 thread has starved waiting for signal()) then what ?? -
//            Alice will wait for Bob's signal, BUT she will give up after 5 seconds.
//            boolean gotSignal = bagsLoaded.await(5, TimeUnit.SECONDS);
//
//            if (!gotSignal) {
//                System.out.println("Alice: Bob took too long! I'm leaving without the bags.");
//                // Alice automatically re-acquires the lock here and continues!
//            }


        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            carALock.unlock(); // Always in a finally block!
        }
    }

    public void bobTask() {
        carALock.lock(); // Bob gets in when Alice calls await()
        try {
            System.out.println("Bob: I got the lock for Car A. Loading bags...");

            // signal() wakes up Alice, just like notify()
            bagsLoaded.signal();

            System.out.println("Bob: Bags loaded. Unlocking so Alice can finish.");
        } finally {
            carALock.unlock(); // Alice actually gets the lock back when this runs
        }
    }

    public static void main(String[] args) {
        SynchronizedHandoff sync = new SynchronizedHandoff();
//        sync.aliceTask(); // do this main thrad calls aliceTask() and await on lock relases the lock and put the thread  sleep , untill signal on same
        // lock perfoermed, here no one performs the signal --> forever sleep code stuck
//        sync.bobTask();


        Thread t1 = new Thread(() -> {
            sync.aliceTask();
        });


        Thread t2 = new Thread(() -> {
            sync.bobTask();
        });
        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();
        }
        catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }
}