fun main() {
    try {
        val atm1 = ATM(0, 1, 10)

        val requestedAmount:Int = 110

        print(
            "---- ATM operation test report ----\n" +
            "Requested amount: ${requestedAmount}€\n"+
            "---- ATM's data ----\n"+
            "Currently stored amount: ${(50 * atm1.stored50Bills) + (20 * atm1.stored20Bills) + (10 * atm1.stored10Bills)}\n"+
            "Currently stored 50€ bills: ${atm1.stored50Bills}\n"+
            "Currently stored 20€ bills: ${atm1.stored20Bills}\n"+
            "Currently stored 10€ bills: ${atm1.stored10Bills}\n"+
            "Last given 50€ bills: ${atm1.last50BillsGiven}\n"+
            "Last given 20€ bills: ${atm1.last20BillsGiven}\n"+
            "Last given 10€ bills: ${atm1.last10BillsGiven}\n"+
            "---- Processing takeout operation.... ----\n"+
            "Has the process been successful? ${if(atm1.processTakeoutOperation(requestedAmount)) "Yes" else "No"}\n"+
            "---- ATM's after-operation data ----\n"+
            "Currently stored amount: ${(50 * atm1.stored50Bills) + (20 * atm1.stored20Bills) + (10 * atm1.stored10Bills)}\n"+
            "Currently stored 50€ bills: ${atm1.stored50Bills}\n"+
            "Currently stored 20€ bills: ${atm1.stored20Bills}\n"+
            "Currently stored 10€ bills: ${atm1.stored10Bills}\n"+
            "Last given 50€ bills: ${atm1.last50BillsGiven}\n"+
            "Last given 20€ bills: ${atm1.last20BillsGiven}\n"+
            "Last given 10€ bills: ${atm1.last10BillsGiven}\n"+
            "--- End of ATM operation report ----"
        )
    } catch(err: IllegalArgumentException) {
        print(
            "---- ATM operation test report ----\n" +
            "[ERROR] The provided amount of takeout value, or the inserted configuration for the ATM has not been accepted by the ATM:\n"+
            "> ${err.message}\n"+
            "--- End of ATM operation report ----"
        )
    } catch(err: Exception) {
        print(
            "---- ATM operation test report ----\n" +
            "[ERROR] There has been an error while trying to process the operation:\n"+
            "> ${err.message}\n"+
            "--- End of ATM operation report ----"
        )
    }
}