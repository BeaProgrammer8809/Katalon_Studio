import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

txtReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnsValue)

'TC_031--> To check the Total qty field calculation if returns qty is entered for an single sku(Total qty should be 0 since replacement qty will not be considered in "Total qty" calculation)'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

txtEnteredReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredReturnValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

txtAfterEnterReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtAfterEnterReturnsValue)

Mobile.verifyMatch(txtEnteredReturnValue, txtAfterEnterReturnsValue, false)

Mobile.verifyNotMatch(txtReturnsValue, txtAfterEnterReturnsValue, false)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
    0)

txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
    0)

println(txtBottomTotalValue)

Mobile.verifyMatch('0', txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyMatch('0', txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE)) {
    //add Screenshot
    println('Replacement Qty is: ' + txtAfterEnterReturnsValue)

    println('Bottom Total Value is: ' + txtBottomTotalValue)

    println(((('Total qty should be ' + txtBottomTotalValue) + ' since replacement ') + txtAfterEnterReturnsValue) + '  qty will not be considered in "Total qty" calculation')
}

'TC_026-->  Check whether the Total value against each sku is displaying correctly if only returns qty is entered'
Mobile.delay(3)

txtPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtPiecesValue)

Mobile.verifyNotMatch(txtPiecesValue, txtAfterEnterReturnsValue, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

txtSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

println(txtSRPValue)

int piecesvalue = Integer.parseInt(txtPiecesValue)

println(piecesvalue)

float txtSRPValue1 = Float.parseFloat(txtSRPValue)

println(txtSRPValue1)

int totalCalculation = piecesvalue * txtSRPValue1

println(totalCalculation)

String calculatedSkuTotal = totalCalculation.toString()

println(calculatedSkuTotal)

txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
    0)

Mobile.verifyMatch(calculatedSkuTotal, txtBottomTotalValue, false)

'TC_026-->  Check whether the Total value against each sku is displaying correctly if only returns qty is entered End'
Mobile.verifyMatch('0', calculatedSkuTotal, false)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'TC_027--> Check whether the Total value against each sku is displaying correctly if both piece and returns qty is entered Start'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/007_num_5'), 
    0)

txtEnteredPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstSKU_Total'), 
    0)

println(txtTotalValue)

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

Mobile.verifyMatch(txtEnteredPiecesValue, txtAfterOkPiecesValue, false)

Mobile.verifyNotMatch(txtAfterEnterReturnsValue, txtAfterOkPiecesValue, false)

Mobile.verifyNotMatch('0', txtAfterEnterReturnsValue, false)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

txtSRPValue2 = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

println(txtSRPValue2)

int piecesvalue1 = Integer.parseInt(txtAfterOkPiecesValue)

println(piecesvalue1)

float txtSRPValue2 = Float.parseFloat(txtSRPValue2)

println(txtSRPValue2)

float totalCalculation1 = piecesvalue1 * txtSRPValue2

println(totalCalculation1)

String totCalValue1 = totalCalculation1.toString()

println(totCalValue1)

String[] splitValue1 = totCalValue1.split('\\.')

floatingChar1 = splitValue1[1].length()

println(floatingChar1)

if (floatingChar1 == 1) {
    String calculatedtotalValue1 = (((splitValue1[0]) + '.') + (splitValue1[1])) + 0

    println(calculatedtotalValue1)

    Mobile.verifyMatch(calculatedtotalValue1, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)
} else {
    println('Total Value is: ' + totCalValue1)

    'TC_027--> Check whether the Total value against each sku is displaying correctly if both piece and returns qty is entered Start'
    Mobile.verifyMatch(totCalValue1, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)
}

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_026_027_031'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

