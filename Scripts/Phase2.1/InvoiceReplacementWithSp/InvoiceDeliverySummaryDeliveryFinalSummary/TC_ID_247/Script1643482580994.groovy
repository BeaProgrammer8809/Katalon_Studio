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

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_247_Actual_Pieces_&_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
def Net_Amount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_247_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//Verification to check that Delivery final screen is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_247_Delivery_Final_Screen'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

//Verification to check that Efectivo mode is selected
Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_247_EFectivo_Mode_Selected'], FailureHandling.STOP_ON_FAILURE)

def Actual_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
def Amount=Actual_Amt.split(' ')
def Actual_Amt1 = Amount[0]
DecimalFormat df = new DecimalFormat('0.00')
Actual_Min_Amt = df.format(Float.parseFloat(Actual_Amt1))

//Verification to check that Invoice amount is displaying the Net amount in summary screen
Mobile.verifyMatch(Net_Amount, Actual_Min_Amt, false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_247_Minimum_&_Net_Amount_Are_Same'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice qty and Return Qty 
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()