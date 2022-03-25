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

//GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_06/Invoice Summary/Invoice_Summary').getValue(5, 1)
//GlobalVariable.SchemeBuySkuName = '02_BIM_SKU_EP_SD'
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

def product = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 70)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), product, 0)

//findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(3, 1)
/*Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_BuyValue - Copy'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println('Scheme buy qty' + schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)
*/
//
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def invoiceqty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

def SRPPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/SRP_Price'), 0)

'Provide order qty for second product'
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

def product2 = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 71)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), product2, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

//GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 1)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def invoiceqty2 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

def SRPPrice2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/SRP_Price'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Scheme should be applied successfully')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary2').getValue(
        3, 1))

def actualresult = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

def expectedresult = findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary2').getValue(3, 1)

Mobile.verifyMatch(actualresult, expectedresult, false)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

def Getquantity = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

def GetSchemeSku = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BISlabScreen/Done_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Qty_CheckBox_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

def UBuyPriceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

double UBuyPrice = Double.parseDouble(UBuyPriceText)

def BuyPieceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

double BuyPiece = Double.parseDouble(BuyPieceText)

def BuyTotalText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double BuyTotal = Double.parseDouble(BuyTotalText)

double expectedTotal = UBuyPrice * BuyPiece

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Verifying the scheme buy detail')

'verifying the buy quantity'
Mobile.verifyMatch(invoiceqty, BuyPieceText, false, FailureHandling.STOP_ON_FAILURE)

'verifying the buy U.Price'
Mobile.verifyMatch(SRPPrice, UBuyPriceText, false, FailureHandling.STOP_ON_FAILURE)

'verifying the buy SkuTotal'
Mobile.verifyEqual(BuyTotal, expectedTotal, FailureHandling.STOP_ON_FAILURE)

'Verifying the second buy product'
GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 3)

def UBuyPriceText2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

double UBuyPrice2 = Double.parseDouble(UBuyPriceText2)

def BuyPieceText2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

double BuyPiece2 = Double.parseDouble(BuyPieceText2)

def BuyTotalText2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double BuyTotal2 = Double.parseDouble(BuyTotalText2)

double expectedTotal2 = UBuyPrice2 * BuyPiece2

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Verifying the scheme buy detail')

'verifying the buy quantity'
Mobile.verifyMatch(invoiceqty2, BuyPieceText2, false, FailureHandling.STOP_ON_FAILURE)

'verifying the buy U.Price'
Mobile.verifyMatch(SRPPrice2, UBuyPriceText2, false, FailureHandling.STOP_ON_FAILURE)

'verifying the buy SkuTotal'
Mobile.verifyEqual(BuyTotal, expectedTotal, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_166'],
	FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 2)

def UGetPriceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

double UGetPrice = Double.parseDouble(UGetPriceText)

def GetPieceText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

double GetPiece = Double.parseDouble(GetPieceText)

def GetTotalText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double GetTotal = Double.parseDouble(GetTotalText)

double expectedGetTotal = UGetPrice * GetPiece

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0, FailureHandling.STOP_ON_FAILURE)

'Verifying the scheme get Product'
Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    GetSchemeSku, FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Verifying the scheme get detail')

'verifying the Get quantity'
Mobile.verifyMatch(Getquantity, GetPieceText, false, FailureHandling.STOP_ON_FAILURE)

'Verifing the get Product price was 0 / free Sku'
Mobile.verifyEqual(GetTotal, findTestData('Phase2.1/TY_06/Invoice_Summary/InvoiceSummary2').getValue(4, 1), FailureHandling.STOP_ON_FAILURE)

'verifying the buy SkuTotal'
Mobile.verifyEqual(GetTotal, expectedGetTotal, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

