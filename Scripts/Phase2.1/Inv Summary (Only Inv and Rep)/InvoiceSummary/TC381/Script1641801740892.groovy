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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 1002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 10)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

driver.toggleWifi()

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 4)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 23)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData(
		'Phase2.1/Common_Data/CommonData').getValue('Folio number', 1), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

def actualMessage = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println(actualMessage + 'actualMessage')

def expectedMessage = findTestData('Phase2.1/TY_01/Test_Data').getValue(4, 27)

boolean MessageResult = actualMessage.contains(expectedMessage)

def verifytheToastMessage = MessageResult.toString()

Mobile.verifyMatch(verifytheToastMessage, findTestData('Phase2.1/TY_01/Test_Data').getValue(6, 27), false, FailureHandling.STOP_ON_FAILURE)

println('Onsite Invoice is getting failure and UUID is not generated')

def PrintPreviewscreen = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0)

println(PrintPreviewscreen)

Mobile.verifyEqual(PrintPreviewscreen, findTestData('Phase2.1/TY_01/Test_Data').getValue(5, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_381'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()