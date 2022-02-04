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
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0, FailureHandling.STOP_ON_FAILURE)

println('cheque mode is selected')

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

println('Collection title is visible')

def InvAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

println(InvAmt)

def InvoiceAmount = 'Total Paid : ' + InvAmt

println(InvoiceAmount)

println('Invoice Amount details is displayed')

def MinAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/MinAmt_Value'), 0)

println(MinAmt)

println(' Minimum amount details is displayed')


def ChequeBalance = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'), 0)

println(ChequeBalance)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println "Balance is displayed"

def ChequeTotalPaid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/TotalPaid_TextView'),
	0)

println(ChequeTotalPaid)

Mobile.verifyEqual(InvoiceAmount, ChequeTotalPaid, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0, FailureHandling.STOP_ON_FAILURE)

println('Select Bank is displayed')

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0, FailureHandling.STOP_ON_FAILURE)

println('Select Branch is displayed')

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 3)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0, FailureHandling.STOP_ON_FAILURE)

println('Select Cheque Type is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println('Cheque Number is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Date is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Camera_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Upload image is displayed')

Mobile.verifyElementVisible(findTestObject('Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'), 0, FailureHandling.STOP_ON_FAILURE)

println "keypad is displayed"

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_105'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
