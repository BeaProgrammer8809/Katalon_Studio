import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.sun.java.swing.plaf.motif.MotifInternalFrameTitlePane.Title as Title
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Collection/Collection_Cheque').getValue(
        5, 7), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, 
    FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BICollectionScreen01/Collection_Title'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

value = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

Integer len = value.length()

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'), 0)

for (int i = 0; i <= len; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0, FailureHandling.OPTIONAL)
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Cheques_RadioButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/Amount_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeyboardCollection01/9_NumButton'), 0)

actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage")

def Expectedtoastmesaage = findTestData('Phase2/TY_06/Collection/Collection_Cheque').getValue(6, 7)

Mobile.verifyMatch(actualtoastmessage, Expectedtoastmesaage, false)

Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)

/*Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SBI_Bank'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/MGRBranch_Branch'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectChequeType_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Local_ChequeType'), 0)*/
//
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

//
//
Mobile.setText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), findTestData('Phase2/TY_06/Collection/Collection_Cheque').getValue(
        3, 7), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/PreviousMonth_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/1_Date'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/OK_button'), 0)

prevDate = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)

//To know the System date
LocalDate t = LocalDate.now()

PresentDate = ((t) as String)

println(PresentDate)

Mobile.verifyNotEqual(prevDate, PresentDate, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/Collection/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_246'], FailureHandling.STOP_ON_FAILURE)

// the u have to verify present date is not equal with prev date 
Mobile.comment('User should be able to submit the invoice amount with past Cheque date')

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

def Title = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyMatch(Title, findTestData('Phase2/TY_06/Collection/Collection_Cheque').getValue(2, 7), false)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), findTestData(
        'Phase2/TY_06/Collection/Collection_Cheque').getValue(2, 7))

Mobile.closeApplication()

