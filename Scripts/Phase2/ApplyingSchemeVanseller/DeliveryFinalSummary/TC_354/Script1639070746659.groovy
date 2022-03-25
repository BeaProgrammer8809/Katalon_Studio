import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_03/TestData').getValue(2, 31)

println(GlobalVariable.SchemeBuySkuName)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.SchemeBuySkuName, 5)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_354_SummaryScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2/TY_03/TestData').getValue(
        4, 31), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def SRP_Price = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

println(SRP_Price)

def StockDeliveredQty = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

println(StockDeliveredQty)

def ActualTotalPrice = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

println(ActualTotalPrice)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 5'), 0)

Mobile.scrollToText('Create Final Invoice')

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

def ActualSchemeGetSKUPrice = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 
    0)

println(ActualSchemeGetSKUPrice)

def ExpectedSchemeGetSKUPrice = findTestData('Phase2/TY_03/TestData').getValue(7, 31)

println(ExpectedSchemeGetSKUPrice)

Mobile.verifyEqual(ActualSchemeGetSKUPrice, ExpectedSchemeGetSKUPrice, FailureHandling.STOP_ON_FAILURE)

println('Scheme Get SKU price is as expected')

def amount_Buy_SKU = Float.parseFloat(SRP_Price) * Integer.parseInt(StockDeliveredQty)

println(amount_Buy_SKU)

DecimalFormat df = new DecimalFormat('0.00')

amount_Buy_SKU = df.format(amount_Buy_SKU)

println(amount_Buy_SKU)

Mobile.verifyEqual(ActualTotalPrice, amount_Buy_SKU, FailureHandling.STOP_ON_FAILURE)

println('Total price is as expected as product of SRP and Stock delivered')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_354_DeliveryFinalSummaryScreen'], 
    FailureHandling.STOP_ON_FAILURE)

def SchemeGetSKUPrice = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), SchemeGetSKUPrice, 
    FailureHandling.STOP_ON_FAILURE)

println('Amount displayed for scheme Get SKU is : ' + SchemeGetSKUPrice)

Mobile.closeApplication()

