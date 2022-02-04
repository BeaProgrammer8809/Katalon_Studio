import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2/Common_Data/CommonData_03').getValue(2, 20)], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

for (def i = 0; i < 3; i++) {
    if (i == 0) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 1)
    } else if (i == 1) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 17)
    } else {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 26)
    }
    
    Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

for (def i = 0; i < 3; i++) {
    if (i == 0) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 1)
    } else if (i == 1) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 17)
    } else {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 26)
    }
    
    Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

    Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

    Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

    Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

    Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

def actualPesitoCommissionAmt = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

actualPesitoCommissionAmt = Double.parseDouble(actualPesitoCommissionAmt)

DecimalFormat df = new DecimalFormat('0.0')

actualPesitoCommissionAmt = df.format(actualPesitoCommissionAmt)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox_Indexing'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

def effAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

for (int i = 0; i < effAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

def creditAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICreditNoteScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.verifyElementChecked(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 
    0, FailureHandling.STOP_ON_FAILURE)

def actualPesitoAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i < actualPesitoAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), effAmt.toString(), 
    0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.verifyElementChecked(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

def actualRTGSAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Amount_EditText'), 
    0)

def expRTGSAmt = (Double.parseDouble(invAmt) - Double.parseDouble(actualPesitoAmt)) - Double.parseDouble(creditAmt)

Mobile.verifyEqual(actualRTGSAmt, expRTGSAmt, FailureHandling.STOP_ON_FAILURE)

println('Balance invoice amount is displaying in RTGS mode')

Mobile.verifyNotEqual(actualRTGSAmt, actualPesitoCommissionAmt, FailureHandling.STOP_ON_FAILURE)

println('Pesito commission amount is not displaying under RTGS mode')

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

Mobile.verifyElementChecked(findTestObject('Object Repository/Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

def actualEffectivoAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

Mobile.verifyEqual(actualEffectivoAmt, actualPesitoCommissionAmt, FailureHandling.STOP_ON_FAILURE)

println('Pesito commission is displaying under effectivo mode')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    ['testCaseName':'TC_426_CollectionScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

