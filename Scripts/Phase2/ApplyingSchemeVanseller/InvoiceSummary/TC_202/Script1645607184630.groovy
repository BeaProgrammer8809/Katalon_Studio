import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/CommonData/CommonData').getValue(2, 1)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 52)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def BuyQty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

def BuySKU = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_202'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_202'],
	FailureHandling.STOP_ON_FAILURE)

def GetSKU = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)
println(GetSKU)

def GetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)
println(GetQty)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def InvoiceBuyQuantity = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)
println(InvoiceBuyQuantity)

def ActualBuySKU = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'),
	0)
println(ActualBuySKU)


def UnitPriceInSummary = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def BuySkuPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)
def BuyValueAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

def ActualGetSKU = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'),
	0)
println(ActualGetSKU)

def InvoiceGetQuantity = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)
println(InvoiceGetQuantity)

def SkuGetPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)
println(SkuGetPrice)


def ItemdiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('NOITEMDISC', 1)
KeywordUtil.logInfo("$ItemdiscountinWeb")

def categorydiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('CATEGORYDISC', 1)
KeywordUtil.logInfo("$categorydiscountinWeb")

def TAX = findTestData('Phase2.1/TY_05/Testdata').getValue('IVATAX', 1)
KeywordUtil.logInfo("$TAX")

def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(19, 1)
println(actualTaxPercentage)


def GrossInvoice = Double.parseDouble(InvoiceBuyQuantity) * Double.parseDouble(UnitPriceInSummary)
KeywordUtil.logInfo("$GrossInvoice")

def ItemDiscount = GrossInvoice * (Double.parseDouble(ItemdiscountinWeb) / 100)
KeywordUtil.logInfo("$ItemDiscount")

def SecondGross = GrossInvoice - ItemDiscount
KeywordUtil.logInfo("$SecondGross")

def CategoryDiscount = GrossInvoice * (Double.parseDouble(categorydiscountinWeb) / 100)
KeywordUtil.logInfo("$CategoryDiscount")

def TotalPrice = SecondGross - CategoryDiscount
KeywordUtil.logInfo("$TotalPrice")

def TotalDiscount = ItemDiscount + CategoryDiscount
KeywordUtil.logInfo("$TotalDiscount")


def BuySKUWafterDisc= GrossInvoice-TotalDiscount
KeywordUtil.logInfo("$BuySKUWafterDisc")


def TotalTaxAmount = BuySKUWafterDisc * (Double.parseDouble(TAX) / 100)
KeywordUtil.logInfo("$TotalTaxAmount")


def SkuTotalPrice1=Double.parseDouble(BuySkuPrice)
def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(TotalTaxAmount, SkuTotalPrice1)
println(expTaxPercentage)

/*verification done to check the tax on the gross amount*/
def BuySKUwithTAX = (BuySKUWafterDisc + TotalTaxAmount).round(2)
KeywordUtil.logInfo("$BuySKUwithTAX")
Mobile.verifyNotMatch(BuySKUwithTAX.toString(), BuySkuPrice, false, FailureHandling.STOP_ON_FAILURE)


Mobile.verifyEqual(TotalPrice, BuySkuPrice, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(expTaxPercentage, actualTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(BuyQty, InvoiceBuyQuantity, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(GetQty, InvoiceGetQuantity, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(BuySKU, ActualBuySKU, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(GetSKU,ActualGetSKU , false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(SkuGetPrice.toString(), findTestData('Phase2/TY_08/ScriptsData').getValue(3, 27), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_202'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

