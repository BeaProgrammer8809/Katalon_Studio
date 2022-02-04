import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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

def Invoice_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

//def Efectivo_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),   0)
def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

//Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)
println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)
//
//def Cheques_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/TotalPaid_TextView'), 
//    0)
//
//Mobile.verifyNotMatch(Efectivo_TotalPaid, Cheques_TotalPaid, false, FailureHandling.STOP_ON_FAILURE)
//
//println('User should not allow to enter invoice amount in Cheques mode')
//
//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)
//
//def Credit_TotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BICreditNoteScreen01/TotalPaid_TextView'), 
//    0)
//
//Mobile.verifyNotMatch(Efectivo_TotalPaid, Credit_TotalPaid, false, FailureHandling.STOP_ON_FAILURE)
//
//println('User should not allow to enter invoice amount in Credit mode')
//
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)
//
//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ICICI_Bank'), 0)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)
//
//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/OMRBranch_Branch'), 0)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(8, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC450'], FailureHandling.STOP_ON_FAILURE)

def ReferenceNum_Before = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/4_NumButton'), 0, FailureHandling.STOP_ON_FAILURE)
GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)
GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC450'], FailureHandling.STOP_ON_FAILURE)

def ReferenceNum_After = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0)

Mobile.verifyNotMatch(ReferenceNum_Before, ReferenceNum_After, false, FailureHandling.STOP_ON_FAILURE)

println('Number is allowed to enter inside the Reference No field')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC450'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

