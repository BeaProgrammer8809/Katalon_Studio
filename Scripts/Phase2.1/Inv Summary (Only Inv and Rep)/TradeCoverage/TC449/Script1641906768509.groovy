import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 19)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 19), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC449'], FailureHandling.STOP_ON_FAILURE)

def Invoice_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.checkElement(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC449'], FailureHandling.STOP_ON_FAILURE)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

//Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)
println(invAmt.length())

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC449'], FailureHandling.STOP_ON_FAILURE)

def ExpectedBranch = findTestData('Phase2.1/TY_04/Phase2.1').getValue(14, 9)

println(ExpectedBranch)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/OMRBranch_Branch'), 
    0)

List<WebElement> dropdown = driver.findElementsById('android:id/text1')

def size = dropdown.size()

for (WebElement ele : dropdown) {
    if (ele.getText().equals(ExpectedBranch)) {
        ele.click()
    }
}

Mobile.verifyGreaterThanOrEqual(size, '1', FailureHandling.STOP_ON_FAILURE)

println('Select Breanch is an Drop down and User is be able to select any bank branch from the dropdown')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC449'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

