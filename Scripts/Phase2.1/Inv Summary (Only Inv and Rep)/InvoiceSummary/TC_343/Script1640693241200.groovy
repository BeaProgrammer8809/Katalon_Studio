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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 1002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCredit', 5)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 2)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.clearText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 25)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), 
    findTestData('Phase2.1/Common_Data/CommonData').getValue('Folio number', 1), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

def ActualResult = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0)

def ExpectedResult = findTestData('Phase2.1/TY_14/TestData').getValue('Data1', 37)

def ExpectedResult1 = findTestData('Phase2.1/TY_14/TestData').getValue('Data2', 37)

boolean actualMessage = ActualResult.contains(ExpectedResult)

boolean actualMessage1 = ActualResult.contains(ExpectedResult1)

def verifytheMessage = actualMessage.toString()

println('verifytheMessage' + verifytheMessage)

def verifytheMessage1 = actualMessage1.toString()

Mobile.verifyMatch(verifytheMessage, findTestData('Phase2.1/TY_14/TestData').getValue('Data', 37), false, FailureHandling.STOP_ON_FAILURE)

/*verifying failure message is not coming & generating id*/
Mobile.verifyMatch(verifytheMessage1, findTestData('Phase2.1/TY_14/TestData').getValue(7, 37), false, FailureHandling.STOP_ON_FAILURE)

println('uuid message is matching with expected')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_343'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

