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
        2, 22))

//def invAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BICollectionScreen01/InvAmt_TextView'), 0)
def AmtText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

//double Amt = Double.parseDouble(AmtText)
int len = AmtText.length()

for (int i = 0; i <= len; i++) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData').getValue(7, 3)

println(GlobalVariable.DropdownName)

println(GlobalVariable.DropdownOption)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData').getValue(8, 3)

println(GlobalVariable.DropdownName)

println(GlobalVariable.DropdownOption)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData').getValue(10, 3)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData').getValue(9, 2)

println(GlobalVariable.DropdownName)

println(GlobalVariable.DropdownOption)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), findTestData(
        'Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(3, 14), 
    0)

/*'Current date'
def date = new Date()

def sdf = new SimpleDateFormat('dd-MM-yyyy')

def presentDate = sdf.format(date)

def cuurrentMonth = presentDate.substring(3, 5)*/

def CurrentDate = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'),
	0)
Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/NextMonth_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/1_Date'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/OK_button'), 0)

def ProvideChequeDateText = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 
    0)

def ProvideChequeDate = ProvideChequeDateText.substring(0, 2)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_283'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0, 
    FailureHandling.STOP_ON_FAILURE)

Mobile.comment('verify the provided date')

def expectedDate = findTestData('Phase2.1/TY_06/Invoice, Replacement with Sp/invoice-Delivery Summary-Delivery Final Summary').getValue(
    3, 23)

Mobile.verifyEqual(Double.parseDouble(ProvideChequeDate), Double.parseDouble(expectedDate), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyNotEqual(CurrentDate, ProvideChequeDateText, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

