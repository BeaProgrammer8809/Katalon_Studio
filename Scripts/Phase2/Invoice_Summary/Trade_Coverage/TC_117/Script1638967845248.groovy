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

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(5, 1)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(6, 1)

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

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(
        3, 1), 0)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.takeScreenshot()

'SchemeBuySKU_Name'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0))

'SlabName'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB 1_Header'), 0))

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println('Scheme buy qty' + schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Invoiceqty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.verifyMatch(schemeBuyQty, Invoiceqty, false)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(
        2, 1))

Title = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyMatch(Title, findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(2, 1), false)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(
        5, 1))

BuyskuName = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

Mobile.callTestCase(findTestCase('Phase2/Invoice_Summary/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_117'], FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Scheme buy sku should be displayed on invoice summary screen')

Mobile.verifyMatch(BuyskuName, findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(5, 1), false)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Scheme get sku should be displayed on invoice summary screen')

Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(
        6, 1))

GetskuName = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

Mobile.verifyMatch(BuyskuName, findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(6, 1), false)

Mobile.closeApplication()

