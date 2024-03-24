import java.util.*;
fun randomDay():String{
    val week =arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day:String):String{
    return when(day)
    {
        "Monday" -> "flakes"
        "Wednesday"->"redworms"
        "Thursday"->"granules"
        "Friday"->"mosquitoes"
        "Sunday" ->"plankton"
        else -> "nothing"
    }
}

fun feedTheFish()
{
    val day=randomDay()
    val food=fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}
fun swim(speed:String ="fast")
{
    println("swimming $speed")
}

fun main(args: Array<String>)
{
    val decorations= listOf("rock","pagoda","plastic plant","alligator","flowerpot")
    val eager=decorations.filter{it[0]=='p'}
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    val newList=filtered.toList()
    println("new list :$newList")
    println("eager:$eager")
    val lazyMap=decorations.asSequence().map{
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    feedTheFish()
    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter
    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")
    println(updateDirty(30, waterFilter))

}
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

fun shouldChangeWater(day:String,temperature:Int=22,dirty:Int=20):Boolean
{
    return when{
        IsTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day)-> true
        else -> false
    }
}


fun IsTooHot(temperature:Int)=temperature>30
fun isDirty(dirty: Int)=dirty>30
fun isSunday(day:String)=day=="Sunday"
