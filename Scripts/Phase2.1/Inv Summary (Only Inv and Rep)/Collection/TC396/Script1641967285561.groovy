import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 2)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		6, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC396_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC396_Expected_Piece_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check  1. Title is shown as Collection
def Actual_Collection_Title = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC396_Collection_Title'], FailureHandling.STOP_ON_FAILURE)

def Expected_Collection_Title = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 9)

Mobile.verifyMatch(Actual_Collection_Title, Expected_Collection_Title, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check 2. Inv Amt, Min Amt details is displayed.
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check Credit note, Pesito credit, Efectivo, Cheques, Transferencias Electronicas is be available but Efectivo is selected as default.
//Verification of CreditNote radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification of PesitoCredit radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'),
	0, FailureHandling.STOP_ON_FAILURE)

//Verification of Effectivo radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification of Cheque radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification of TransferenciasElectronicas radio button
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'),
	0, FailureHandling.STOP_ON_FAILURE)

//Verification to check Efectivo is selected as default.
Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 'selected',
	0, FailureHandling.STOP_ON_FAILURE)

println('Defaultly Effectivo mode is selected')

//Verification to check 4. Balance: X of XXX amount is display based on amount entered in Total paid field.
def Actual_Inv_Amount = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
DecimalFormat df = new DecimalFormat('0.00')
Actual_Inv_Amt3 = df.format(Float.parseFloat(Actual_Inv_Amount))
println(Actual_Inv_Amt3)

for (int i = 0; i <=Actual_Inv_Amt3.length(); i++)
{
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}


//def Actual_Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
//DecimalFormat df = new DecimalFormat('0.00')
//Actual_Inv_Amt1 = df.format(Float.parseFloat(Actual_Inv_Amt))
//
////Verification to check Balance: 0 of Inv amount is display
//def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
//def Balance = Actual_Balance_Amt.split(Actual_Inv_Amt)
//def New_Balance = Balance[0]
//def Expected_Balance_Amt = New_Balance + Actual_Inv_Amt
//println(Expected_Balance_Amt)
//Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt, false)


def Actual_Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
def Balance = Actual_Balance_Amt.split(Actual_Inv_Amt)
println Balance
def New_Balance = Balance[0]
println New_Balance
def Expected_Balance_Amt = New_Balance + Actual_Inv_Amt +" "+ "of" + " " + Actual_Inv_Amount
println(Expected_Balance_Amt)

Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt, false)
println(Actual_Balance_Amt)


//Verification to check 5. Total paid is displaying the amount entered in Total paid field.
def Actual_Total_Paid_Field = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),
	0, FailureHandling.STOP_ON_FAILURE)

DecimalFormat df1 = new DecimalFormat('0.00')

Actual_Total_Paid_Field1 = df1.format(Float.parseFloat(Actual_Total_Paid_Field))

def Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),
	0, FailureHandling.STOP_ON_FAILURE)

def amount = Actual_Total_Amt.split(':')
def Amount = amount[1]
def Expected_Total_Amt = Amount.replace(' ', '')

Mobile.verifyMatch(Actual_Total_Paid_Field, Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

println(Actual_Total_Amt)

//Verification to check 6. Total paid field should be filled with the Invoice amount as default
def Actual_Inv_Amt2 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),
	0, FailureHandling.STOP_ON_FAILURE)

def Actual_Total_Paid_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),
	0, FailureHandling.STOP_ON_FAILURE)

Actual_Inv_Amt2.contains(Actual_Total_Paid_Amt)

//Verification to check  7. Key pad that allows to enter only numbers and decimal should display.
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

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'),
	30, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC396_Elements_Verification'],
	FailureHandling.STOP_ON_FAILURE)

//Verification to check the pieces values
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()