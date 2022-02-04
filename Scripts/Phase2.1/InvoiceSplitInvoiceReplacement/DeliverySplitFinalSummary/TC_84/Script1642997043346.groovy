import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Price_ValueView'), 0)

println(Price_Value)

def Total_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(Total_Value)

def Discount_Value = Double.parseDouble(Price_Value) - Double.parseDouble(Total_Value)

println(Discount_Value)

DecimalFormat df=new DecimalFormat("0.00")

Discount_Value=df.format(Discount_Value)

println(Discount_Value)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Stock_Value = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

println(Stock_Value)

def SRP_Value = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

println(SRP_Value)

def Expected_Total_Value = Double.parseDouble(Stock_Value) * Double.parseDouble(SRP_Value)

println(Expected_Total_Value)

DecimalFormat df1=new DecimalFormat("0.00")

Expected_Total_Value=df1.format(Expected_Total_Value)

println(Expected_Total_Value)

def Actual_Total_Value = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

println(Total_Value)

Mobile.verifyMatch(Expected_Total_Value.toString(), Actual_Total_Value, false, FailureHandling.STOP_ON_FAILURE)

println('Actual and Expected Total amount is equal')

def Expected_Amount_Value = Total_Value - Discount_Value

println(Expected_Amount_Value)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 67), 0)

def Invoice_Count = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println(Invoice_Count)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Stock_Delivery_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

println(Stock_Delivery_Value)

Mobile.setText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), Stock_Delivery_Value, 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Delivery final summary screen is displayed')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Actual_Amount_Value = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println(Actual_Amount_Value)

//def TotalPriceInOrderAndInvoiceScreen = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def Amount =Double.parseDouble(Expected_Amount_Value)

//def Amount =Double.parseDouble(TotalPriceInOrderAndInvoiceScreen)

def Amountvalue = Math.round(Amount)

//int PriceInOrderAndInvoicescreen  = (int)Amountvalue

int Actual_Total_Amount_Value  = (int)Amountvalue

//def UnitPriceInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def Pieces =Double.parseDouble(Actual_Amount_Value)

def piecesvalue = Math.round(Pieces)

//int UnitPriceValueInSummary  = (int)piecesvalue

int Expected_Total_Amount_Value = (int)piecesvalue

Mobile.verifyMatch(Actual_Total_Amount_Value.toString(), Expected_Total_Amount_Value.toString(), false,FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyMatch(PriceInOrderAndInvoicescreen.toString(), UnitPriceValueInSummary.toString(), false,FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyEqual(Actual_Amount_Value.toString(), Expected_Amount_Value.toString(), false, FailureHandling.STOP_ON_FAILURE)

println('Expected and Actual Amount value is equal')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/DeliverySplitFinalSummary/Screenshot'), [('testCaseName') : 'TC_84'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

