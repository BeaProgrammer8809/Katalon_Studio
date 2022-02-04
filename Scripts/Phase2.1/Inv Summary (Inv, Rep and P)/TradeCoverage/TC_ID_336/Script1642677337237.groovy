import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 42)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_336'], 
    FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

def Invoice_Qty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Value_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def Total_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

def U_Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_U.Price_Value'), 0)

def Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Pieces_Value'), 0)

def Return_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Sales_Return_Value'), 
    0)

def Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Price_ValueView'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def Comp_Discount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

def Product_Buying_Amount = Double.parseDouble(U_Price_Value) * Double.parseDouble(Pieces_Value)

println(Product_Buying_Amount)

def Tax_Diff_Amount = Double.parseDouble(Total_Value) - Double.parseDouble(Price_Value)

println(Tax_Diff_Amount)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData(
        'Phase2.1/TY_04/Phase2.1_Sheet2').getValue(10, 56), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

def Print_Preview_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def Invoice_Sheet_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println Invoice_Sheet_Text
def IEPS = findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(16, 56)

println IEPS

boolean Actual_Number = Invoice_Sheet_Text.contains(IEPS)

println Actual_Number

//Verification of Folio number in Print Preview screen
Mobile.verifyMatch(Actual_Number.toString(),findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(20, 56), false,FailureHandling.STOP_ON_FAILURE)

println('IEPS Tax is added and displayed in IEPS Tax section')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_336'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
