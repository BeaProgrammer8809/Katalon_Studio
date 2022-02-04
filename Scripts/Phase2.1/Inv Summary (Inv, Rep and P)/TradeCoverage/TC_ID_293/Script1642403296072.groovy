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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 8)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 
    0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

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

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

def v1 = Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

println('Is screen title displayed as Summary? ' + v1)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def expectedInvAmt = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

def totalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println('Total price included for sku is ' + totalPrice)

Mobile.verifyEqual(totalPrice, expectedInvAmt, FailureHandling.STOP_ON_FAILURE)

println('Invoice amount is zero for product buying qty')

def valuePrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println('Value price for sku is ' + valuePrice)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_293_SummaryScreen'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioNo._EditText_Indexing'), 
    findTestData('Phase2/Common_Data/CommonData_03').getValue(15, 1), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def invoiceCreatedMsg = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 
    0)

println('Invoice message ' + invoiceCreatedMsg)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 
    0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_293_printScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

