import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 19)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def InvoiceAmountInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'),
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

def InvoiceAmount = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

def length = InvoiceAmount.length()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i <= length; i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Amount_EditText'), 0)

/*Verification done to check  Select Bank should be dropdown and It should be mandatory field */

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/Amount_EditText'), InvoiceAmount, 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 17), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List  dropdownoptions = driver.findElementsByXPath('//*[@resource-id="android:id/text1"]')

def DropdownOptionsSize=dropdownoptions.size()

Mobile.verifyLessThan(0, DropdownOptionsSize)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)

/*Verification done to check Select bank is a mandatory field */

def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(Actual_Toast_Message)

def Expected_Toast_Message = findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 21)

Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_38'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()























