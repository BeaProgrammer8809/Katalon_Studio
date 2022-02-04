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
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_245_Actual_Pieces_&_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_245_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//Verification to check that Delivery final screen is displayed
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_245_Delivery_Final_Screen'], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox_Indexing'), 0)

def Actual_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
DecimalFormat df = new DecimalFormat('0.00')
Actual_Inv_Amt1 = df.format(Float.parseFloat(Actual_Amt))

def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
def Balance = Actual_Balance_Amt.split(Actual_Amt)
def New_Balance = Balance[0]
def Expected_Balance_Amt = New_Balance + Actual_Amt

def Actual_Collection_Title_Text = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0)
def Expected_Collection_Title_Text = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 122)

def Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),0)
def amount = Actual_Total_Amt.split(':')
def Amount = amount[1]
def Expected_Total_Amt = Amount.replace(' ', '')

//Verification to check that 1. Title should be shown as Collection
Mobile.verifyMatch(Actual_Collection_Title_Text, Expected_Collection_Title_Text, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 2. Inv Amt, Min Amt details should be displayed.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 3. Efectivo, Cheques, Transferencias Electronicas, Credit Note modes should be available but Efectivo should be selected as default.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check that Efectivo is defaultly selected in cash mode  
Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 4. Balance:  amount should display based on amount entered in Total paid field.
Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt, false)

//Verification to check that 5. Total paid should display the amount entered in Total paid field.
Mobile.verifyMatch(Actual_Amt, Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 6. Total paid field should be filled with the Invoice amount as default
Mobile.verifyMatch(Actual_Inv_Amt1, Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that 7. Keypad that allows to enter only numbers and decimal should display.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/0_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/1_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/2_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/3_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/4_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/5_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/6_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/7_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/8_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/9_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/._NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_ID_245_Display_Of_Payment_CheckBox'], FailureHandling.STOP_ON_FAILURE)


//Verification to check the Invoice qty and Return Qty 
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()