import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import java.time.*
import java.text.SimpleDateFormat as SimpleDateFormat
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
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/InvoiceReplacementWithSp_Reusable'), [:], FailureHandling.STOP_ON_FAILURE)

def AmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

int len = AmtText.length()

for (int i = 0; i <= len; i++) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.comment('1. Title should be shown as Collection')

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
		2, 25), FailureHandling.STOP_ON_FAILURE)

Mobile.comment('2. Inv Amt, Min Amt details should be displayed.')

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

def InvAmtText = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

def expBalanceText = findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
	3, 25)
def balanceText=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'),0)
balanceofText=balanceText.substring(0,15)
Mobile.comment('Balance: X of XXX amount should display')

Mobile.verifyMatch(balanceofText, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Double.parseDouble(InvAmtText).round(), Double.parseDouble(balanceText.substring(15)).round(), FailureHandling.STOP_ON_FAILURE)
/*Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'),
	expBalance, FailureHandling.STOP_ON_FAILURE)*/



def RTGS_Total_Paid = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'),
	0)

def splitTotal = RTGS_Total_Paid.split(' ')

RTGS_Total_Paid = Double.parseDouble(splitTotal[3])

Mobile.comment('verification of Total paid Amount')

def AmtInRTGSText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Amount_EditText'),
	0)

double AmtInRTGS = Double.parseDouble(AmtInRTGSText)

Mobile.verifyEqual(RTGS_Total_Paid.round(), AmtInRTGS.round(), FailureHandling.STOP_ON_FAILURE)

Mobile.comment('6. Select Bank, Select Branch, drop down should be displayed.')

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('7. Reference number, Date, upload image should be present with submit button.')

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Camera_Button'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Camera_Button'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Keypad should be displayed')

Mobile.verifyElementExist(findTestObject('Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BINumberKeyboardCollection01/NumberKeyBoard_ALL'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_285'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()