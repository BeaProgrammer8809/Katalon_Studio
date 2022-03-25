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

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC407_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC407_Expected_Piece_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0, FailureHandling.STOP_ON_FAILURE)

def Actual_Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < 2; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

//Verification to check Balance: 0 of Inv amount is displayed in Effectivo mode
def Actual_Balance_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC407_Amount_Verification'], FailureHandling.STOP_ON_FAILURE)

def Balance = Actual_Balance_Amt.split(Actual_Inv_Amt)

def New_Balance = Balance[0]

def Expected_Balance_Amt = New_Balance + Actual_Inv_Amt

Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt, false)

//Verification to check when invoice amount = 256.56, Total paid entered = 256 then Balance .56 of 256.56 is displayed
println(Expected_Balance_Amt)

//Verification to check Total paid is displaying the amount entered in Total paid field.
def Actual_Total_Paid_Field = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

DecimalFormat df = new DecimalFormat('0.00')

Actual_Total_Paid_Field1 = df.format(Float.parseFloat(Actual_Total_Paid_Field))

def Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def amount = Actual_Total_Amt.split(':')

def Amount = amount[1]

def Expected_Total_Amt = Amount.replace(' ', '')

Mobile.verifyMatch(Actual_Total_Paid_Field1, Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC407_Efectivo_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

//Verification to check Total paid displayed
println(Expected_Total_Amt)

//Verification to check Balance: 0 of Inv amount is displayed in Cheque mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Actual_Balance_Amt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Balance1 = Actual_Balance_Amt1.split(Actual_Inv_Amt)

def New_Balance1 = Balance1[0]

def Expected_Balance_Amt1 = New_Balance1 + Actual_Inv_Amt

Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt1, false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC407_Cheque_Radio_Button'], FailureHandling.STOP_ON_FAILURE)

//Verification to check when invoice amount = 256.56, Total paid entered = 256 then Balance .56 of 256.56 is displayed
println(Expected_Balance_Amt1)

//Verification to check Balance: 0 of Inv amount is displayed in Transferencias Electronicas mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Actual_Balance_Amt2 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Balance2 = Actual_Balance_Amt2.split(Actual_Inv_Amt)

def New_Balance2 = Balance2[0]

def Expected_Balance_Amt2 = New_Balance2 + Actual_Inv_Amt

Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt2, false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC407_Transferencias_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

//Verification to check when invoice amount = 256.56, Total paid entered = 256 then Balance .56 of 256.56 is displayed
println(Expected_Balance_Amt2)

//Verification to check Balance: 0 of Inv amount is displayed in  Credit code mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

def Actual_Balance_Amt3 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Balance3 = Actual_Balance_Amt3.split(Actual_Inv_Amt)

def New_Balance3 = Balance3[0]

def Expected_Balance_Amt3 = New_Balance3 + Actual_Inv_Amt

Mobile.verifyMatch(Actual_Balance_Amt, Expected_Balance_Amt3, false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC407_Credit_Code_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

//Verification to check when invoice amount = 256.56, Total paid entered = 256 then Balance .56 of 256.56 is displayed
println(Expected_Balance_Amt3)

//Verification to check the pieces values
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)

println('Balance XX of Inv amount is getting updated with respect to the amount entered in total paid field')

println('across in all modes (Efectivo, cheques, Transferencias electronicas, credit note')

Mobile.closeApplication()

