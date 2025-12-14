import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ATMTest {

 /**** Constructor ****/
 @Test
 fun ATM_parametersDoNotMeetRequirements_IllegalArgumentException() {
  assertThrows<IllegalArgumentException> {ATM(0, -100, -1)}
 }

 /**** Getters ****/
 @Test
  fun getStored50Bills__receiveFieldValue() {
   val atm = ATM(100, 100, 100)

   val expected = 100
   val result = atm.stored50Bills

   assertEquals(expected, result)
  }

 @Test
 fun getStored20Bills__receiveFieldValue() {
  val atm = ATM(100, 100, 100)

  val expected = 100
  val result = atm.stored20Bills

  assertEquals(expected, result)
 }

 @Test
 fun getStored10Bills__receiveFieldValue() {
  val atm = ATM(100, 100, 100)

  val expected = 100
  val result = atm.stored10Bills

  assertEquals(expected, result)
 }

 @Test
 fun getLast50BillsGiven__receiveFieldValue() {
  val atm = ATM(100, 100, 100)

  val expected = 0
  val result = atm.last50BillsGiven

  assertEquals(expected, result)
 }

 @Test
 fun getLast20BillsGiven__receiveFieldValue() {
  val atm = ATM(100, 100, 100)

  val expected = 0
  val result = atm.last20BillsGiven

  assertEquals(expected, result)
 }

 @Test
 fun getLast10BillsGiven__receiveFieldValue() {
  val atm = ATM(100, 10, 100)

  val expected = 0
  val result = atm.last10BillsGiven

  assertEquals(expected, result)
 }

 /**** Functions ****/

 @Test
 fun processTakeoutOperation_amountHigherThan0_objectStateModifiedAndTrueReturned() {
  val atm = ATM(10, 10, 10)

  val result = atm.processTakeoutOperation(150)

  assertEquals(true, result)
  assertEquals(3, atm.last50BillsGiven)
  assertEquals(7, atm.stored50Bills)
  assertEquals(0, atm.last10BillsGiven)
  assertEquals(10, atm.stored20Bills)
  assertEquals(0, atm.last10BillsGiven)
  assertEquals(10, atm.stored10Bills)
 }

 @Test
 fun processTakeoutOperation_amountLowerThan0_IllegalArgumentException() {
  val atm = ATM(10, 10, 10)

  assertThrows<IllegalArgumentException> {atm.processTakeoutOperation(-150)}
 }

 @Test
 fun processTakeoutOperation_amountEqualTo0_IllegalArgumentException() {
  val atm = ATM(10, 10, 10)

  assertThrows<IllegalArgumentException> {atm.processTakeoutOperation(0)}
 }

 @Test
 fun processTakeoutOperation_amountIsHigherThanATMStoredAmount_falseReturned() {
  val atm = ATM(2, 0, 0)

  val result = atm.processTakeoutOperation(150)

  assertEquals(false, result)
 }

 @Test
 fun processTakeoutOperation_amountIsNotAMultipleOf10_falseReturned() {
  val atm = ATM(2, 0, 0)

  val result = atm.processTakeoutOperation(155)

  assertEquals(false, result)
 }

 @Test
 fun processTakeoutOperation_amountIsAMultipleOfATypeOfBillsThatIsNotAvailable_otherBillsUsedToReachAmountAndTrueReturned() {
  val atm = ATM(0, 2, 12)

  val result = atm.processTakeoutOperation(150)

  assertEquals(true, result)
  assertEquals(11, atm.last10BillsGiven)
  assertEquals(2, atm.last20BillsGiven)
  assertEquals(0, atm.last50BillsGiven)
  assertEquals(0, atm.stored50Bills)
  assertEquals(0, atm.stored20Bills)
  assertEquals(1, atm.stored10Bills)
 }
}


