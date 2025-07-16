package multiThreading.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo2 {

    // we will check lock fairness later

    private final ReentrantLock lock = new ReentrantLock();




    public void outerMethod() {
        lock.lock(); // this basically acts like synchronized other thread waits indefinitely until the thread aquired it releases it.

        // or use


/*        try {
            lock.lockInterruptibly(); // does the same thing
        }
        catch (Exception e){

        }*/



        try {
            System.out.println("Outer Method");
            innerMethod();
        }
        catch (Exception e){
            System.out.println("Outer method exp :" + e.getMessage());
        }
        finally {
            lock.unlock();
        }
    }

    private void innerMethod() {
        lock.lock(); // thread is trying to lock the same lock once again, which it had locked earlier.

        // basically here thread is trying to fetch the lock which was already locked. So the thread needs to wait forever for this.
        // until this lock is unlocked. To execute the inner fun we are depending on outer method to unlock the lock and for outer  method
        // to complete its execution needs inner method to complete its. (Both outer and inner are dependent on each other) -> "DEAD LOCK" situation

        // The above case would have been true but here we use "Reentrant Lock" -> means the lock can be entered once again. i.e entered
        // and locked once again (but note it should be the same thread which aquired it earlier, if it was other thread trying to execute
        // other or inner fun it won't be able to. That thread has to wait until the thread aquired it will release it)

        // Reentrant lock keeps a count with itself that how many times it has been aquired by same thread. So it needs same number of
        // of count unlocks to release it completely


        try {
            System.out.println("Inner Method");
        }
        catch (Exception e){
            System.out.println("inner method exp :" + e.getMessage());
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantDemo2 demo = new ReentrantDemo2();
        demo.outerMethod();
    }
}
