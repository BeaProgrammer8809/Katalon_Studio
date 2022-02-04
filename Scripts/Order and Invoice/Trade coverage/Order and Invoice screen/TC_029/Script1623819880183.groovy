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

txtSIH = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/StockInHand'), 
    0)

println(txtSIH)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/005_num_3'), 
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

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

txtSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

println(txtSRPValue)

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

int piecesvalue = Integer.parseInt(txtAfterOkPiecesValue)

println(piecesvalue)

float txtSRPValue1 = Float.parseFloat(txtSRPValue)

println(txtSRPValue1)

float totalCalculation = piecesvalue * txtSRPValue1

println(totalCalculation)

String totCalValue = totalCalculation.toString()

println(totCalValue)

String[] splitValue = totCalValue.split('\\.')

floatingChar = splitValue[1].length()

println(floatingChar)

String calculatedtotalValue

if (floatingChar == 1) {
    //First Product total
    calculatedtotalValue = ((((splitValue[0]) + '.') + (splitValue[1])) + 0)

    println(calculatedtotalValue)

    Mobile.verifyMatch(calculatedtotalValue, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)
} else {
    println('Total Value is: ' + totCalValue)

    Mobile.verifyMatch(totCalValue, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)
}

println('First Product Total Is: ' + totCalValue)

'1st Product SKU'
println('Last Digit is Zero(0) First Product Total Is: ' + calculatedtotalValue)

'2nd Product SKU\r\n'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

txtEnteredSecondPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredSecondPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txt2ndSKUTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2ndSKU_Total'), 
    0)

println(txt2ndSKUTotalValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2nd_Product SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2nd_Product SRP'), 
    0)

txt2ndSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2nd_Product SRP'), 
    0)

println(txt2ndSRPValue)

int secondPiecesValue = Integer.parseInt(txtEnteredSecondPiecesValue)

println(secondPiecesValue)

float txtSRPValue2 = Float.parseFloat(txt2ndSRPValue)

println(txtSRPValue2)

float totalCalculation1 = secondPiecesValue * txtSRPValue2

println(totalCalculation1)

String totCalValue1 = totalCalculation1.toString()

println(totCalValue1)

String[] splitValue1 = totCalValue1.split('\\.')

floatingChar2 = splitValue1[1].length()

println(floatingChar2)

String calculatedTotalValue1

if (floatingChar2 == 1) {
    //First Product total
    calculatedTotalValue1 = ((((splitValue1[0]) + '.') + (splitValue1[1])) + 0)

    println(calculatedTotalValue1)

    Mobile.verifyMatch(calculatedTotalValue1, txt2ndSKUTotalValue, false, FailureHandling.STOP_ON_FAILURE)
} else {
    println('Total Value is: ' + totCalValue1)

    Mobile.verifyMatch(totCalValue1, txt2ndSKUTotalValue, false, FailureHandling.STOP_ON_FAILURE)
}

println('First Product Total Is: ' + totCalValue)

'1st Product SKU'
println('Last Digit is Zero(0) First Product Total Is: ' + calculatedtotalValue)

println('Second Product Total Is: ' + totCalValue1)

'2st Product SKU'
println('Last Digit is Zero(0) Second Product Total Is: ' + calculatedTotalValue1)

String firstProductTotal = totCalValue

String secondProductTotal = totCalValue1

float firstProdcttotal

float secondProdcttotal

if (calculatedtotalValue == null) {
    println(firstProductTotal)

    firstProdcttotal = Float.parseFloat(firstProductTotal)

    println(firstProdcttotal)
} else {
    println(totCalValue)

    firstProdcttotal = Float.parseFloat(totCalValue)

    println(firstProdcttotal)
}

if (calculatedTotalValue1 == null) {
    println(secondProductTotal)

    secondProdcttotal = Float.parseFloat(secondProductTotal)

    println(secondProdcttotal)
} else {
    println(totCalValue1)

    secondProdcttotal = Float.parseFloat(secondProductTotal)

    println(secondProdcttotal)
}

println('First Product Total Value: ' + firstProdcttotal)

println('Second Product Total Value: ' + secondProdcttotal)

float sumOfSkuTotal = firstProdcttotal + secondProdcttotal

println(sumOfSkuTotal)

String calculatedSkuTotal = sumOfSkuTotal.toString()

println(calculatedSkuTotal)

String[] splittotalValue1 = calculatedSkuTotal.split('\\.')

floatingChar3 = splittotalValue1[1].length()

println(floatingChar3)

txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
    0)

println(txtBottomTotalValue)

String calculateSKUTotalValue

if (floatingChar3 == 1) {
    //sum of SKU1 and SKU 2 
    calculateSKUTotalValue = ((((splittotalValue1[0]) + '.') + (splittotalValue1[1])) + 0)

    println(calculateSKUTotalValue)

    Mobile.verifyMatch(calculateSKUTotalValue, txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE //add Screenshot
        ) //add Screenshot
} else {
    println('Calculated SKU1 and SKU2 Total Value is: ' + calculatedSkuTotal)

    Mobile.verifyMatch(calculatedSkuTotal, txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE)
}

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_029'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

