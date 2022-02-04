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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 44)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def invamt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 
    0)

def CashAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 
    0)

//def Totalpaid = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'),
//	0)
def TotalPaidEff = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/TotalPaid_TextView'), 
    0)

def TotalPaidEff1 = TotalPaidEff.substring(13, 19)

println("$TotalPaidEff1")

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/Amount_EditText'), 0)

println(invamt.length())

for (int i = 0; i < invamt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

def Amount = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 
    0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/MinAmt_TextView'), 0)

Mobile.verifyElementChecked(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

def Totalpaidtrans = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/TotalPaid_TextView'), 
    0)

def Balance1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Balance_TextView'), 
    0)

Boolean Balance = Balance1.contains(TotalPaidEff1)

Mobile.verifyMatch(Balance.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

def Balancetrans = (('Balance : ' + Amount) + ' of ') + "$TotalPaidEff1"

Mobile.verifyEqual(Balance1, Balancetrans, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(TotalPaidEff, Totalpaidtrans, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Select_Branch_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Select_Branch_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Calendar_Button'), 
    0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Camera_Button'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Camera_Button'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)
	
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0)
	
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0)

def Number = findTestData('Phase2.1/TY_05/Collection').getValue(3, 71)

def decimal = findTestData('Phase2.1/TY_05/Collection').getValue(4, 71)

def keypad = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0)

def decimal1 = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/KeyPad_Complete_Frame'), 0)

println "$keypad"

Boolean KeyPad = Number.contains(keypad)

Mobile.verifyMatch(KeyPad.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

Boolean KeyPad1 = decimal.contains(decimal1)

Mobile.verifyMatch(KeyPad1.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

println('Keypad that allows to enter only numbers and decimal should display')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/BeforeInvoiceCollection/Screenshot'), [('testCaseName') : 'TC_131_Collection'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

