import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert

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

def invAmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

def invAmt21 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt21)

println(invAmt21.length())

for (int i = 0; i < invAmt21.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def invAmt210 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt210)

println(invAmt210.length())

for (int i = 0; i < invAmt210.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

def EffeMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def CommAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(CommAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def invAmt221 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println('Invoice Amount in Collection screen is ' + invAmt221)

println(invAmt221.length())

for (int i = 0; i < invAmt221.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/1_NumButton'), 0)

def TransMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Bank_Branch'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TestData/Test_Data').getValue(2, 59), 0)

def Transamt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(Transamt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

def ChequeMode = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Bank_Branch_ChqueType'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), findTestData('Phase2.1/TestData/Test_Data').getValue(
        2, 59), 0)

def ChequeAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(ChequeAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage")

Mobile.verifyEqual(actualtoastmessage, findTestData('Phase2.1/TestData/Test_Data').getValue(2, 4), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyLessThanOrEqual(ChequeAmt, invAmtText, FailureHandling.STOP_ON_FAILURE)

println('Remaining invoice amount  paid in cheque mode mode ')

Mobile.verifyLessThanOrEqual(Transamt, invAmtText, FailureHandling.STOP_ON_FAILURE)

println('Comission amount with invoice amount paid in Transfercia mode ')

Mobile.verifyEqual(CommAmt, findTestData('Phase2.1/TestData/Test_Data').getValue(5, 1), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(EffeMode, findTestData('Phase2.1/TestData/Test_Data').getValue(4, 1), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(TransMode, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 2), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(ChequeMode, findTestData('Phase2.1/TestData/Test_Data').getValue(3, 1), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_400'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

