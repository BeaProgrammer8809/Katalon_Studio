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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

def productName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), productName, 0)

'Peovide Order quantity'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'Provide return quantity'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'Number', 1), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

def StockDeliveredQtyText = Mobile.getText(findTestObject('Phase2/BISplitDeliverySummary01/StockDelivered_Qty_Indexing'), 
    0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), StockDeliveredQtyText, 0)

Mobile.delay(2)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
        2, 3))

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_263'], FailureHandling.STOP_ON_FAILURE)

def invAmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)



def Efectivo_Amt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def CreditNote_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'),
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def TransferenciasElectronicas_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

def Cheque_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'),
	0)

def Cheque_Total_Paid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),
	0)

def splitTotal = Cheque_Total_Paid.split(' ')

Cheque_Total_Paid = (splitTotal[3])

println(Cheque_Total_Paid)

def Total_Amt = ((Double.parseDouble(Efectivo_Amt) + Double.parseDouble(CreditNote_Amt)) + Double.parseDouble(Cheque_Amt)) +Double.parseDouble(TransferenciasElectronicas_Amt)

Mobile.comment('Total paid as Inv amount')

Mobile.verifyEqual(Cheque_Total_Paid, Total_Amt, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Total paid should display the aggregated amount that is going to pay across all modes')

Mobile.verifyEqual(invAmtText, Total_Amt, FailureHandling.STOP_ON_FAILURE)



Mobile.comment('inv amount is prefilled in Efectivo mode')

Mobile.verifyEqual(Double.parseDouble(invAmtText).round(), Double.parseDouble(Efectivo_Amt).round())


Mobile.closeApplication()
