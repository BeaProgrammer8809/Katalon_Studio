import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_323'], 
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

def TotalOrderValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Price_ValueView'), 0)
def Actual_Value_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def Comp_Discount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'),0)
def splitTotal = Comp_Discount.split(' ')
Comp_Discount = (splitTotal[1])

KeywordUtil.logInfo ("${Comp_Discount}")
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_318'],FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

//Total price value of an SKU
def totalPrice =  Double.parseDouble(Pieces_Value) * Double.parseDouble(U_Price_Value)
KeywordUtil.logInfo ("${totalPrice}")

//Item discount
//def ItemdiscountinWeb = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 256)
def ItemdiscountinWeb = findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(7, 96)
KeywordUtil.logInfo ("${ItemdiscountinWeb}")

//Category Discount
//def categorydiscountinWeb = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(6, 256)
def categorydiscountinWeb = findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(6, 96)
KeywordUtil.logInfo ("${categorydiscountinWeb}")

def ItemDiscount =  totalPrice * (Double.parseDouble(ItemdiscountinWeb)/100)
KeywordUtil.logInfo ("${ItemDiscount}")

def PriceafterItemDiscount = totalPrice - ItemDiscount
KeywordUtil.logInfo ("${PriceafterItemDiscount}")

def CategoryDiscount = PriceafterItemDiscount * (Double.parseDouble(categorydiscountinWeb)/100)
KeywordUtil.logInfo ("${CategoryDiscount}")

//Actual Category and Item Discount calculation
def PriceAfterAddingDiscount = PriceafterItemDiscount - CategoryDiscount
def TotalDiscount = ItemDiscount + CategoryDiscount

KeywordUtil.logInfo ("${TotalDiscount}")

DecimalFormat df = new DecimalFormat('0.00')
TotalDiscount=df.format(TotalDiscount)

Mobile.verifyMatch(TotalDiscount.toString(), Comp_Discount, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData(
        'Phase2.1/TY_04/Phase2.1_Sheet2').getValue(10, 61), 0)

//Mobile.setText(findTestObject('Object Repository/Phase2/BIEnterTheFolioNoPopup01/FolioProdBuy_EditText'), findTestData(
//	'Phase2.1/TY_04/Phase2.1_Sheet2').getValue(10, 61), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('Invoice created successfully')

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

def Print_Preview_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def Invoice_Sheet_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println Invoice_Sheet_Text
def IEPS = findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(16, 61)

//def IEPS_Value = IEPS+Value

println IEPS

boolean Actual_Number = Invoice_Sheet_Text.contains(IEPS)

println Actual_Number

//Verification of Folio number in Print Preview screen
Mobile.verifyMatch(Actual_Number.toString(),findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(20, 61), false,FailureHandling.STOP_ON_FAILURE)

println('IEPS Tax is added and displayed in IEPS Tax section')

boolean Actual_Number1 = Invoice_Sheet_Text.contains(TotalDiscount)
println Actual_Number1

//Verification to check the Discount in Print Preview screen is displayed same as in Calculated amount
Mobile.verifyMatch(Actual_Number1.toString(),findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(20, 56), false,FailureHandling.STOP_ON_FAILURE)
println('Discount is displayed in Discount section')


Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_323'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()