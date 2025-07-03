package multiThreading;

public class ThreadTest extends Thread{

    @Override
    public void run(){
        for(int i = 0;  i < 1000; ++ i){
           // System.out.println(i);
            // to get name of the thread running here we can simply print (because run will be executed by some diff ideal thread)
            System.out.println(Thread.currentThread().getName());
        }
    }

}
