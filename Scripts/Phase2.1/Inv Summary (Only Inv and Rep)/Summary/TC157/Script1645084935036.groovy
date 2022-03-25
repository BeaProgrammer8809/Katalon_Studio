import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 44)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def InvoiceQuantityInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

def UnitPriceInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def SkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)


def ValueAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC157'],
	FailureHandling.STOP_ON_FAILURE)

def OrderedValueInsideInfoPopup = Mobile.getText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

def ItemdiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('ITEMDISC', 1)
KeywordUtil.logInfo ("${ItemdiscountinWeb}")

def categorydiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('CATEGORYDISC', 1)
KeywordUtil.logInfo ("${categorydiscountinWeb}")

def TAX = findTestData('Phase2.1/TY_05/Testdata').getValue('IEPSTAX', 1)
KeywordUtil.logInfo ("${TAX}")

def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)
println(actualTaxPercentage)

def SkuTotalPrice1=Double.parseDouble(SkuTotalPrice)
def ValueAmount1 = Double.parseDouble(ValueAmount)

def Tax=ValueAmount1-SkuTotalPrice1
def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(Tax, SkuTotalPrice1)
println(expTaxPercentage)

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)
println "Tax IEPS 8%  is applied for sku"

def GrossInvoice =  Double.parseDouble(InvoiceQuantityInSummary) * Double.parseDouble(UnitPriceInSummary)

KeywordUtil.logInfo ("${GrossInvoice}")
def ItemDiscount =  GrossInvoice * (Double.parseDouble(ItemdiscountinWeb)/100)

KeywordUtil.logInfo ("${ItemDiscount}")
def PriceafterItemDiscount = GrossInvoice - ItemDiscount

KeywordUtil.logInfo ("${PriceafterItemDiscount}")
def CategoryDiscount = PriceafterItemDiscount * (Double.parseDouble(categorydiscountinWeb)/100)
					  
KeywordUtil.logInfo ("${CategoryDiscount}")
def PriceAfterAddingDiscount = PriceafterItemDiscount - CategoryDiscount
					
def TotalDiscount = ItemDiscount + CategoryDiscount
KeywordUtil.logInfo ("${TotalDiscount}")

def GrossamountAfterAppliedDiscount = PriceAfterAddingDiscount
KeywordUtil.logInfo ("${GrossamountAfterAppliedDiscount}")

/*verification done to check the tax on the gross amount*/
def TotalTaxAmount = GrossamountAfterAppliedDiscount * (Double.parseDouble(TAX)/100)
KeywordUtil.logInfo ("${TotalTaxAmount}")
					 
//def NetAmount =  GrossInvoice - TotalDiscount + TotalTaxAmount
 
def CalculatedOrdervalue = (GrossInvoice + TotalTaxAmount).round(2)
KeywordUtil.logInfo ("${CalculatedOrdervalue}")


Mobile.verifyEqual(OrderedValueInsideInfoPopup, CalculatedOrdervalue,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC157'],
	FailureHandling.STOP_ON_FAILURE)
			 
Mobile.closeApplication()
