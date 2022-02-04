import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.geom.Arc2D.Double as Double
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/CommonData/CommonData').getValue('RetailerCash', 4)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty_PostM2'), [('testData1') : findTestData('Phase2.1/CommonData/CommonData').getValue(
            'ProductName', 50)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

def InvAmount = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

def invAmt2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt2)

println(invAmt2.length())

for (int i = 0; i < invAmt2.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def invAmt21 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt21)

println(invAmt21.length())

for (int i = 0; i < invAmt21.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/3_NumButton'), 0)

def TransMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Bank_Branch'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TestData/Test_Data').getValue(2, 59), 0)

def TransModeAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def effectivo = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def EfectAmot = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

def Summary = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyEqual(Summary, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 9), FailureHandling.STOP_ON_FAILURE)

println('Error message did not display since collection popup closed and Summary screen displayed')

Mobile.verifyGreaterThanOrEqual(EfectAmot.toString(), TransModeAmt.toString(), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(TransModeAmt, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 19), FailureHandling.STOP_ON_FAILURE)

println('Cheque amount is 3')

Mobile.verifyEqual(TransMode, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 2), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_385'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

