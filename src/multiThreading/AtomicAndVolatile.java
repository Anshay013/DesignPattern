package multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAndVolatile {

    static AtomicInteger a = new AtomicInteger(0);
    volatile int x = 0; // this x is in memory but not atomic hence not thread safe.


    public static void main(String[] args) {
        a.getAndIncrement(); // 1
        a.addAndGet(10); // 11
        System.out.println(a.get());
        a.compareAndExchange(11, 13);
        System.out.println(a.get());

        int k = a.getAndUpdate(x -> {
            return x + 10;
            // printing k doesn't make it 23 because getAndUpdate returns previous value i.e 13
            // a.get() in here returns before the inner impl.
        });

        System.out.println(k); // 13
        System.out.println(a.get()); // 23



        // AtomicInteger = volatile + CAS
        // Volatile -> in memory but not thread safe. (can be any dataType)



        // CAS -> hardware-level atomic instruction used to safely update a value without locking.






    }
}
