import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 35)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(invAmt)

def minAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

println(minAmt)

def balanceAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0)

println(balanceAmt)

def totalPaidAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 0)

println(totalPaidAmt)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 'text', invAmt, 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 'text', minAmt, 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 'text', 
    balanceAmt, 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    'text', totalPaidAmt, 0)

println(' the value against Inv amt, Min Amt, Balance, Total Paid are 0(Zero) in collection popup')

Mobile.callTestCase(findTestCase('Phase2.1\\Inv Summary(Only PB)\\TradeCoverage/ScreenShot'), [('testCaseName') : 'TC_019_InvoiceSummary'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

