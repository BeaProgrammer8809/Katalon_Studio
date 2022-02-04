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
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 65), 0)

def Invoice_Count = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println(Invoice_Count)

def Expecetd_Lines_Qty = Invoice_Count

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

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Lines_Qty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

Mobile.verifyMatch(Actual_Lines_Qty1, Expecetd_Lines_Qty, false, FailureHandling.STOP_ON_FAILURE)

println('Lines qty  against Invoice split displayed correctly as that of the input')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Actual_Lines_Qty2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

Mobile.verifyMatch(Actual_Lines_Qty2, Expecetd_Lines_Qty, false, FailureHandling.STOP_ON_FAILURE)

println('Lines qty  against Extra Invoice displayed correctly as that of the input')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

def Actual_Lines_Qty3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

Mobile.verifyMatch(Actual_Lines_Qty3, Expecetd_Lines_Qty, false, FailureHandling.STOP_ON_FAILURE)

println('Lines qty  against Prodbuy split displayed correctly as that of the input')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/DeliverySplitFinalSummary/Screenshot'), [('testCaseName') : 'TC_82'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

