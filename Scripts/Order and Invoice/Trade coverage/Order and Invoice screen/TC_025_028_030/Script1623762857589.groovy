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

'TC_025--> Check whether the Total value against each sku is displaying correctly if only invoice qty is entered Start'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

not_run: Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/005_num_3'), 
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

txtReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnsValue)

Mobile.verifyNotMatch(txtAfterOkPiecesValue, txtReturnsValue, false, FailureHandling.STOP_ON_FAILURE)

int piecesvalue = Integer.parseInt(txtAfterOkPiecesValue)

println(piecesvalue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

txtSRPValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/SRP'), 
    0)

println(txtSRPValue)

float txtSRPValue1 = Float.parseFloat(txtSRPValue)

println(txtSRPValue1)

float totalCalculation = piecesvalue * txtSRPValue1

println(totalCalculation)

String totCalValue = totalCalculation.toString()

println(totCalValue)

String[] splitValue = totCalValue.split('\\.')

floatingChar = splitValue[1].length()

println(floatingChar)

if (floatingChar == 1) {
    String calculatedtotalValue = (((splitValue[0]) + '.') + (splitValue[1])) + 0

    println(calculatedtotalValue)

    Mobile.verifyMatch(calculatedtotalValue, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)

    'TC_028--> To check the Value field calculation if invoice is done for a single sku Start'
    Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2ndSKU_Total'), 
        0)

    txtSecondSKUTotal = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2ndSKU_Total'), 
        0)

    println(txtSecondSKUTotal)

    int secondTotalValue = Integer.parseInt(txtSecondSKUTotal)

    println(secondTotalValue)

    float convertFirstTotal = Float.parseFloat(calculatedtotalValue)

    println(convertFirstTotal)

    float calculatedTotalValue = convertFirstTotal + secondTotalValue

    println(calculatedTotalValue)

    String tcv = calculatedTotalValue.toString()

    println(tcv)

    String[] splitedValue = tcv.split('\\.')

    floatingChar1 = splitedValue[1].length()

    println(floatingChar1)

    if (floatingChar1 == 1) {
        String calculatedtotalValue1 = (((splitedValue[0]) + '.') + (splitedValue[1])) + 0

        println('Sum of SKU1 & SKU2 Total is: ' + calculatedtotalValue1)

        txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
            0)

        println(txtBottomTotalValue)

        'TC_028--> To check the Value field calculation if invoice is done for a single sku End'
        Mobile.verifyMatch(calculatedtotalValue1, txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE //Add ScreenSort
            //Add ScreenSort
            )
    }
} else {
    println('Total Value is: ' + totCalValue)

    'TC_025--> Check whether the Total value against each sku is displaying correctly if only invoice qty is entered End'
    Mobile.verifyMatch(totCalValue, txtTotalValue, false, FailureHandling.STOP_ON_FAILURE)

    Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2ndSKU_Total'), 
        0)

    txtSecondSKUTotal = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/2ndSKU_Total'), 
        0)

    println(txtSecondSKUTotal)

    int secondTotalValue = Integer.parseInt(txtSecondSKUTotal)

    println(secondTotalValue)

    float convertFirstTotal = Float.parseFloat(totCalValue)

    println(convertFirstTotal)

    float calculatedTotalValue = convertFirstTotal + secondTotalValue

    println(calculatedTotalValue)

    String calculatedTotalValues = calculatedTotalValue.toString()

    println('Sum of SKU1 & SKU2 Total is: ' + calculatedTotalValues)

    txtBottomTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalValue'), 
        0)

    println('Bottom Value is: ' + txtBottomTotalValue)

    'TC_028--> To check the Value field calculation if invoice is done for a single sku End'
    Mobile.verifyMatch(calculatedTotalValues, txtBottomTotalValue, false, FailureHandling.STOP_ON_FAILURE)
}

Mobile.delay(3)

'TC_030--> To check the Total qty field calculation if piece qty is entered for an single sku Start'
txtFirstSKUPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtFirstSKUPiecesValue)

int firstSKUPiece = Integer.parseInt(txtFirstSKUPiecesValue)

println(firstSKUPiece)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

txtSecondSKUPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

println(txtSecondSKUPiecesValue)

int secondSKUPiece = Integer.parseInt(txtSecondSKUPiecesValue)

println(secondSKUPiece)

int ctq = firstSKUPiece + secondSKUPiece

println(ctq)

String calculatedTotalQty = ctq.toString()

println(calculatedTotalQty)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

txtBottomTotalQty = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

println(txtBottomTotalQty)

'TC_030--> To check the Total qty field calculation if piece qty is entered for an single sku End'
Mobile.verifyMatch(calculatedTotalQty, txtBottomTotalQty, false)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_025_028_030'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

