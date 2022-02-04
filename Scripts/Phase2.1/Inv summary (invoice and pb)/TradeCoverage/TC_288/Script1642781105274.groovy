import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

'need to check which product to be Placed\r\n\r\nDel this cmt'
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

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

invoiceAmountValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(invoiceAmountValue + 'invoiceAmountValue')

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)

'Capturing Balance Text view '
def Balance_txt1 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt1 + 'Bal_txt ')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_288_Checque Radiomode'] , FailureHandling.STOP_ON_FAILURE)
'Selecting Checque Radio Btn '
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), 0)

def invamt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

println(invamt.length())

for (int i = 0; i < invamt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

'Capturing Balance Text view '
def Balance_txt2 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt2 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt2, Balance_txt1, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'),
	[('testCaseName') : 'TC_288_TransferenciasElectronicasmode'] , FailureHandling.STOP_ON_FAILURE)
'Selecting Transferencias Electronicas Radio Btn '
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), 0)

def invamt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

println(invamt1.length())

for (int i = 0; i < invamt1.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

'Capturing Balance Text view '
def Balance_txt3 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt3 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt3, Balance_txt1, false, FailureHandling.STOP_ON_FAILURE)

'###############'
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'),
	[('testCaseName') : 'TC_288_creditNoteMode'] , FailureHandling.STOP_ON_FAILURE)
'Selecting creditNote Radio Btn '
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

'Capturing Balance Text view '
def Balance_txt4 = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Balance_TextView'), 0)

println(Balance_txt4 + 'Bal_txt ')

Mobile.verifyMatch(Balance_txt4, Balance_txt1, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()