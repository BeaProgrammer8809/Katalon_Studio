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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElemen

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

value = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

Integer len = value.length()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i <= len; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Collection-Dropdown-Script'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

def v1 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

def V2 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/._NumButton'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

def V3 = Mobile.getText(findTestObject('Phase2/BINumberKeyboardCollection01/5_NumButton'), 0)

def Actual_value = (v1 + V2) + V3

println('Actual_value')

def Expected_value = Mobile.getAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 
    'text', 0)

println(Expected_value)

Mobile.verifyNotMatch(Actual_value, Expected_value, false)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC426_CollectionScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

