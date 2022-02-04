import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.DecimalFormat as DecimalFormat
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To Click on Search Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_13/TY_13').getValue(
        3, 39), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_4'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0)

def expectedAmountSplitpopup = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/AmountSplitUp_PopUpTitle'), 
    0)

Mobile.verifyMatch(expectedAmountSplitpopup, findTestData('Phase2.1/TY_13/TY_13').getValue(5, 39), false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_112'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_TextView'), 
    0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_TextView'), findTestData(
        'Phase2.1/TY_13/TY_13').getValue(5, 40))

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DEDUCTIONS_TextView'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DEDUCTIONS_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DEDUCTIONS_TextView'), findTestData(
        'Phase2.1/TY_13/TY_13').getValue(5, 41))

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_TextView'), findTestData(
        'Phase2.1/TY_13/TY_13').getValue(5, 42))

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_TextView'), findTestData(
        'Phase2.1/TY_13/TY_13').getValue(5, 43))

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_TextView'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_TextView'), findTestData(
        'Phase2.1/TY_13/TY_13').getValue(5, 44))

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_112'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

Mobile.closeApplication()

