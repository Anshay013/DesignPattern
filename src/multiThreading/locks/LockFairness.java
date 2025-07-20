package multiThreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFairness {




   private final Lock unfair = new ReentrantLock(true); // amke it as true
   // It says until a thread completes it job (releases the lock and exit) next thread won't acquire the lock it
   // It will be in order, basically reentrant is getting  synchronized features)


   // Fairness --> It says there an order in which thread executes its job, if a thread is executing it will complete its job then only other thread is
   // allowed to start it. (irrespective of the previous thread has released the lock or not)

   //  private final Lock unfair = new ReentrantLock(); --> unfair (because we don't know the order in which, thread acquire the lock (2 and 3, 1 will always acquire it first)


   // VVI -  Note if we are using Synchronized keyword to lock a fun. At that time thread executing it cannot be interrupted.

   public void accesResource() {
      unfair.lock();
      try {
         System.out.println(Thread.currentThread().getName() + " acquired the lock");
         Thread.sleep(1000);
      }
      catch(Exception e) {
         Thread.currentThread().interrupt(); // interrupt from sleep so to make it alive, thread interrupting itself
         System.out.println(e.getMessage());
      }
      finally {
         System.out.println(Thread.currentThread().getName() + " released the lock"); // tell me what will happen if I release the lock before this print statement
         // try run you will see what is happening
         unfair.unlock();
      }
   }

   public static void main(String[] args) {
      LockFairness example = new LockFairness();

      Runnable task = () -> {
            example.accesResource();
      };

      Thread  t1 = new Thread(task, "Thread 1");
      Thread  t2 = new Thread(task, "Thread 2");
      Thread  t3 = new Thread(task, "Thread 3");

      // Any thread can start the execution depending upon what scheduler wants (since all have same priority). Until we put the main thread to sleep in between every t[i].start
      t1.start();
      t2.start();
      t3.start();




   }
}
