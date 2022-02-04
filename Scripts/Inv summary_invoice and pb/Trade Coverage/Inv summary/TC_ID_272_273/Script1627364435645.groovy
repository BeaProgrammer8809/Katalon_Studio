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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Home Screen/Menu Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search icon'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search field'), findTestData('Phase 1/Anen/Inv Summary(Only PB)/Inv Summary(Only PB)').getValue(
        'credit_retailer', 1), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/1st Seller Name'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Start Visit'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

not_run: Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search Input Field'), findTestData(
        'Phase 1/Anen/Inv summary_invoice and pb/Inv summary_invoice and pb').getValue('skuname', 1))

not_run: Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search Input Field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/skus').getValue(
        'sku_withoutdeduction', 1))

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/input_1st Row Piece'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Unit_price_Order&Invoice'
total_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Total Value value'), 0)

println(total_Value)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Product Buying Screen Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/skus').getValue(
        'sku_withoutdeduction', 1))

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

salable1 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

println(salable1)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

salable_Piece1 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

println(salable_Piece1)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Add another Reason  Quantity'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Non-Salable'), 0)

non_salable1 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Non-Salable'), 0)

println(salable1)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input 0'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/3'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

nonsalable_Piece1 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field 2 after Typing'), 
    0)

println(nonsalable_Piece1)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_272_273'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Done Button'), 0)

'PB Toal Value'
total_ValuePB = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Value amout'), 0)

println(total_ValuePB)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Edit Icon'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Edit Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Edit Icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

salable2 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

println(salable2)

non_salable2 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Non-Salable'), 0)

println(salable2)

salable_Piece2 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

println(salable_Piece2)

nonsalable_Piece2 = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field 2 after Typing'), 
    0)

println(nonsalable_Piece2)

Mobile.verifyMatch(salable1, salable2, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(non_salable1, non_salable2, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(salable_Piece1, salable_Piece2, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(nonsalable_Piece1, nonsalable_Piece2, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_272(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Done Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/skus').getValue(
        'sku_onlydiscount', 1))

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_273(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

