import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 6), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 21)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 9)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Only_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Actual_Pieces_&_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 21)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Actual_Pieces_&_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Only_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def  Actual_Amount2= findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 109)
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def Unit_Price = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),0)
def Order_Value= Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),0)
def Value= Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

double Actual_Order_Value = Integer.parseInt(Expected_Pieces_Value) * Double.parseDouble(Unit_Price)
double Discount = Actual_Order_Value - Double.parseDouble(Order_Value)
double Tax = Double.parseDouble(Value) - Double.parseDouble(Order_Value)
def Amount = Actual_Order_Value + Tax - Discount
DecimalFormat df = new DecimalFormat('0.00')
def Actual_Amount1 = df.format(Amount)
def Actual_Sku_Qty = Integer.parseInt(Expected_Only_Return_Qty)+Integer.parseInt(Expected_Pieces_Value)+Integer.parseInt(Expected_Return_Qty)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//Verification to check that Delivery final screen is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Delivery_Final_Screen'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Amount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)
def Expected_SKU_Qty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Amount2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)
def Expected_SKU_Qty2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

def Expected_SKU_Qty = Integer.parseInt(Expected_SKU_Qty1) + Integer.parseInt(Expected_SKU_Qty2)

//Verification to check that replacement qty is dsiaplyed in Delivery Final Summary screen
Mobile.verifyEqual(Actual_Sku_Qty, Expected_SKU_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Replacement_Qty_Is_Added'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Amount value displayed for Invoice and replacement
Mobile.verifyEqual(Actual_Amount1, Expected_Amount1, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Amount value displayed for replacement
Mobile.verifyEqual(Actual_Amount2, Expected_Amount2, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_232_Expected_Amount'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice qty and Return Qty 
Mobile.verifyEqual(Actual_Only_Return_Qty, Expected_Only_Return_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()