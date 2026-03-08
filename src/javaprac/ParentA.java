package javaprac;

interface ParentA {

    default void fun(){
        System.out.println("parentA fun");
    }


    // when you define default in interface it behaves as an fun()1{   } in anstract class
    // whether you want to implement it or not its up to you.
    default void fun1(){
        System.out.println("my msg");
    }

}
