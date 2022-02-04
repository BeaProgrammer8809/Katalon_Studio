import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/CommonData/CommonData').getValue('RetailerCash', 20)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty_PostM2'), [('testData1') : findTestData('Phase2.1/CommonData/CommonData').getValue(
            'ProductName', 50)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Qty_PostM2'), [('testData1') : findTestData('Phase2.1/CommonData/CommonData').getValue(
            'ProductName', 50)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

def invAmt211 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt211)

println(invAmt211.length())

for (int i = 0; i < invAmt211.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def invAmt21 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt21)

println(invAmt21.length())

for (int i = 0; i < invAmt21.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

def EffeMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def CommAmt = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

println(CommAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def TransMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Bank_Branch'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TestData/Test_Data').getValue(2, 59), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Preticket_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_399'], FailureHandling.STOP_ON_FAILURE)

def PrintPre = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

Mobile.verifyEqual(PrintPre, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 59), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(CommAmt, findTestData('Phase2.1/TestData/Test_Data').getValue(4, 18), FailureHandling.STOP_ON_FAILURE)

println('Comission amount with invoice amount paid in efective ')

Mobile.verifyEqual(EffeMode, findTestData('Phase2.1/TestData/Test_Data').getValue(4, 1), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(TransMode, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 2), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_399'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

