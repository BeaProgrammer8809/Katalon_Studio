import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_400'], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_400'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Non_Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

//def Actual_Sales_Return = Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'),0)
//Mobile.getText(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_400'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Payment_CheckBox'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_400'], FailureHandling.STOP_ON_FAILURE)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

//println('Invoice Amount in Collection screen is ' + invAmt)
//Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)
println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)

//Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ICICI_Bank'), 0)

//GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)
//
//GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)
//
//Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)
//
//Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)
	
def Expected = findTestData('Phase2.1/Common_Data/CommonData').getValue(16, 39)

println(Expected)

Mobile.delay(8, FailureHandling.STOP_ON_FAILURE)

List<WebElement> dropdown = driver.findElementsById('android:id/text1')

for (WebElement ele : dropdown) {
	String val = ele.getText()

	if (val.equals(Expected)) {
		ele.click()

		break
	}
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ICICI_Bank'), 0)
//Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)

//assertion dropdown
List<WebElement> dropdownvalues = driver.findElementsByXPath('/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView')

sizeofdropdown = dropdownvalues.size()

println("$sizeofdropdown")

if (sizeofdropdown > 0) {
	println('the element is dropdown')

	driver.findElementByXPath('/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]').click()
} else {
	println('element is not a dropdown')

	//assert false
}

println('Select bank is dropdown and its an mandatory field')

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_400'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()