import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/TY_11/TestData').getValue(2, 7)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

'SKU is not having any tax, only item discount is present, So not calculating any tax'

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
	0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_4'), 0)

def actualBuyQty=Mobile.getText(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def actualBuySku=Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println "Scheme is applied for sku"

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button'), 0)

def actualGetSku=Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView') ,0)

def actualGetSkuQty=Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def buySkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

def buySkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

def buySkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

def expBuySku=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

Mobile.verifyMatch(actualBuySku, expBuySku, false, FailureHandling.STOP_ON_FAILURE)

println "Buy sky is displayed in summary screen"

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def getSkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

def getSkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

def getSkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

def expGetSku=Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 0)

Mobile.verifyMatch(actualGetSku, expGetSku, false, FailureHandling.STOP_ON_FAILURE)

println "Get sku is displayed in summary screen"

Mobile.verifyEqual(actualGetSkuQty, getSkuQty, FailureHandling.STOP_ON_FAILURE)

println "Get sku qty is as expected"

def expGetPrice=findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

Mobile.verifyEqual(getSkuTotalPrice, expGetPrice, FailureHandling.STOP_ON_FAILURE)

println "Get sku total price is zero as expected"

def GrossAmt=Double.parseDouble(buySkuUnitPrice) * Double.parseDouble(buySkuQty)

def itemDisc=CustomKeywords.'com.ty.keywords.MobileKeywords.item10_Percent'(GrossAmt)





secondGrossAmt = (GrossAmt - itemDisc)

def CatDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.categoryNil'(secondGrossAmt)

def TotalDisc1 = itemDisc + CatDisc

DecimalFormat df1 = new DecimalFormat('0.00')

TotalDisc = df1.format(TotalDisc1)

def totalAmt = (GrossAmt - TotalDisc1)

expTotalPrice = df1.format(totalAmt)

Mobile.verifyEqual(buySkuTotalPrice, expTotalPrice, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_208'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

