class ATM(stored50BillsValue:Int, stored20BillsValue:Int, stored10BillsValue:Int) {
    init {
        require(stored50BillsValue >= 0){"The number of stored 50 bills must be higher or equal to 0"}
        require(stored20BillsValue >= 0){"The number of stored 20 bills must be higher or equal to 0"}
        require(stored10BillsValue >= 0){"The number of stored 10 bills must be higher or equal to 0"}
    }

    /** ATTENTION!
    ** The following class considers ATM takeouts only available in Integers values of money, not Doubles nor Floats
     */

    var stored50Bills: Int = stored50BillsValue
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    var stored20Bills: Int = stored20BillsValue
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    var stored10Bills: Int = stored10BillsValue
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    var last50BillsGiven: Int = 0
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    var last20BillsGiven: Int = 0
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    var last10BillsGiven: Int = 0
        private set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }

    private val totalAmountStored:Int
        get() {
            return (50 * stored50Bills) + (20 * stored20Bills) + (10 * stored10Bills)
        }

    private fun calculate50BillsAmount(amount: Int):Int {
        require(amount >= 0){"The given amount must be higher or equal to 0"}

        return amount.toInt()/50
    }

    private fun calculate20BillsAmount(amount: Int):Int {
        require(amount >= 0){"The given amount must be higher or equal to 0"}

        return amount.toInt()/20
    }

    private fun calculate10BillsAmount(amount: Int):Int {
        require(amount >= 0){"The given amount must be higher or equal to 0"}

        return amount.toInt()/10
    }

    fun processTakeoutOperation(amount: Int):Boolean {
        require(amount > 0){"You must take out a value of money higher than 0."}

        if(amount > totalAmountStored || amount % 10 != 0) {
            return false
        }

        var tempAmount: Int = amount
        var needed50Bills: Int
        var needed20Bills: Int
        var needed10Bills: Int

        while(tempAmount > 0) {
            if(tempAmount % 50  == 0) {
                needed50Bills = calculate50BillsAmount(tempAmount)

                if(stored50Bills >= needed50Bills) {
                    tempAmount -= 50 * needed50Bills

                    last50BillsGiven = needed50Bills
                    stored50Bills -= needed50Bills
                }
            }

            if(tempAmount % 20 == 0 && tempAmount != 0) {
                needed20Bills = calculate20BillsAmount(tempAmount)

                if(stored20Bills >= needed20Bills) {
                    tempAmount -= 10 * needed20Bills

                    last20BillsGiven = needed20Bills
                    stored20Bills -= needed20Bills
                }
            }

            if(tempAmount % 10 == 0 && tempAmount != 0) {
                needed10Bills = calculate10BillsAmount(tempAmount)

                if(stored10Bills >= needed10Bills) {
                    tempAmount -= 10 * needed10Bills

                    last10BillsGiven = needed10Bills
                    stored10Bills -= needed10Bills
                }
            }
        }

        return true
    }
}
