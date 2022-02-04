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

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 34)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 12)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 24)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 34)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

boolean isKeyboardShown = driver.isKeyboardShown();

def keyboardValue = isKeyboardShown.toString()

Mobile.verifyMatch(keyboardValue, findTestData('Phase2.1/TY_11/TestData').getValue(2, 87), false, FailureHandling.STOP_ON_FAILURE)



Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_009'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
