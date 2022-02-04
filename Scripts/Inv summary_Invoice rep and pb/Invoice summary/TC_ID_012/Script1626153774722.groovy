import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

skuName = findTestData('Phase 1/Surendran/Invoice Summary/Product Mapping').getValue(1, 2)

println(skuName)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    skuName, 0)

not_run: Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    '021_SD_MUMB_PRO', 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

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

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

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

println('Last Digit is Zero(0) First Product Total Is: ' + calculatedtotalValue)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_012_Order and Invoice'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_012_Summary'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/btn_Next'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/txtView_Header_Summary'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/txtView_Header_Summary'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_012_Product_Buying'], 
    FailureHandling.STOP_ON_FAILURE)

txtSummaryProductName = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/productName'), 0)

println(txtSummaryProductName)

txtSummaryPiecesValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/pcs_Qty'), 0)

println(txtSummaryPiecesValue)

txtSummaryUnitPriceValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/U.PriceValue'), 0)

println(txtSummaryUnitPriceValue)

txtProductTotalValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/productTotal'), 0)

println(txtProductTotalValue)

Mobile.verifyMatch(calculatedtotalValue, txtProductTotalValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/TotalQty_icon'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/lbl_Comp Disc'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/lbl_Comp Disc'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/lbl_Dist Disc'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/lbl_Dist Disc'), 0)

txtASPCompDisCountValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/Comp_Disc'), 
    0)

println(txtASPCompDisCountValue)

txtASPDistDiscount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/Dist_DiscountValue'), 
    0)

println(txtASPDistDiscount)

Mobile.verifyMatch('- 0', txtASPCompDisCountValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch('- 0', txtASPDistDiscount, false, FailureHandling.STOP_ON_FAILURE)

txtASPOrderValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/OrderValue'), 
    0)

println(txtASPOrderValue)

txtASPTotal = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Amount Split UP/TotalOrderValue'), 
    0)

println(txtASPTotal)

Mobile.verifyMatch(calculatedtotalValue, txtASPOrderValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(calculatedtotalValue, txtASPTotal, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

