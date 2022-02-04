import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 20)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_11/TestData').getValue(
		3, 4), 0)



Mobile.waitForElementPresent(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 5)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)



def InvAmount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println(InvAmount1)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCredit_RadioButton'), 0)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

def PesitoCommision = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/PesitoCommission_TextView'),
	0)

println(PesitoCommision)

PesitoCommision = PesitoCommision.substring(27, 28)

def PesitoAmount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

println(PesitoAmount1)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def TP = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'),
	0)

println(TP)

TP1 = TP.substring(13, 18)

double TotalPaid = Double.parseDouble(TP1)

//Integer TotalPaid= TP1 as Integer
double InvAmount = Double.parseDouble(InvAmount1)

//Integer InvAmount= InvAmount1 as Integer
println(TotalPaid)

//integer TotalPaid= Integer.parseInteger(TotalPaid)
//InvAmount= Integer.parseInt(InvAmount)
def BalanceAmount = TotalPaid - InvAmount

println(BalanceAmount)

Mobile.clearText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
	0)

//Integer PesitoAmount= PesitoAmount1 as Integer
double PesitoAmount = Double.parseDouble(PesitoAmount1)

def EffectiveAmount = InvAmount - PesitoAmount

println(EffectiveAmount)

EffectiveAmount = EffectiveAmount.toString()

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), EffectiveAmount,
	0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Submit_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/BeforeInvoiceCollection/Screenshot'), [('testCaseName') : 'TC_591'], FailureHandling.STOP_ON_FAILURE)


AppiumDriver driver = MobileDriverFactory.getDriver()

def actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage")

def ExpectedToastMessage = findTestData('Phase2.1/TY_11/TestData').getValue(4, 4) + BalanceAmount

println(ExpectedToastMessage)

Mobile.verifyMatch(actualtoastmessage, ExpectedToastMessage, false)


Mobile.closeApplication()

