package example.myapp

abstract class AquariumFish:FishAction {
    abstract val color:String
    override fun eat()=println("yum")
    object GoldColor:FishColor{
        override val color="gold"
    }


}
class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

