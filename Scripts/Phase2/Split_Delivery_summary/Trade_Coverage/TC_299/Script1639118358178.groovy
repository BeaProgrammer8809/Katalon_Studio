import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

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

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Split-Delivery summary/Split-Delivery summary01').getValue(
        3, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

GetSku = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(GetSku)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

getskuPriceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully._TextView'), 0, 
    FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)
}

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

SRPPriceText = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

double SRPPrice = Double.parseDouble(SRPPriceText)

StockDeliveredText = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

double StockDelivered = Double.parseDouble(StockDeliveredText)

TotalText = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

double Total = Double.parseDouble(TotalText)

String Totaltext = Total + ''

double ExpectedTotal = SRPPrice * StockDelivered

String ExpectedTotalText = ExpectedTotal + ''

Mobile.callTestCase(findTestCase('Phase2/Split_Delivery_summary/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_299'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Total should be calculated and displayed as (SRP*Stock delivered)')

Mobile.verifyMatch(Totaltext, ExpectedTotalText, false)

double getskuprice = Double.parseDouble(getskuPriceText)

Total1 = (ExpectedTotal + getskuprice)

String ExpectedTotal1Text = Total1 + ''

Mobile.comment('Scheme get sku should not included in total price')

Mobile.verifyMatch(ExpectedTotalText, ExpectedTotal1Text, false)

Mobile.closeApplication()

