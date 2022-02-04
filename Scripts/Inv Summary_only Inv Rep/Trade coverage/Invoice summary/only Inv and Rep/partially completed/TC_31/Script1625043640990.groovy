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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Search Button'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Search textbox'), '002_')

Mobile.setText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - qty'), '1', 0)

sku_qty = Mobile.getAttribute(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - qty'), 'text', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    'Summary')

unit_Price = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - U.Price qty'), 
    0)

Total = (Integer.parseInt(sku_qty) * Integer.parseInt(unit_Price))

total_value = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - SKU Total Value'), 
    0)

Mobile.verifyMatch(total_value, Total, false)

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/only Inv and Rep/Screenshot'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

