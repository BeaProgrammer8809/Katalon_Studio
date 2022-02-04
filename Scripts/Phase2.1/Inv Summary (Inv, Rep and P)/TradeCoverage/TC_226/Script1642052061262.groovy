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
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 
    0)

//clearing amount in effectivo mode
def invamt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

println(invamt1.length())

for (int i = 0; i < (invamt1.length() + 1); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

'Capturing INVOICE Amount'
def InvAmt_txt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(InvAmt_txt)

double invoiceAmt = Double.parseDouble(InvAmt_txt)

println(invoiceAmt + 'invoiceAmt ')

'Capturing Total paid Text view '
def TotalPaid_txt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), 
    0)

println(TotalPaid_txt)

def Tot_paid_txt = TotalPaid_txt.substring(13, TotalPaid_txt.length())

println(Tot_paid_txt + 'Tot_paid_txt')

double Tot_paidVal = Double.parseDouble(Tot_paid_txt)

println(Tot_paidVal + 'Tot_paid_txt ')

'Calculating the invoiceAmt - TotalPaid_txt'
diffrence = (invoiceAmt - Tot_paidVal)

int diff = diffrence.toInteger()

println(diff)

'Capturing Balance Text view '
def Balance_txt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 
    0)

println(Balance_txt1 + 'Bal_txt ')

ExpectedBaltxt = ((('Balance : ' + diff) + ' of ') + invoiceAmt)

println(ExpectedBaltxt + 'ExpectedBaltxt')

Mobile.verifyMatch(Balance_txt1, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_226'], FailureHandling.STOP_ON_FAILURE)

'cheques'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

'Capturing Balance Text view '
def Balance_txt2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt2 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt2, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_226'], FailureHandling.STOP_ON_FAILURE)

'effectivo'
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

'Capturing Balance Text view '
def Balance_txt3 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt3 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt3, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_226'], FailureHandling.STOP_ON_FAILURE)

'CreditNote'
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

'Capturing Balance Text view '
def Balance_txt5 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt5 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt5, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_226'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

