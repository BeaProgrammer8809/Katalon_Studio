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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

def productName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), productName, 0)

'Provide order quantity'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def OrderQty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

double Order = Double.parseDouble(OrderQty)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), productName, 0)

'Provide Product Buying quantity'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIReturnProductBuyingScreen01/Return_Text-View'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

def PbqtyText = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

double Pbqty = Double.parseDouble(PbqtyText)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

'Capturing the required data'
def InvoiceQtyText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def SalesReturnQtyText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

double SalesReturnQty = Double.parseDouble(SalesReturnQtyText)

'Verifying Both Invoice and Pb quantity'
Mobile.verifyMatch(OrderQty, InvoiceQtyText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Pbqty, SalesReturnQty, FailureHandling.STOP_ON_FAILURE)

'Verifying Product return quantity less than order quantity'
Mobile.verifyGreaterThan(Order, SalesReturnQty, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

'Verifying on collection screen'
Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'), 0)

//Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'), findTestData(
//	'Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(2, 6))
def effectivoAmtText = Mobile.getText(findTestObject('/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)
int len=effectivoAmtText.length()

double effectivoAmt = Double.parseDouble(effectivoAmtText)



Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for(int i=0;i<=len;i++){
	
	Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}


Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

def pesitoAmtText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

Mobile.comment('Providing the full amount in effectivo mode')

Mobile.verifyMatch(effectivoAmtText, pesitoAmtText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_356(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

for(int i=0;i<=len;i++){
	
	Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

def partialAmtText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

double partialAmt = Double.parseDouble(partialAmtText)

'Verifying the amount entered in pesito was partial amount'
Mobile.verifyLessThan(partialAmt, effectivoAmt, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_356(2)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(
        2, 8), FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

