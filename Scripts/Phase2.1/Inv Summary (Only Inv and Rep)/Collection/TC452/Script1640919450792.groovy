import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        2, 12), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        3, 2), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        4, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        15, 12), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        3, 2), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(
        4, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIEnterTheFolioNoPopup01/Payment_CheckBox_indexing'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(8, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TY_04/Phase2.1').getValue(7, 12), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIEnterTheFolioNoPopup01/Payment_CheckBox_indexing'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 1)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(10, 2)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(8, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BITransferenciasElectronicasScreen01/ReferenceNum_EditText'), 
    findTestData('Phase2.1/TY_04/Phase2.1').getValue(7, 12), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC452'], FailureHandling.STOP_ON_FAILURE)

def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1').getValue(5, 12)

println(Actual_Toast_Message)

Actual_Toast_Message.contains(Expected_Toast_Message)

Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE)

println('User not able to Submit the invoice amount without entering Reference no')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Collection/Screenshot'), [('testCaseName') : 'TC452'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

