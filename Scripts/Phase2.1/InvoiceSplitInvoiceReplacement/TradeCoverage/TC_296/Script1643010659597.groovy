import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			'Username', 37), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue('Password', 37)],
	FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 29)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnterPiecesQuantity'), [('ProductName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 1)], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnterReturnQuantityC'), [('ProductName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/EnteringProductBuyingQuantity'), [('ProductName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 1), ('DropdownName') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'DropdownOption', 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.setText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_14/TestData').getValue(
		'Data2', 64), 0)

def folioNum = Mobile.getAttribute(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'),
	'text', 0)

def expectedFolioNum = findTestData('Phase2.1/TY_14/TestData').getValue('Data2', 64)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.setText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_14/TestData').getValue(
		'Data', 64), 0)

def ProctBuyfolioNum = Mobile.getAttribute(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'),
	'text', 0)

def expectedProductBuyFolioNum = findTestData('Phase2.1/TY_14/TestData').getValue('Data', 64)

Mobile.verifyMatch(folioNum, expectedFolioNum, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(ProctBuyfolioNum, expectedProductBuyFolioNum, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Preticket_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)

//Invoice should get generated with success status and Given “Folio No” & “Folio ProdBuy” input
def PrintPreviewTitle = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def expectedPrintPreviewTitle = findTestData('Phase2.1/TY_14/TestData').getValue('Title', 70)

Mobile.verifyMatch(PrintPreviewTitle, expectedPrintPreviewTitle, false, FailureHandling.STOP_ON_FAILURE)

def actualMessage = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println(actualMessage + 'actualMessage')

def expectedMessage = findTestData('Phase2.1/TY_14/TestData').getValue('Folio_Number', 73)

boolean MessageResult = actualMessage.contains(expectedMessage)

def verifytheToastMessage = MessageResult.toString()

Mobile.verifyMatch(verifytheToastMessage, findTestData('Phase2.1/TY_14/TestData').getValue('Data', 73), false, FailureHandling.STOP_ON_FAILURE)

def expectedMessage1 = findTestData('Phase2.1/TY_14/TestData').getValue('Data2', 73)

boolean MessageResult1 = actualMessage.contains(expectedMessage1)

def verifytheToastMessage1 = MessageResult1.toString()

Mobile.verifyMatch(verifytheToastMessage1, findTestData('Phase2.1/TY_14/TestData').getValue('Data', 73), false, FailureHandling.STOP_ON_FAILURE)

def onsitExpectedMessage = findTestData('Phase2.1/TY_14/TestData').getValue('Data1', 73)

boolean OnsitMessageResult = actualMessage.contains(onsitExpectedMessage)

def verifytheStatus = OnsitMessageResult.toString()

Mobile.verifyMatch(verifytheStatus, findTestData('Phase2.1/TY_14/TestData').getValue('Data', 73), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_296'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

