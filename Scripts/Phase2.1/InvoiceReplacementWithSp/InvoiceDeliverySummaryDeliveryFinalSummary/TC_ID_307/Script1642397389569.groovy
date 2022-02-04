import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat as SimpleDateFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2/Common_Data/CommonData_03').getValue(2, 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 18)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(2, 14), 0)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData_03').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData_03').getValue(7, 3)

println(GlobalVariable.DropdownName)

println(GlobalVariable.DropdownOption)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData_03').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData_03').getValue(8, 3)

println(GlobalVariable.DropdownName)

println(GlobalVariable.DropdownOption)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'), 
    0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/NextMonth_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICalenderPopup/10_Date'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BICalenderPopup/OK_button'), 0)

def futureDate = Mobile.getAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'), 
    'text', 0)

println('Actual date entered is ' + futureDate)

SimpleDateFormat formatter = new SimpleDateFormat('dd-MM-yyyy')

Date date = new Date()

def PresentDate = formatter.format(date)

println(PresentDate)

Mobile.verifyNotMatch(futureDate, PresentDate,false, FailureHandling.STOP_ON_FAILURE)

println('User is able to submit amount with future date')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_307_CollectionScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

def actualScreenTitle = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 
    0)

println(actualScreenTitle)

def ExpectedScreenTitle = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(3, 14)

println(ExpectedScreenTitle)

Mobile.verifyMatch(actualScreenTitle, ExpectedScreenTitle, false, FailureHandling.STOP_ON_FAILURE)

println('User is able to submit the amount in RTGS mode with future date')

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_307_D.F.SummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

