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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

INVQTY = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

int invoiceqtyVal = Integer.parseInt(INVQTY)

println(invoiceqtyVal + 'invoiceqtyval')

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

PBQTY = Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

println(PBQTY)

int prodBqtyVal = Integer.parseInt(PBQTY)

println(prodBqtyVal)

Mobile.verifyLessThan(prodBqtyVal, invoiceqtyVal, FailureHandling.STOP_ON_FAILURE)

println('verifying productbuying is less than invoiceqtyVal')

'To tap on Done Button in Product_Buying_Return Screen'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/CreditNoteValue_Text'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/CreditNoteValue_Text')  , 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/CreditNoteValue_Text'), 0, FailureHandling.STOP_ON_FAILURE)
 
Creditnote_Val_TXT = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/CreditNoteValue_Text'),
	0)
Creditnote_Val_TXTSub = Creditnote_Val_TXT.substring(0,  20)
println(Creditnote_Val_TXTSub)


'Capturing INVOICE Amount'
def InvAmt_txt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(InvAmt_txt)

double invoiceAmt = Double.parseDouble(InvAmt_txt)

println(invoiceAmt + 'invoiceAmt ')

Creditnote_Data = (findTestData('Phase2.1/TY_12/Invsummary(invoiceandpb)/TradeCoverage/TradeCoverage').getValue(2, 1) +
invoiceAmt)

println(Creditnote_Data + 'Creditnote_Data')

Credit_Amount_Edit = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'),
	0)

println(Credit_Amount_Edit + 'Credit_Amount_Edit')

double CredAmt = Double.parseDouble(Credit_Amount_Edit).round(2)

println(CredAmt)

CreditNoteValueTxt = findTestData('Phase2.1/TY_12/Invsummary(invoiceandpb)/TradeCoverage/TradeCoverage').getValue(2, 1)

creditNoteTXT = (CreditNoteValueTxt )

println(creditNoteTXT + 'creditNoteTXT')


Mobile.verifyMatch(Creditnote_Val_TXTSub, CreditNoteValueTxt, false, FailureHandling.STOP_ON_FAILURE)

println('verifying the Credit Note Value ')

remainingAmt = (invoiceAmt - CredAmt).round(2)

println(remainingAmt + 'remainingAmt')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

EfectivoAmt_RemainingAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'),
	0)

println(EfectivoAmt_RemainingAmt + 'EfectivoAmt_RemainingAmt in txt')

double EffAmtRemainingAmt = Double.parseDouble(EfectivoAmt_RemainingAmt)

Mobile.verifyEqual(EffAmtRemainingAmt, remainingAmt, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_282'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

