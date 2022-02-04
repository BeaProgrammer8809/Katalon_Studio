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
import java.text.SimpleDateFormat as SimpleDateFormat
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def expectedInvAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 
    0)

//clearing amount in effectivo mode
def invamt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

println(invamt1.length())

for (int i = 0; i < (invamt1.length() + 1); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

/*verifying collection title*/
Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BICollectionScreen01/Collection_Title'), findTestData(
        'Phase2.1/TY_14/TestData').getValue('Title', 20), FailureHandling.STOP_ON_FAILURE)

/*verifying inv amt & min.Amt*/
def actualInvAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

def actualMinAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/MinAmt_Value'), 
    0)

Mobile.verifyMatch(actualInvAmt, expectedInvAmt, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(actualMinAmt, expectedInvAmt, false, FailureHandling.STOP_ON_FAILURE)

/*verifying Submit button*/
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 
    0, FailureHandling.STOP_ON_FAILURE)

/*verifying Back button*/
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Back_Button'), 
    0, FailureHandling.STOP_ON_FAILURE)

/*verifying image upload button*/
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Camera_Button'), 
    0, FailureHandling.STOP_ON_FAILURE)

/*verifying Select Bank Dropdown*/
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

def actualSelectBank = Mobile.getText(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

def expectedSelectBank = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.verifyMatch(actualSelectBank, expectedSelectBank, false, FailureHandling.STOP_ON_FAILURE)

/*verifying Select Branch Dropdown*/
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

def actualSelectBranch = Mobile.getText(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

def expectedSelectBranch = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

Mobile.verifyMatch(actualSelectBranch, expectedSelectBranch, false, FailureHandling.STOP_ON_FAILURE)

/*verifying Reference textfield*/
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0, FailureHandling.STOP_ON_FAILURE)

/*verifying total balance */
def ActualBalanceText1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 
    0)

def BalanceText = findTestData('Phase2.1/TY_14/TestData').getValue('Data2', 55)

def ExpectedBalanceText1 = (BalanceText + ' ') + actualInvAmt

Mobile.verifyMatch(ActualBalanceText1, ExpectedBalanceText1, false, FailureHandling.STOP_ON_FAILURE)

/*verifying TransferenciasElectronicas mode is enabled*/
Mobile.verifyElementChecked(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 
    0, FailureHandling.STOP_ON_FAILURE)

/*verifying total paid*/
def ActualTotalPaidText1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 
    0)

def TotalPaid = findTestData('Phase2.1/TY_14/TestData').getValue('Data', 55)

def ExpectedTotalPaidText1 = (TotalPaid + ' ') + actualInvAmt

Mobile.verifyMatch(ActualTotalPaidText1, ExpectedTotalPaidText1, false, FailureHandling.STOP_ON_FAILURE)

/*verifying default date*/
def ActualDate = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)

SimpleDateFormat formatter = new SimpleDateFormat('dd-MM-yyyy')

Date date = new Date()

PresentDate = formatter.format(date)

println(PresentDate)

Mobile.verifyMatch(ActualDate, PresentDate, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_223'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
