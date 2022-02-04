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

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    findTestData('Phase 1/Anen/Inv Summary(Only PB)/Inv Summary(Only PB)').getValue('sihzero_sku', 1), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

txtSearchingProduct = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/listProductName'), 
    0)

println(txtSearchingProduct)

Mobile.hideKeyboard()

txtSIH = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/StockInHand'), 
    0)

println(txtSIH)

String sihLen = txtSIH.length()

println(sihLen)

if (sihLen == '1') {
    char[] digits1 = txtSIH.toCharArray()

    println(digits1[0])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    GlobalVariable.KeyValue = (digits1[0])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
        0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    txtAfterEnterValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    println(txtAfterEnterValue)

    Mobile.verifyMatch(txtSIH, txtAfterEnterValue, false)
}

if (sihLen == '2') {
    char[] digits1 = txtSIH.toCharArray()

    println(digits1[0])

    println(digits1[1])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    Mobile.delay(3)

    GlobalVariable.KeyValue = (digits1[0])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[1])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
        0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    txtAfterEnterValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    println(txtAfterEnterValue)

    Mobile.verifyMatch(txtSIH, txtAfterEnterValue, false)
}

if (sihLen == '3') {
    char[] digits1 = txtSIH.toCharArray()

    println(digits1[0])

    println(digits1[1])

    println(digits1[2])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    Mobile.delay(3)

    GlobalVariable.KeyValue = (digits1[0])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[1])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[2])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
        0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    txtAfterEnterValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    println(txtAfterEnterValue)

    Mobile.verifyMatch(txtSIH, txtAfterEnterValue, false)
}

if (sihLen == '4') {
    char[] digits1 = txtSIH.toCharArray()

    println(digits1[0])

    println(digits1[1])

    println(digits1[2])

    println(digits1[3])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    GlobalVariable.KeyValue = (digits1[0])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[1])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[2])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    GlobalVariable.KeyValue = (digits1[3])

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/KeyValue'), 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
        0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    txtAfterEnterValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Pieces'), 
        0)

    println(txtAfterEnterValue)

    Mobile.verifyMatch(txtSIH, txtAfterEnterValue, false)
}

Mobile.delay(3)

not_run: Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_086_01'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_100_01'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/btn_bottomNext'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/btn_Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_Invoice'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/btn_ICS_OK'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/btn_Create Ticket Invoice'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
        0)

    Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
        '123456', 0)

    Mobile.hideKeyboard()
}

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Do you want to print invoicing without preticket'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_OK'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Splitted Invoice Saved Successfully.'), 
    0)

not_run: Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_086_02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_100_02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_OK (1)'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/printPreview_BackArrow'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/Search icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Search/searchProductName'), 
    findTestData('Phase 1/Anen/Inv Summary(Only PB)/Inv Summary(Only PB)').getValue('008_SD_MUMB_PRO', 1), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Sku name 1st row - Copy'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Sku name 1st row - Copy'), 0)

not_run: Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_100'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_100'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

