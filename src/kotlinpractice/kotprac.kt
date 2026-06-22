package kotlinpractice

class kotprac {

    private var i = 0
    private var number: Int? = null
    private var list = arrayListOf("A", "B") // or ArrayList<String>()

    public fun getSquare() = (i * i).also {  // also applied on fun, but it doesn't changes the return type.
        println(it)
        ++ i
        println(it)
    }

    fun main() {
        getSquare()

        // instead of
        if(number != null){
            // do some ops.
            // use lets because, say two threads enters at same time, t1 performs some ops on non null number then makes number == null again.
            // t2 was already in how when it tries to perform some ops it gets nullptrExp.

            // to avoid this nullptr use let
        }

        val x = number?.let {
            val n2 = it + 1
            n2 // whatever is the last line in this, become the return type of x
        } ?: 3

        println(x)


       val f1 = list.apply {  // acts as a builder pattern
            add("234")
            remove("A")
        }
        // f1 has return type of modified list.

        println(f1)

        val f2 = list.run {  // how run and apply seems same it does modifies the list but f2 is not a list
            add("234")
            remove("A") // f2 takes the return type of last line in here, just like let
           // this // write this --> points to list, which will help f2 lets the list
        }

        println(f2)


        // similar to run and apply, syntax diff and we cannot store this.
        with(list) {
            add("FFFF")
            add("FFIHF")
            remove("FFFF")
        }



        //




    }

}