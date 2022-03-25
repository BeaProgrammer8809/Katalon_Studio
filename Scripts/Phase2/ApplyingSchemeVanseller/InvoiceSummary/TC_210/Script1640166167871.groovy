import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 59), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

ExpBuySkuName = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 
    0)

def orderQuantity = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Scheme is applied for sku')

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

ExpGetSkuName = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

GetQuanity = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def UnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def buySkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def buySkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def buySkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def getSkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def getSkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def getSkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def expGetPrice = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

Mobile.verifyEqual(getSkuTotalPrice, expGetPrice, FailureHandling.STOP_ON_FAILURE)

println('Get sku total price is zero as expected')

Mobile.verifyMatch(buySkuQty, orderQuantity, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(GetQuanity, getSkuQty, false, FailureHandling.STOP_ON_FAILURE)

def SKUGrossAmount1 = Integer.parseInt(orderQuantity) * Float.parseFloat(UnitPrice)

DecimalFormat df = new DecimalFormat('0.00')

SKUGrossAmount = df.format(SKUGrossAmount1)

println(SKUGrossAmount)

GrossAmt = Double.parseDouble(SKUGrossAmount)

'sku having 10% category  discount and  10% item discount '
def ItemDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.item10_Percent'(GrossAmt)

secondGrossAmt = (GrossAmt - ItemDisc)

def CatDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.category10_Percent'(secondGrossAmt)

def TotalDisc1 = ItemDisc + CatDisc

DecimalFormat df1 = new DecimalFormat('0.00')

TotalDisc = df1.format(TotalDisc1)

CalcTotalPrice = (GrossAmt - Double.parseDouble(TotalDisc))

CalTotalPrice = df1.format(CalcTotalPrice)

def totalSum = Double.parseDouble(buySkuTotalPrice)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

SkuBuyName = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def SkuGetName = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

def ActualOrderPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

Mobile.verifyMatch(ExpGetSkuName, SkuGetName, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(ExpBuySkuName, SkuBuyName, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(buySkuTotalPrice, CalTotalPrice, false, FailureHandling.STOP_ON_FAILURE)

println('Item & category discount is included in total price calculation')

def expTotalPrice2 = Double.parseDouble(buySkuUnitPrice) * Double.parseDouble(buySkuQty)

Mobile.verifyNotEqual(buySkuTotalPrice, expTotalPrice2, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_210'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

