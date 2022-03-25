import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable as GlobalVariable


Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyInvoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyReplacement_Quantity'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
			'ProductName', 21)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), findTestData('Phase2.1/TY_05/Testdata').getValue('Data1', 28))

/*Verification (calculation) done to check Ordered value field inside the popup*/

def InvoiceQuantityInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

def UnitPriceInSummary=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing') , 0)

def SkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

def ValueAmount = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_048_TradeCoverage'],
	FailureHandling.STOP_ON_FAILURE)

def OrderedValueInsideInfoPopup = Mobile.getText( findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

def ItemdiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('ITEMDISC', 2)
KeywordUtil.logInfo ("${ItemdiscountinWeb}")

def categorydiscountinWeb = findTestData('Phase2.1/TY_05/Testdata').getValue('CATEGORYDISC', 1)
KeywordUtil.logInfo ("${categorydiscountinWeb}")

def TAX = findTestData('Phase2.1/TY_05/Testdata').getValue('IEPSTAX', 1)
KeywordUtil.logInfo ("${TAX}")

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
					  
def CalculatedOrdervalue = (GrossInvoice + TotalTaxAmount).round(2)
KeywordUtil.logInfo ("${CalculatedOrdervalue}")

Mobile.verifyEqual(OrderedValueInsideInfoPopup, CalculatedOrdervalue,FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_048'],
	FailureHandling.STOP_ON_FAILURE)
			 
Mobile.closeApplication()









































