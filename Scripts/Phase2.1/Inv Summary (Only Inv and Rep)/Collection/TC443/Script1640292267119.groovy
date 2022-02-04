import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

//Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
//        2, 2), 0)
//
//Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
//        3, 2), 0)
//
//Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
//        4, 2), 0)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

//def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC443'], FailureHandling.STOP_ON_FAILURE)

def Efectivo_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0)

//Mobile.verifyMatch(Efectivo_TotalPaid, invAmt, false, FailureHandling.STOP_ON_FAILURE)
def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC443'], FailureHandling.STOP_ON_FAILURE)

def Transferencias_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 
    0)

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.verifyMatch(Efectivo_TotalPaid, Transferencias_TotalPaid, false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC443'], FailureHandling.STOP_ON_FAILURE)

def Cheques_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/TotalPaid_TextView'), 
    0)

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.verifyMatch(Cheques_TotalPaid, Efectivo_TotalPaid, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(Cheques_TotalPaid, Transferencias_TotalPaid, false, FailureHandling.STOP_ON_FAILURE)

println('Total Paid is displayed in all Modes')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC443'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

