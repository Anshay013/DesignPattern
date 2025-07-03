package multiThreading;

public class ThreadPractice {

    public void practice(){
        // when we run the program note in the terminal we get "process finished with exit code 0"
        // that means a process has ran.

        System.out.println(Thread.currentThread().getName());




        ThreadTest test = new ThreadTest();
         test.start(); // since test extends Thread and we have overridden run in it so we get a function .start() which
        // executes run()

        // note we could also have done -->
         // test.run(); // this will run the fun run() but on the main thread

        // note the above ThreadTest object creation and test.start() is called by main thread only. but the execution
        // of run() will be done by some other thread.


        // Also if this object declaration of ThreadTest and its start trigger was done after the below for "abc" loop then
        // this whole scenario would be treated as  a single logic execution. because ThreadTest creation and start happens in
        // main thread and itn will happen after main thread completes for loop execution.


        // to execute ThreadTest2 class run method. we need to create new thread since it implements Runnable
        // so to achieve this we do something like this ->

        ThreadTest2 test2 = new ThreadTest2();
        Thread t1 = new Thread(test2);
        System.out.println(t1.getName()); // directly get name or go to the fun it executes and get its name there by CurrentThread.getName()
        t1.start();





        for(int i = 0; i < 1000; ++ i){
            System.out.println("abc");
        }

        // to create thread in java we either extend thread

        // so to make run something onn a new thread we need to create a new class which extends thread or implements Runnable.
        // runnable is a functional interface having only one abstract fun run so we can use lambda


    }
}
