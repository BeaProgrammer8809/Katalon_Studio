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

not_run: Mobile.startApplication(GlobalVariable.apk_File, false)

not_run: CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login_1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/header_Trade Coverage'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

retailerName = findTestData('Phase 1/Surendran/Order and Invoice/Retailer Mapping').getValue(1, 1)

println(retailerName)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
    retailerName, 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Store Activities'), 
    0)

txtStoreActivities = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Store Activities'), 
    0)

println(txtStoreActivities)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.verifyElementAttributeValue(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    'text', 'Order and  Invoice', 0)

txtStoreActivities = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.verifyMatch('Order and  Invoice', txtStoreActivities, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/SA_Order and  Invoice'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

txtReturnsValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtReturnsValue)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

txtKeyPad = Mobile.getAttribute(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    'resource-id', 0)

println(txtKeyPad)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_018'], 
    FailureHandling.STOP_ON_FAILURE)

'018--> Check whether keypad is displaying while tapping on replacement (returns) field'
if (txtKeyPad.contains('typed_value')) {
    println('KeyPad is displayed ' //Add Screenshot
        )
}

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

txtEnteredReturns = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredReturns)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_020_01'], 
    FailureHandling.STOP_ON_FAILURE)

'TC_020--> Returns\' field should not be updated with entered quantity in keypad after clicking the cancel button'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_Cancel'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_Cancel'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtAfterCancelReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtAfterCancelReturnValue)

Mobile.verifyNotMatch(txtEnteredReturns, txtAfterCancelReturnValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(txtReturnsValue, txtAfterCancelReturnValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_020_02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/003_num_1'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/012_num_0'), 
    0)

txtEnteredReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/001_Total Value'), 
    0)

println(txtEnteredReturnValue)

'TC_019--> Seller should be able to enter only replacement (returns) qty alone for an sku and the entered qty should be displayed correctly'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/Keypad/btn_OK'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

txtAfterOkReturnValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Product Details/firstProduct_Returns'), 
    0)

println(txtAfterOkReturnValue)

Mobile.verifyNotMatch(txtReturnsValue, txtAfterOkReturnValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(txtEnteredReturnValue, txtAfterOkReturnValue, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_019'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

