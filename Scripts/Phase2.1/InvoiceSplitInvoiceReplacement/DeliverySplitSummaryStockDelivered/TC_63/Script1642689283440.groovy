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
            6, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 21)], FailureHandling.STOP_ON_FAILURE)

def Expected_Invoice_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Total_Qty_Value'),0)

println(Expected_Invoice_Value)

def Replacement_Value = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

println(Replacement_Value)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            6, 18)], FailureHandling.STOP_ON_FAILURE)

def PB_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Lines_Qty'), 0, FailureHandling.STOP_ON_FAILURE)

println(PB_Value)

def IN_Re_PB_Value = (Integer.parseInt(Expected_Invoice_Value) + Integer.parseInt(Replacement_Value)) + Integer.parseInt(
    PB_Value)

println(IN_Re_PB_Value)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(
        24, 46), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/DeliverySplitSummary_Screen_Title'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('In Delivery Split Summary Screen')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Invoice_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

println(Actual_Invoice_Value)

Mobile.verifyMatch(Actual_Invoice_Value, Expected_Invoice_Value, false, FailureHandling.STOP_ON_FAILURE)

println('Stock delivered qty displaying only the invoice qty taken against each skus in order and invoice screen')

Mobile.verifyGreaterThan(IN_Re_PB_Value, Actual_Invoice_Value, FailureHandling.STOP_ON_FAILURE)

println('Replacement and product buying qty not consider in stock delivered qty')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/DeliverySplitSummaryInvoiceName/Screenshot'), 
    [('testCaseName') : 'TC_63'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()



