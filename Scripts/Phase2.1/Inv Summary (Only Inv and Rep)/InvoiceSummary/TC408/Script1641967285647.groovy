import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Expected_Piece_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0, FailureHandling.STOP_ON_FAILURE)

//Verification to check in Effectivo mode
def Actual_Inv_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Expected_Total_Paid_Field = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

//Verification to check Total paid is displaying the amount entered in Total paid field in Effectivo mode.
def Effectivo_Actual_Total_Paid_Field = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

DecimalFormat df = new DecimalFormat('0.00')

Effectivo_Total_Paid_Field1 = df.format(Float.parseFloat(Effectivo_Actual_Total_Paid_Field))

def Effectivo_Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Effectivo_amount = Effectivo_Actual_Total_Amt.split(':')

def Effectivo_Amount = Effectivo_amount[1]

def Effectivo_Expected_Total_Amt = Effectivo_Amount.replace(' ', '')

Mobile.verifyMatch(Effectivo_Total_Paid_Field1, Effectivo_Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Efectivo_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

println(Effectivo_Total_Paid_Field1)

//Verification in Cheque mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Cheque_Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Cheque_amount = Cheque_Actual_Total_Amt.split(':')

def Cheque_Amount = Cheque_amount[1]

def Cheque_Expected_Total_Amt = Cheque_Amount.replace(' ', '')

Mobile.verifyMatch(Effectivo_Expected_Total_Amt, Cheque_Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Cheque_Radio_Button'], FailureHandling.STOP_ON_FAILURE)

//Verification in Transferencias Electronicas mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Transferencias_Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Transferencias_amount = Transferencias_Actual_Total_Amt.split(':')

def Transferencias_Amount = Transferencias_amount[1]

def Transferencias_Expected_Total_Amt = Transferencias_Amount.replace(' ', '')

Mobile.verifyMatch(Effectivo_Expected_Total_Amt, Transferencias_Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Transferencias_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

//Verification in Credit_code mode
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

def Credit_code_Actual_Total_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

def Credit_code_amount = Credit_code_Actual_Total_Amt.split(':')

def Credit_code_Amount = Credit_code_amount[1]

def Credit_code_Expected_Total_Amt = Credit_code_Amount.replace(' ', '')

Mobile.verifyMatch(Effectivo_Expected_Total_Amt, Credit_code_Expected_Total_Amt, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check whether Total paid is getting updated based on the amount entered in Total paid field
Mobile.verifyLessThan(Expected_Total_Paid_Field, Actual_Inv_Amt, FailureHandling.STOP_ON_FAILURE)

//Verification to check the pieces values
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC408_Credit_Code_Radio_Button'], 
    FailureHandling.STOP_ON_FAILURE)

println('By default the Total paid field is updated with full Invoice amount hence the Balance is displayed as 0 of Inv amount')

Mobile.closeApplication()

