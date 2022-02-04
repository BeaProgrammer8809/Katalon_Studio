import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)


Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To click on Search Button in product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

'To tap on Search Edit Text field in Product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

'To set the SKU name in Search Edit Text field of product buying screen'
Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

'To tap on Total_Pieces Qty '
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

'To Select DropDown'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

'To slect Non_Sclable DD option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

'To tap on Pieces_Edit_Text option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

'Setting the value for Piecs_Edit_Text '
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

'Tapping on OK button'
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'To tap on Done Button in Product_Buying_Return Screen'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

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

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_297_EfectivoMode'] , FailureHandling.STOP_ON_FAILURE)
'Efectivo Mode Bal'
'Capturing Balance Text view '
def Balance_txt1 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt1 + 'Bal_txt ')

ExpectedBaltxt = ((('Balance : ' + diff) + ' of ') + invoiceAmt)

//Balance:0.0of123.93
println(ExpectedBaltxt + 'ExpectedBaltxt')

Mobile.verifyMatch(Balance_txt1, ExpectedBaltxt, false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_297_cheques'] , FailureHandling.STOP_ON_FAILURE)

'cheques'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

'Capturing Balance Text view '
def Balance_txt2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt2 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt2, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_297_TransferenciasElectronicas'] , FailureHandling.STOP_ON_FAILURE)
'Transferencias electronicas'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def Balance_txt3 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt3 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt3, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_297_creditnote'] , FailureHandling.STOP_ON_FAILURE)

'credit note'

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def Balance_txt4 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt4 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt4, ExpectedBaltxt, false, FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()