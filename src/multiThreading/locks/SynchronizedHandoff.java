package multiThreading.locks;

public class SynchronizedHandoff {
    private final Object keyA = new Object();

    public void aliceTask() {
        synchronized (keyA) {
            try {
                System.out.println("Alice: I have Car A. Starting the engine...");

                System.out.println("Alice: Waiting for Bob to load bags. Dropping the lock!");
                // wait() pauses Alice's thread AND releases the lock on keyA
                keyA.wait(); // the thread which triggers it waits untill this obj keyA is notified again.

                // when keyA gets the notify signal, after t2 execution gets completed the t1 starts executing after wait() and yes keyA acquire the lock again
                // untill synchro blocks end (where lock gets released)


                // Alice wakes up here AFTER Bob calls notify() AND finishes his block
                System.out.println("Alice: Got the lock back! Driving away. VROOM!");


                //            // SAY waiting is too long alice needs to proceed (t1 thread has starved waiting for signal()) then what ?? -
//            Alice will wait for Bob's signal, BUT she will give up after 5 seconds.
                //               keyA.wait(5000);


            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void bobTask() {
        // Bob can only enter this once Alice calls keyA.wait()
        synchronized (keyA) {
            System.out.println("Bob: I got the lock for Car A. Loading bags...");

            // notify() tells ONE waiting thread (Alice) to wake up.
            // BUT Alice doesn't get the lock immediately...
            keyA.notify();

            System.out.println("Bob: Bags loaded. I'm leaving so Alice can have the lock back.");
        } // Bob actually releases the lock right here at the closing bracket
    }

    public static void main(String[] args) {
        SynchronizedHandoff sync = new SynchronizedHandoff();

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
