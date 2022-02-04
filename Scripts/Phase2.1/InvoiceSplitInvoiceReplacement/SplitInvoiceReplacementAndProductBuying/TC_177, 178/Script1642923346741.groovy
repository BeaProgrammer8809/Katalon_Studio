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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_2'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 2), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DD_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_3'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

'**********   Verification for TC_177   ******************************'
def InvoiceAmount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println(InvoiceAmount)

def INVAmount =Double.parseDouble(InvoiceAmount)

def InvAmountvalue = Math.round(INVAmount)

int ActualInvoiceAmount  = (int)InvAmountvalue

println ActualInvoiceAmount

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def productBuyingAmount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

println(productBuyingAmount)

Mobile.verifyGreaterThanOrEqual(productBuyingAmount, InvoiceAmount, FailureHandling.STOP_ON_FAILURE)

println(' Invoice amount is adjusted in product buying amount')



GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)

def CreditAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), 0)

println(CreditAmt)

def CreditAmount =Double.parseDouble(CreditAmt)

def CreditAmountvalue = Math.round(CreditAmount)

int ExceptedCreditAmount  = (int)CreditAmountvalue

println ExceptedCreditAmount


Mobile.verifyMatch(ActualInvoiceAmount.toString(), ExceptedCreditAmount.toString(), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'), 
    [('testCaseName') : 'TC_177'], FailureHandling.STOP_ON_FAILURE)

println('Balance amount is same as invoice amount')

'********************** Veification for TC_178 ************'
Mobile.comment('Veification for TC_178')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def CashAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

println(CashAmt)

Mobile.verifyMatch(CashAmt, findTestData('Phase2.1/TY_01/TestData2').getValue(4, 72), false, FailureHandling.STOP_ON_FAILURE)

println "Cash payment mode only 0 amount is  displayed"

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/SplitInvoiceReplacementAndProductBuying/Screenshot'), 
    [('testCaseName') : 'TC_178'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

