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

Mobile.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), '1', 0)

return_qty = Mobile.getAttribute(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), 'text', 0)

println(return_qty)

orderandInvoice_SRP = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and Invoice SRP'), 0)

println(orderandInvoice_SRP)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    'Summary')

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - i - image'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Amount Split up Pop-up/Text - Amount split up'), 
    0)

total_Value = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Amount Split up Pop-up/Total - value'), 
    0)

Mobile.verifyMatch(total_Value, '0', false)

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/only Inv and Rep/Screenshot'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

