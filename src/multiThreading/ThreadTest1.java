package multiThreading;

public class ThreadTest1 extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 5; ++ i) {
            System.out.println(Thread.currentThread().getName() + " is running");


          //  Thread.yield(); // it means the scheduler "may" make the current thread running this code yield (leave) this and give
            // chance to another thread who wants to run it. (The current thread is willing to yield its possession but it depends on
            // scheduler if it wants to ignore it)
            // When to know does it want to or not ? Is it random ?


        }
        // DAEMON threads -
        // Those threads which runs on background example the garbage collector is run via Daemon. Point to note JVM doesn't wait
        // for these daemon threads.

        // Note : When all threads complete its work , JVM shuts down. (JVM waits for any user threads if still doing its work).
        // But JVM doesn't wait for daemon thread. Irrespective of what daemon thread does. If there are no user-thread onlune JVM
        // shuts down.

        // Q If JVM shuts down then wht happens of the daemon thread ? Does it still go working ?
        // If JVM is down naturally daemon will also be down
        int cnt = 1000;
        while(true) {
          System.out.println("still Alive");
        }
    }

    public static void main(String[] args){
/*       ThreadTest1 t1 = new ThreadTest1();
       ThreadTest1 t2 = new ThreadTest1();
       ThreadTest1 t3 = new ThreadTest1();
       // Thread t3 = new ThreadTest1(); // can do it like this as well, I think its better to do it like this. if we have multiple classes
        // extendin thread. D -> dependency inversion states that instead of interacting with concrete classes. Interact with there abstraction.
        // here Thread acts like an abstraction "(but not exactly, it being not abstract but then again it itself implements runnable which
        // makes the above point valid)"

        t1.start();
        t2.start();
        t3.start();*/

        ThreadTest1 t4 = new ThreadTest1();
        //ThreadTest1 t5 = new ThreadTest1();
        t4.setDaemon(true);
        //t5.start();
        t4.start();
        if(t4.isAlive()) System.out.println(t4.getName() + " is alive");
        System.out.println("main done");




    }
}
