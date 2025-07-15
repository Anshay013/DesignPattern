package multiThreading;

public class Counter {
    private int count = 0;

    // make fun synchronized such that 2 threads don't enter at the same time -> one thread at a time --> mutual exclusion
/*    public synchronized void increment(){
        ++ count;
    }*/

       // Or make particular block of code as synchronized, better practice
    public void increment(){
        synchronized(this) {
            ++count;
        }
        // ("this") -> we talk about a single instance on which the increment method is called which is accessed by
        // multiple threads. Making this will make only one thread access it at one time
    }

    public int getCount() {
        return count;
    }

}
