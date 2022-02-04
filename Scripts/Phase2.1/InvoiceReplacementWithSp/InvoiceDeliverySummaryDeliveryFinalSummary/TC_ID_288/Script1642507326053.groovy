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

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
		2, 28))

def InvAmtText = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

def expBalanceText = findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
	3, 28)

'Verify in effectivo'
def balanceTexteff=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'),0)
balanceofTexteff=balanceTexteff.substring(0,15)


Mobile.verifyMatch(balanceofTexteff, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Double.parseDouble(InvAmtText).round(), Double.parseDouble(balanceTexteff.substring(15)).round(), FailureHandling.STOP_ON_FAILURE)

'Verify in Cheque'
Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

//Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'), expBalance, FailureHandling.STOP_ON_FAILURE)
def balanceTextchq=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'),0)
balanceofTextchq=balanceTextchq.substring(0,15)


Mobile.verifyMatch(balanceofTextchq, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Double.parseDouble(InvAmtText).round(), Double.parseDouble(balanceTextchq.substring(15)).round(), FailureHandling.STOP_ON_FAILURE)
'Verify in RTGS'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

/*Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'),
	expBalance, FailureHandling.STOP_ON_FAILURE)*/

def balanceTextRTGS=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'),0)
balanceofTextRTGS=balanceTextRTGS.substring(0,15)


Mobile.verifyMatch(balanceofTextRTGS, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Double.parseDouble(InvAmtText).round(), Double.parseDouble(balanceTextRTGS.substring(15)).round(), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_288'], FailureHandling.STOP_ON_FAILURE)


'Verify in Credit Note'
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/CreditNote_RadioButton'), 0)

//Mobile.verifyElementText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'), expBalance, FailureHandling.STOP_ON_FAILURE)
def balanceTextcredit=Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Balance_TextView'),0)
balanceofTextcredit=balanceTextcredit.substring(0,15)


Mobile.verifyMatch(balanceofTextcredit, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Double.parseDouble(InvAmtText).round(), Double.parseDouble(balanceTextcredit.substring(15)).round(), FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Efectivo_RadioButton'), 0)

def AmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

double Amt = Double.parseDouble(AmtText)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

int len = AmtText.length()

for (int i = 0; i <= len; i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}



'Balance will updated'
def BalanceAfterUpdate = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Balance_TextView'),
	0)

Mobile.verifyNotMatch(BalanceAfterUpdate, expBalanceText, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()