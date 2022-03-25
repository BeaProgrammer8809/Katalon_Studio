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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.DecimalFormat as DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 51), 0)

/*Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

GlobalVariable.Buysku = findTestData('Phase2/TY_11/TestData').getValue(2, 6)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_11/TestData').getValue(2, 6)

GlobalVariable.SchemeName = findTestData('Phase2/TY_11/TestData').getValue(4, 6)

def schemeBuyQty = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)*/

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5,1)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def IncludedTaxPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

/*
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)*/
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

/*def invQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 
    0)

def SRPPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

def actualTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 
    0)

def TotalPriceExpected = Integer.parseInt(invQty) * Float.parseFloat(SRPPrice)

DecimalFormat df = new DecimalFormat('0.00')

TotalPriceExpected = df.format(TotalPriceExpected)*/
//
'Capturing the required data'
def InvoiceQtyText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

double InvoiceQty = Double.parseDouble(InvoiceQtyText)

def SalesReturnQtyText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

double SalesReturnQty = Double.parseDouble(SalesReturnQtyText)

def UpriceText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

double Uprice = Double.parseDouble(UpriceText)

def SkuTotalPriceText = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

double SkuTotalPrice = Double.parseDouble(SkuTotalPriceText)

/*def actualValueText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

double actualValue = Double.parseDouble(actualValueText)*/
'Disc Calculation'
def itemDiscText = findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(6, 1)

double itemDiscPercentage = Double.parseDouble(itemDiscText)

double itemDiscAmt = (InvoiceQty * Uprice) * (itemDiscPercentage / 100)

double AmountAfterItemDisc = (InvoiceQty * Uprice) - itemDiscAmt

def CategoryText = findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary02').getValue(7, 1)

double CategoryDiscPercentage = Double.parseDouble(CategoryText)

double CategoryDiscAmt = AmountAfterItemDisc * (CategoryDiscPercentage / 100)

double CompDiscValue = CategoryDiscAmt + itemDiscAmt

double TotalPriceExpected = (InvoiceQty * Uprice) - CompDiscValue

TotalPriceExpected = TotalPriceExpected.round(2)

'Price without considering Discount'
double TotalPriceWithOutDisc = InvoiceQty * Uprice

'Verifying the discount is mapped for that product'
Mobile.verifyEqual(SkuTotalPrice, TotalPriceExpected, FailureHandling.STOP_ON_FAILURE)

//
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Discount is not inclueded in total price')

def actualTotalPriceText = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 
    0)

double actualTotalPrice = Double.parseDouble(actualTotalPriceText)
'Verifying the total price With out considering Discount'
Mobile.verifyEqual(actualTotalPriceText, TotalPriceWithOutDisc, FailureHandling.STOP_ON_FAILURE)
'Verifying the total price considering Discount'
Mobile.verifyNotEqual(actualTotalPriceText, TotalPriceExpected, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/SplitDeliverySummary/Screenshot'), [('testCaseName') : 'TC_301'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

