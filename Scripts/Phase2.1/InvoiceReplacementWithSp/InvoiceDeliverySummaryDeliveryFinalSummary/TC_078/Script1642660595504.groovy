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

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			'Username', 5), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue('Password', 5)],
	FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnterReturnQuantityC'), [('ProductName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('ProductName', 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'),
	0)
/* verifying Replacement detail should not be displayed in Delivery Summary screen*/
Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/SRP_Text') , 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/SRP_Text') , 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_078'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

