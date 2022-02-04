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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def Total_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

def U_Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_U.Price_Value'), 0)

def Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Pieces_Value'), 0)

def Return_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Sales_Return_Value'), 
    0)

def Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_Price_ValueView'), 0)

//Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
def Exp_Value = Double.parseDouble(Price_Value) / Double.parseDouble(Pieces_Value)

println(Exp_Value)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def SRP_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0, 
    FailureHandling.STOP_ON_FAILURE)

println(SRP_Value)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 31), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 31), 0)

def Fst_ExtInv = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

println(Fst_ExtInv)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 'enabled', 
    findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(12, 25), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.verifyElementAttributeValue(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 'enabled', 
    findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(12, 25), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Sku_Qty = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

println(Sku_Qty)

def Total_Val = Double.parseDouble(SRP_Value) * Double.parseDouble(Sku_Qty)

println('Total_Val')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

def Amount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println(Amount)

//def Act_Value = Double.parseDouble(Sku_Qty) * Double.parseDouble(Amount)
//
//println(Act_Value)
Mobile.verifyLessThanOrEqual(Amount.toString(), Total_Val.toString(), FailureHandling.STOP_ON_FAILURE)

println('Column Amount contain Sum of line level SKUs Qty*SRP under ExtraInvoice1')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_171'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

