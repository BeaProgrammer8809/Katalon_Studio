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

'1st SKU Piece'
txtPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtPiecesValue)

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

txtAfterOkPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
    0)

println(txtAfterOkPiecesValue)

Mobile.verifyMatch(txtEnteredPiecesValue, txtAfterOkPiecesValue, false)

Mobile.verifyNotMatch(txtPiecesValue, txtAfterOkPiecesValue, false)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

'1st SKU Returns'
txtReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnsValue)

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

println('1st Piece Value: ' + txtAfterOkPiecesValue)

println('1st Returns Value: ' + txtAfterEnterReturnsValue)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

'2nd SKU Piece'
txtSecondPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

println(txtSecondPiecesValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

txtSecondEnteredPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtSecondEnteredPiecesValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtSecondEnteredPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondProduct_Pieces'), 
    0)

println(txtSecondEnteredPiecesValue)

Mobile.verifyMatch(txtSecondEnteredPiecesValue, txtSecondEnteredPiecesValue, false)

Mobile.verifyNotMatch(txtSecondPiecesValue, txtSecondEnteredPiecesValue, false)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

'2nd SKU Returns'
txtSecondReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondReturns Value'), 
    0)

println(txtSecondReturnsValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondReturns Value'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/004_num_2'), 
    0)

txtSecondEnteredReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtSecondEnteredReturnValue)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

txtSecondAfterEnterReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/secondReturns Value'), 
    0)

println(txtSecondAfterEnterReturnsValue)

Mobile.verifyMatch(txtSecondEnteredReturnValue, txtSecondAfterEnterReturnsValue, false)

Mobile.verifyNotMatch(txtSecondReturnsValue, txtSecondAfterEnterReturnsValue, false)

println('1st Piece Value: ' + txtAfterOkPiecesValue)

println('1st Returns Value: ' + txtAfterEnterReturnsValue)

println('2nd Piece Value: ' + txtSecondEnteredPiecesValue)

println('2nd Returns Value: ' + txtSecondAfterEnterReturnsValue)

int firstPiece = Integer.parseInt(txtAfterOkPiecesValue)

int firstReturn = Integer.parseInt(txtAfterEnterReturnsValue)

int secondPiece = Integer.parseInt(txtSecondEnteredPiecesValue)

int secondReturn = Integer.parseInt(txtSecondAfterEnterReturnsValue)

int calculationPieces = firstPiece + secondPiece

println(calculationPieces)

int calculationReturns = firstReturn + secondReturn

println(calculationReturns)

String calculatedPiecesValue = calculationPieces.toString()

println(calculatedPiecesValue)

String calculatedReturnsValue = calculationReturns.toString()

println(calculatedReturnsValue)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

txtTotalQty = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/bottomTotalQtyValue'), 
    0)

println(txtTotalQty)

Mobile.verifyMatch(calculatedPiecesValue, txtTotalQty, false, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyMatch(calculatedPiecesValue, txtTotalQty, false, FailureHandling.STOP_ON_FAILURE)) {
    println('Calculated SKU1 & SKU2 Pieces Value is same: ' + calculatedPiecesValue)

    println('SKU1 & SKU2 Pieces Value is same: ' + txtTotalQty)

    println(('Return qty ' + calculatedReturnsValue) + ' should not be considered' //add screenshot
        )
} else {
    FailureHandling.STOP_ON_FAILURE
}

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_032'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

