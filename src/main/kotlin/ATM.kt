class ATM(stored50BillsValue:Int, stored20BillsValue:Int, stored10BillsValue:Int) {
    init {
        require(stored50BillsValue >= 0){"The number of stored 50 bills must be higher or equal to 0"}
        require(stored20BillsValue >= 0){"The number of stored 20 bills must be higher or equal to 0"}
        require(stored10BillsValue >= 0){"The number of stored 10 bills must be higher or equal to 0"}
    }

    var stored50Bills: Int = stored50BillsValue
        set(value) {
            require(value >= 0){"The new value must be higher or equal to 0"}

            field = value
        }


}
