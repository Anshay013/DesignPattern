package multiThreading.locks;

import multiThreading.ThreadTest4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lockdemo {

    int totAmount = 2000;

    // Two types of lock -
    // 1. Intrinsic
    // 2. Extrinsic


    // These are built into every object in Java. You don't see them but they are there.
    // When you use synchronized keyword. You are using automatic locks

    //  Extrinsic : advanced lock, gives manual control on wha to lock when to lock and when to release.
    // use lock class -> java.util.concurrent.locks


    // Now say two threads access it make it synchronized to avoid race condition ->




/*    public synchronized void withdraw(int amount) {
              if(totAmount >= amount) {
                  System.out.println("amount detected left = " + (totAmount - amount));
                  totAmount -= amount;
                  try{
                      // problem with synchronized ->
*//*                      say t1 enters and slept for 1 day. Since synchronized is used t2 when stared shall wait untill
                      t1 leaves its sleep eihter time over or () -> interrupted. t2 has to wait a long time. so a thread
                      resource wasted just to () -> wait*

                      We can write some manual code from and execute it from another thread to interrupt t1 if t1.getState()
                      is still in sleep  and time is over a certain amount --> bad practice.

                      So what to use extrinsic lock -> Lets study ReentrantLock
                      /
 *//*
                      Thread.sleep(1000 * 60 * 60 * 24);
                  } catch (InterruptedException e) {
                      System.out.println("thread interrupted ");
                  }
              }
              else System.out.println("Low balance");
    }*/


    // ReentrantLock

    private final Lock lock = new ReentrantLock();

    public  void withdraw(int amount) {
        try{
            // it says if lock is free let the thread enter the critical section and execute the code. (say t1 went inside)
            // now when t2 comes it checks lock.tryLock() returns false since t2 was still inside it. So t2 doesn't wait it
            // simply crosses over and goes to else condition. (No resource waiting)
          //  if(lock.tryLock()) {



            // tryLock(time, unit of time) --> here say t1 comes and check no lock aquired and makes the code lock for 100 sec.
            // t2 comes and checks if lock available aquire it. else t2 will be blocked to enter the condition for 100 sec
            // until -
            // 1. t1 unblocks the locks within that time frame (if it does early t2 will immediately aquire the lock even if
            // t < 100 sec has passed) or
            // 2. t1 get interrupted in 100 sec. these 2 condition will let t2 enter. Else it will go to else block

            // Note the thread inside the critical section always have to unblock the lock in the finally block.
            // otherwise the lock will be forever. We put 100sec here to


                if(lock.tryLock(100000, TimeUnit.MILLISECONDS)) {

                System.out.println("Update amount to " + (totAmount - amount));
                totAmount -= amount;
            }
            else{
                System.out.println("prior transaction in progress try again in sometime");
            }

        }
        catch (Exception  e) {
            System.out.println(e.getMessage());
        }
        finally {
            // Even after 100 sec lock wont be unlocked it needs to be explicitly be unlocked
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Lockdemo demo = new Lockdemo();

        // instead of creating class directly call runnable and implement run
        Runnable task = new Runnable() {
            @Override
            public void run() {
                demo.withdraw(1000);
            }
        };



        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        t1.start();
        t2.start();





    }
}
