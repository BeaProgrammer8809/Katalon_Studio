import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 22)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def U_Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_U.Price_Value'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Amount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println(Actual_Amount)

println('IEPS tax is not applied in Amount field when detail IEPS flag is enabled for the retailer')

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Do_You_Want_To_Print_Invoicing_Without_Preticket_OK_Button'), 
    0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)

def Print_Preview_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def Invoice_Sheet_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

println(Invoice_Sheet_Text)

def IEPS = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(17, 98)

println(IEPS)

boolean Actual_IEPS_TAX = Invoice_Sheet_Text.contains(IEPS)

println(Actual_IEPS_TAX)

//Verification of  Tax in Print Preview screen
Mobile.verifyMatch(Actual_IEPS_TAX.toString(), findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(20, 81), false, FailureHandling.STOP_ON_FAILURE)

println('IEPS Tax is added and displayed in IEPS Tax section as expected')

def Discount = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(16, 98)

println(Discount)

boolean Actual_Discount = Invoice_Sheet_Text.contains(Discount)

println(Actual_Discount)

Mobile.verifyGreaterThan(U_Price_Value, Actual_Amount, FailureHandling.STOP_ON_FAILURE)

println('IEPS tax is included in Unit price of the sku(SRP) in Product buying screen')

//Verification of Discount in Print Preview screen
Mobile.verifyMatch(Actual_Discount.toString(), findTestData('Phase2.1/TY_04/Phase2.1_Sheet2').getValue(20, 81), false, FailureHandling.STOP_ON_FAILURE)

println('Discount is added and displayed in Discount section as expected')

def Expected_Discount = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(18, 98)

def Tax = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(19, 98)

def Expected_Amount = Double.parseDouble(U_Price_Value) - Double.parseDouble(Expected_Discount) + Double.parseDouble(Tax)

println(Expected_Amount)

DecimalFormat df = new DecimalFormat('0.00')

Expected_Amount = df.format(Expected_Amount)

println(Expected_Amount)

Mobile.verifyMatch(Actual_Amount, Expected_Amount, false, FailureHandling.STOP_ON_FAILURE)

println('In print review page both Discount as well as Tax applied')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/ProductBuyingDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC60'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

