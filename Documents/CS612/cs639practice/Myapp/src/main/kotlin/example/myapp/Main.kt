package example.myapp

import example.myapp.decor.makeDecorations

class Main {
}

fun buildaquarium()
{
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

}
fun main()
{
    buildaquarium()
    makeDecorations()
}