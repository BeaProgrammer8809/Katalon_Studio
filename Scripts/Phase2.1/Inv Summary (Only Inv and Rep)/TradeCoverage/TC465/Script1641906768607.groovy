import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

//
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

def Expected_TotalAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC465'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

def Efectivo_TotalAmt = Mobile.getAttribute(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    'text', 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC465'], FailureHandling.STOP_ON_FAILURE)

DecimalFormat df = new DecimalFormat('0.00')

Efectivo_TotalAmt = df.format(Float.parseFloat(Efectivo_TotalAmt))

println(Efectivo_TotalAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def Transferencias_TotalAmt = Mobile.getAttribute(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Amount_EditText'), 
    'text', 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC465'], FailureHandling.STOP_ON_FAILURE)

Transferencias_TotalAmt = df.format(Float.parseFloat(Transferencias_TotalAmt))

println(Transferencias_TotalAmt)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(8, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TY_04/Phase2.1').getValue(7, 25), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

def Actual_TotalAmt = Float.parseFloat(Efectivo_TotalAmt) + Float.parseFloat(Transferencias_TotalAmt)

Actual_TotalAmt = df.format(Actual_TotalAmt)

println(Actual_TotalAmt)

Mobile.verifyMatch(Expected_TotalAmt, Actual_TotalAmt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/EnterTheFolioNumber_PopupTitle'), 
    0)

println('User is able to submit the invoice amount in Cheque and RTGS mode')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC465'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

