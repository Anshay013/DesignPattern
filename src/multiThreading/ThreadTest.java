package multiThreading;

public class ThreadTest extends Thread{

    public ThreadTest(String name) {
        super(name); // calls the parent constructor i,e Thread, Thread constructor actually set thread
        // name if we check the implementation.
    }

    @Override
    public void run() {
        for(int i = 0;  i < 5; ++ i){

           // System.out.println(i);
            // to get name of the thread running here we can simply print (because run will be executed by some diff ideal thread)
            System.out.println(Thread.currentThread().getName() + " get priority =  " +
                    Thread.currentThread().getPriority() + " count is " + i);
        }
        System.out.println(Thread.currentThread().getState()); // RUNNABLE, when it gets the CPU and is running
        // then too in runnable state


        try {
            // tells whether the Thread is interrupted or not.
            // Note here it will always return false because the Thread itself is asking for its interruption
            // (which obviously when getting printed means it isn't interrupted)
            System.out.println(Thread.interrupted());


            // make this thread sleep such that another thread currently running can access its state, note when a thread
            // is sleeping its impossible for it  to fetch anything (since its in sleep). So to access its state we need
            // some other thread to do it.
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        //  note above we cannot add throws to method run, since its an overridden method , yes if it had
        // throws added to its signature then we could.

    }


    public static void main(String[] args) throws InterruptedException {
         ThreadTest t1 = new ThreadTest("Anshay");
         System.out.println(t1.getState()); // NEW, when thread is created


        // Set priority for threads (from min = 1 to max = 10)
        t1.setPriority(Thread.MAX_PRIORITY); // this thread will be given max priority if critical section is free
        // if 2 threads accessing critical section are both set to priority = 10, then the one who goes first to
        // the critical section as targeted by main thread goes first. (initially)

        






         t1.start();
         System.out.println(t1.getState()); // RUNNABLE, when thread is waiting to get CPU
         Thread.sleep(200); // which thread sleeps ? -> the one executing it is the main thread as of
            // now, it also gives time to t1, to execute the method run (t1 for 200ms not running parallel with main thread
            // given we have high CPU support for both thread to run parallel)




        // now main thread can print the state of t1, t1 is sleeping for 2 sec (ample amount of time of main thread
        // to get its state)
        System.out.println(t1.getState()); // TIMED_WAITING




        // what does join do ? since its main thread who has executed t1.join(). The main method will
        // wait until t1 -> finishes (or die or is terminated) after this it will continue its execution.
        long ct = System.currentTimeMillis();
        t1.join();




        System.out.println(t1.getState());

        System.out.println(Thread.currentThread().getName() +
                " has waited for " +  (System.currentTimeMillis() - ct) + " sec and in the process t1 dies now it " +
                "has started its execution");
    }


}
