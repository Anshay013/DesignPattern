package multiThreading;

public class ThreadTest4 extends Thread{

   private Counter counter;

   public ThreadTest4(Counter counter) {
       this.counter = counter;
   }
   @Override
   public void run() {
       for(int i = 0; i < 1000 ; ++ i){
           counter.increment();
       }
   }

   public static void main(String[] args) {

       Counter counter = new Counter();

       ThreadTest4 t1 = new ThreadTest4(counter);
       ThreadTest4 t2 = new ThreadTest4(counter);
       t1.start();
       t2.start();
       try{
           t1.join();
           t2.join();
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }

       System.out.println(counter.getCount());
       // ideally o/p should be 2000. But its somewhat less or equal to 2000 (never more cant be) and most of time its different

/*       why ?
       At some point of time t1 and t2 both enters the the critical section together (reading counter say = 101, at the same time -> "race condition")
       both read 101 so both does its job to make it 102. i.e t1 reads it 101 and makes it 102 and t2 also reads it 101 and makes
       counter to 102. By definition it should be 103 but +1 gets skipped to both accessing it at the same time.*/

      // race condition in multithreading occurs when multiple threads try to access and modify the same shared data concurrently

       // Ans ->  ame fun synchronized





    }
}
