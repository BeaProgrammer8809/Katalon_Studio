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

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 21)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 
    0)

//def InvoiceAmount= Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

//Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
//
//
//Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), findTestData('Phase2.1/TY_05/Collection').getValue(4, 14), 0)
//def Expected=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

for (int i = 0; i < invAmt.length(); i++) {
	
	Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 3'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 3'), 0)

def PesitoGranted=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)
Double Pesitogrand= PesitoGranted as Double
def pesitoCommision=Double.parseDouble(findTestData('Phase2.1/TY_05/Collection').getValue(5, 14))

def PesitoComm=Pesitogrand+pesitoCommision
println "$PesitoComm"
Mobile.verifyNotMatch(PesitoGranted, PesitoComm.toString(), false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCommission_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCommission_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCommission_TextView'), findTestData('Phase2.1/TY_05/Collection').getValue(3, 14))

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC_484_Collection'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC_484_Summary'], FailureHandling.STOP_ON_FAILURE)
Mobile.closeApplication()