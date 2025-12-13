fun main() {
    val atm1 = ATM(10, 10, 10)

    println(atm1.processTakeoutOperation(150))
    println(atm1.stored50Bills)
    println(atm1.stored20Bills)
    println(atm1.stored10Bills)
}