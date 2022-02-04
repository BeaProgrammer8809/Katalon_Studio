import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.DecimalFormat as DecimalFormat
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To Click on Search Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To click on Search Button in product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

'To tap on Search Edit Text field in Product Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

'To set the SKU name in Search Edit Text field of product buying screen'
Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 30), 0)

'To tap on Total_Pieces Qty '
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

'To Select DropDown'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

'To slect Non_Sclable DD option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

'To tap on Pieces_Edit_Text option'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

'Setting the value for Piecs_Edit_Text '
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_3'), 0)

'Tapping on OK button'
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'To tap on Done Button in Product_Buying_Return Screen'
Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

//to get Gross amt
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def GrossAmount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(GrossAmount + 'Gross Amount String View')

double Amount1 = Double.parseDouble(GrossAmount)

def AmtDisplayed1 = Amount1.round(1)

//
// to fetch the Vlaue in summary screen
Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

def valueDisplayed = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(valueDisplayed + 'Value displayed in summary screen string format')

double Amount = Double.parseDouble(valueDisplayed)

def AmtDisplayed = Amount.round(1)

println(AmtDisplayed + 'Value Displayed in Summery Screen Double Format')

println(Amount + 'Value Displayed in Summery Screen Double Format')

//
Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'To verify Collection title'
Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), findTestData('Phase2.1/TY_13/Inv summary (invoice and pb)').getValue(
        3, 10))

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), valueDisplayed)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), valueDisplayed)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.verifyElementChecked(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

//Mobile.verifyElementChecked(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)
Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

'To Check if the keypad with numbers and digits Exist'
Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0)

def ExepctedBalancetxt = findTestData('Phase2.1/TY_13/Inv summary (invoice and pb)').getValue(3, 11) + AmtDisplayed

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), ExepctedBalancetxt, 
    FailureHandling.STOP_ON_FAILURE)

def TotalPaidAmttxt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

println(TotalPaidAmttxt + '---TotalpaidObjectTextView')

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), 0)

def tottxt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), 0)

println(tottxt + '-----Object Text ')

def ExpectedTotalPaid = findTestData('Phase2.1/TY_13/Inv summary (invoice and pb)').getValue(3, 12) + valueDisplayed

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), ExpectedTotalPaid)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_276CollectionScreen'], 
    FailureHandling.STOP_ON_FAILURE)

println('All the Expected Fields are Displayed and balance and total paid fields are displayed properly')

Mobile.closeApplication()

