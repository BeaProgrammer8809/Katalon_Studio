import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 19)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 
    0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterPaymentPopup01/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BICollectionScreen01/InvAmt_Value'), 0)

println(invAmt)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.verifyElementHasAttribute(findTestObject('Object Repository/Phase2/BICollectionScreen01/Cheques_RadioButton'), 'selected', 
    0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.DropdownName = findTestData('Phase2/Common_Data/CommonData_03').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData_03').getValue(7, 3)

println GlobalVariable.DropdownName

println GlobalVariable.DropdownOption

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.verifyElementHasAttribute(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 'enabled', 0, FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()

def ExpectedBranch = findTestData('Phase2/Common_Data/CommonData_03').getValue(8, 3)

println(ExpectedBranch)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/OMRBranch_Branch'),0)

List<WebElement> dropdown = driver.findElementsById('android:id/text1')

def size=dropdown.size()

for(WebElement ele:dropdown)
{
	if(ele.getText().equals(ExpectedBranch))
	{
		ele.click()
	}
}

Mobile.verifyGreaterThanOrEqual(size, '1', FailureHandling.STOP_ON_FAILURE)

println "Select Branch is allowing to choose any branch after selecting any bank from select bank dropdown"

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC421_CollectionScreen'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

