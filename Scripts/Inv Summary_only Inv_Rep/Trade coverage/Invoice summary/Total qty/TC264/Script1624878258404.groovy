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

Mobile.clearText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), '1')

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - Edit'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Screen Header - Ordered'), 0)

Mobile.clearText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), '5')

updated_qty = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - Returns'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

total_qty = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Value - Total qty'), 0)

Mobile.verifyMatch(total_qty, updated_qty, false)

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/only Inv and Rep/Screenshot'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

