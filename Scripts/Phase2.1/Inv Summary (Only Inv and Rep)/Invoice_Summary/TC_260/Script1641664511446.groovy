import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 2), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

SIH = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

int SIH_Qty = SIH.toInteger()

Mobile.verifyGreaterThan(SIH_Qty, findTestData('Phase2.1/TY_12/InvoiceSummary/Invoice_Summary').getValue(5, 1))

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

qty1 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

int Qty1 = qty1.toInteger()

println(Qty1)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 3), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

SIH2 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0)

int SIH_Qty2 = SIH2.toInteger()

Mobile.verifyGreaterThan(SIH_Qty2, findTestData('Phase2.1/TY_12/InvoiceSummary/Invoice_Summary').getValue(5, 1))

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

//GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Total_Qty_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Total_Qty_Value'), 0)

int Total_Qty_Val= Integer.parseInt(Total_Qty_Value)
println(Total_Qty_Val)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Invoice_Summary/Screenshot'), [('testCaseName') : 'TC_257'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Total_Qty_Value'), 0)

Mobile.verifyMatch(Total_Qty_Val, Qty1, false)

println('Total qty field of invoiced skus count as 1')

Mobile.closeApplication()

