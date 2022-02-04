import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.sun.media.sound.DirectAudioDevice.DirectDL.Balance

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 4), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 3)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_223_Actual_Pieces_Value_And_Actual_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_223_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

def Efectivo_Amount1=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
for (int i = 0; i < Efectivo_Amount1.length(); i++)
{
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

//Verification to check that TransferenciasElectronicas_RadioButton is visible
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)
Mobile.verifyElementHasAttribute(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check that TransferenciasElectronicas_RadioButton is selected 
Mobile.verifyElementHasAttribute(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 'selected', 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check  1. Title is shown as Collection
def Actual_Collection_Title = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0)
def Expected_Collection_Title = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 100)
Mobile.verifyMatch(Actual_Collection_Title, Expected_Collection_Title, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check 2. Inv Amt, Min Amt details is displayed.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

//Verification to check 4. Balance: X of XXX amount is display based on amount entered in Total paid field.
def Actual_Inv_Amt3 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
DecimalFormat df = new DecimalFormat('0.00')
Actual_Inv_Amt3 = df.format(Float.parseFloat(Actual_Inv_Amt3))
println(Actual_Inv_Amt3)

for (int i = 0; i < 2; i++)
{
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

def Actual_Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
def Balance = Actual_Balance_Amt.split(' ')
def New_Balance = Balance[2]
def Expected_Balance_Amt = Actual_Inv_Amt + New_Balance

Mobile.verifyMatch(Actual_Inv_Amt3, Expected_Balance_Amt, false)

//Verification to check 5. Total paid is displaying the amount entered in Total paid field.
def Efectivo_Total_Paid_Field = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),0)
DecimalFormat df1 = new DecimalFormat('0.00')
Actual_Total_Paid_Field1 = df1.format(Float.parseFloat(Efectivo_Total_Paid_Field))
def Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),0)
def amount = Actual_Total_Amt.split(':')
def Amount = amount[1]
def Expected_Total_Amt = Amount.replace(' ', '')
Mobile.verifyMatch(Efectivo_Total_Paid_Field, Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check 6. Select Bank, Select Branch, Select Cheque drop down should be displayed.
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Select_Branch_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectChequeType_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check 7. Cheque number, Date, upload image should be present with submit button.
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Camera_Button'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check  8. Key pad that allows to enter only numbers and decimal should display.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/._NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/0_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/1_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/2_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/3_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/4_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/5_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/6_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/7_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/8_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/9_NumButton'), 30, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'),30, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_223_Display_Of_Transferencias_Electronicas_Modes'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the Invoice Qty, Return Qty and PB Qty
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(Actual_Return_Qty, Expected_Return_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()