package javaprac;

public class ChildA implements ParentA, ParentB {


    @Override
    public void fun() {
        ParentA.super.fun();
    }


}
