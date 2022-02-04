import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

GlobalVariable.Buysku = findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(9, 1)

GlobalVariable.Getsku = findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(10, 1)

GlobalVariable.Getsku1 = findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(11, 1)

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

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        3, 1), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

BuyQtyText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

println(BuyQtyText)

Integer buy = BuyQtyText.toInteger()

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

GetQtyText1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

println(GetQtyText1)

Integer get1 = GetQtyText1.toInteger()

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 3)

GetQtyText2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

println(GetQtyText2)

Integer get2 = GetQtyText2.toInteger()

Integer Total = (buy + get1) + get2

TotalText = (Total + '')

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, 
    FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

actualQty = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2/Delivery_Final_Summary/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_310'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.comment('sku\'s qty against Invoice split-1 should display sum of scheme buy qty and scheme get qty')

Mobile.verifyMatch(TotalText, actualQty, false)

Mobile.closeApplication()

