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
        3, 4), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

GetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

BuyQtyText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

println(BuyQtyText)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, 
    FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
}

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        8, 4), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.setText(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(
        4, 4), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

SkuQtyValue = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

SkuQtyExtraInvoice = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2/Delivery_Final_Summary/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_353'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Sku\'s ty against extrainvoice-1 should be no.of invoice qty for scheme get sku in order and invoice screen')

Mobile.verifyMatch(SkuQtyExtraInvoice, BuyQtyText, false)

Mobile.comment('sku\'s qty against Invoice split-1 should display the no.of free sku applied in scheme')

Mobile.verifyMatch(SkuQtyValue, GetQty, false)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), findTestData(
        'Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(2, 4))

Title = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 0)

Mobile.verifyMatch(Title, findTestData('Phase2/TY_06/Delivery_Final_Summary/Delivery final summary').getValue(2, 4), false)

Mobile.closeApplication()

