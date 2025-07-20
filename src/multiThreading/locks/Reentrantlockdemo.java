package multiThreading.locks;

import multiThreading.ThreadTest4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrantlockdemo {

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


                if(lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
                    try {
                        Thread.sleep(3000);


                        System.out.println(Thread.currentThread().getName() + " Update amount to " + (totAmount - amount));
                        totAmount -= amount;
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                         // here just printing out the exception say when the thread was interrupted isn't enough.
                        //  We do lose the info. that the thread was interrupted probably without finishing the task.

                        // now we want to restore the state from where the thread was interrupted - (Good practice)
                        // .interrupt called by the currentThread will restore back its state, then after it help us to perform other ops.

                        // Above is very confusing read below -

                        // In simple words when Interrupted exception for thread is caught in catch block JVM clears the interrupt flag of thread.
                        // Now we wanted to print something or monitor something (call some service) when the thread was interrupted. But the
                        // flag is cleared so according to JVM no interruption occurred. Hence, the thread itself interrupts itself to get back
                        // that interrupt state

                        Thread.currentThread().interrupt();
                    }
                    finally {

                        System.out.println(Thread.currentThread().getName() + " transaction over continue");
                        System.out.println(Thread.currentThread().getName() + " unblocking thread");
                        lock.unlock(); // lock will always be released by  the same thread which has aquired it (else exception will be thrown)
                        // so always unlock the lock inside the condition of lock aquired -> if : lock.tryLock() -> unlock
                    }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " prior transaction in progress try again in sometime");
            }
            if(Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread().getName() + " thread was interrupted");
            }


        }
        catch (Exception  e) { // will be caught, if thread is interrupted while in sleep, given finally will executed after this
            // and lock will be released
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }

    }

    /*
      When happens to the thread when it is interrupted and when does it get normal ?

      When thread is sleep ->

      When thread is interrupted it goes to catch block. -> As soon as we handle the
      interrupted exception the thread is ready to fun. When ever a thread is interrupted an exception can be caught
      in the block.

      Executing or ideal not in sleep mode ->
      Interrupts in Java are a cooperative mechanism. They are a way for one thread to politely ask another to stop.
      If the interrupted thread doesn’t cooperate, nothing forces it to stop. say main thread calls t1.interrupt().
      t1 can check Thread.currentThread().isInterrupted() if yes its on t1 to stop or ignore it.

    * */


    public static void main(String[] args) {
        Reentrantlockdemo demo = new Reentrantlockdemo();

        // instead of creating class directly call runnable and implement run
        Runnable task = new Runnable() {
            @Override
            public void run() {
                demo.withdraw(100);
            }
        };



        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }





    }
}
