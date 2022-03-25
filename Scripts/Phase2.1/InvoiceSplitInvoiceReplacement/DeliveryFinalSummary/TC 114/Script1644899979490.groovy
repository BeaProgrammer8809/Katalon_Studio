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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
	'ProductName', 31)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
	'Phase2.1/Common_Data/CommonData').getValue('ProductName', 31)], FailureHandling.STOP_ON_FAILURE)


Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Inv_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

def Return_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),
	0)

def PB_Return_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),
	0)



Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/TY_01/TestData2').getValue(
	2, 81), 0)

def Invoice_Count = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println(Invoice_Count)

def Expecetd_Lines_Qty = Invoice_Count

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Stock_Delivery_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'),
0, FailureHandling.STOP_ON_FAILURE)

println(Stock_Delivery_Value)

def Partial_Stock_Value = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Partial_stock_Delivery_Value = Integer.parseInt(Stock_Delivery_Value) - Integer.parseInt(Partial_Stock_Value)

println(Partial_stock_Delivery_Value)

Mobile.verifyLessThan(Partial_stock_Delivery_Value, Stock_Delivery_Value, FailureHandling.STOP_ON_FAILURE)

println('Partial stock delivered qty is entered in Extra invoice field')

Mobile.setText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), Partial_stock_Delivery_Value.toString(),
0, FailureHandling.STOP_ON_FAILURE)

def After_Stock_Delivery_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'),
	0, FailureHandling.STOP_ON_FAILURE)

println(After_Stock_Delivery_Value)



Mobile.tap(findTestObject('Object Repository/Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)


Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'),
	0, FailureHandling.STOP_ON_FAILURE)

println('Delivery final summary screen is displayed')

def After_Return_Pieces_Value = Integer.parseInt(Return_Pieces_Value) + Integer.parseInt(After_Stock_Delivery_Value)

println(After_Return_Pieces_Value)

def After_Inv_Pieces_Value = Integer.parseInt(Inv_Pieces_Value) - Integer.parseInt(After_Stock_Delivery_Value)

println(After_Inv_Pieces_Value)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def Actual_Sku_Qty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(Actual_Sku_Qty1, After_Return_Pieces_Value.toString(), false, FailureHandling.STOP_ON_FAILURE)

println('SKUs qty  against Invoice split displayed correctly as that of the input')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def Actual_Sku_Qty2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(Actual_Sku_Qty2, After_Inv_Pieces_Value.toString(), false, FailureHandling.STOP_ON_FAILURE)

println('SKUs qty  against Extra Invoice displayed correctly as that of the input')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

def Actual_Sku_Qty3 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.verifyMatch(Actual_Sku_Qty3, PB_Return_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)

println('SKUs qty  against Prodbuy split displayed correctly as that of the input')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_114'], 
    FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()

