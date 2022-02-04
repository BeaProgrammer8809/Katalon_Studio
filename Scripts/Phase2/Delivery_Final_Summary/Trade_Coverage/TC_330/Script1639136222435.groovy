import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/header_Trade Coverage'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

retailerName = findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(5, 2)

println(retailerName)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
    retailerName, 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
    0)

Mobile.tap(findTestObject('Phase2/BINoCartePorteGeneratedPopup01/OK_Button'), 0)

Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIBlueLabelProcess01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        3, 2), 0)

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

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

NetAmount = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        6, 2), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Do_You_Want_To_Print_Invoicing_Without_Preticket_PopUp_TextView'), 
    0)) {
    Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Preticket_PopUp_OK_Button'), 0)
}

if (Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully._TextView'), 
    0)) {
    Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)
}

Mobile.callTestCase(findTestCase('Phase2/Delivery_Final_Summary/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_330'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0)

actualPage = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        2, 2))

Title = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/PrintPreview_Title'), 0)

Mobile.verifyMatch(Title, findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(2, 2), false)

Mobile.closeApplication()

