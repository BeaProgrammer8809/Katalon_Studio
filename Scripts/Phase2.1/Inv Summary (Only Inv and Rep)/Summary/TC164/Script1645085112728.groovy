import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadeAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 23)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def pieces = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

println(pieces)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def UnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

println(UnitPrice)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

def Discountedprice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println(Discountedprice)

def TotalValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(TotalValue)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

String ordervalue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'),
	0)

println(ordervalue)


String TotalOrderValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 0)

println(TotalOrderValue)


def CateDiscount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'),
	0)

println(CateDiscount)

String categoryDisc = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'),
	0)
println(categoryDisc)


def split=CateDiscount.split(' ')

//compDiscText1 =split[0]
categoryDiscount =split[1]
//categoryDiscount=compDiscText1+compDiscText2

println(categoryDiscount)

def categoryDiscountss=Double.parseDouble(categoryDiscount)

def compDiscSymbol = categoryDisc.substring(0, 1)

println(compDiscSymbol)


def SKUGross1 = Integer.parseInt(pieces) * Float.parseFloat(UnitPrice)

DecimalFormat df = new DecimalFormat('0.00')

SKUGross2 = df.format(SKUGross1)



def SKUGross=Double.parseDouble(SKUGross2)
println(SKUGross)

def ItemDisc9 = CustomKeywords.'com.ty.keywords.MobileKeywords.itemNil'(SKUGross)
secondGrossAmt = (SKUGross - ItemDisc9)

def CatDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.category10_Percent'(secondGrossAmt)
def TotalDisc1 = ItemDisc9 + CatDisc
DecimalFormat df1 = new DecimalFormat('0.00')
TotalDisc00 = df1.format(TotalDisc1)
println TotalDisc00

def Categordiscountss=Double.parseDouble(Discountedprice)-SKUGross
println(Categordiscountss)


def CompDisc=ItemDisc9 + CatDisc
println(CompDisc)

def Tax=Double.parseDouble(TotalValue)-Double.parseDouble(Discountedprice)
println(Tax)

def totalSum=Double.parseDouble(Discountedprice)

//def tax=CustomKeywords.'com.ty.keywords.MobileKeywords.taxIEPS'(totalSum)

def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)
println(actualTaxPercentage)

def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(Tax, totalSum)
println(expTaxPercentage)

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)
println "Tax IEPS  is applied for sku"

Mobile.verifyMatch(categoryDiscountss.toString(), CatDisc.toString(), false, FailureHandling.STOP_ON_FAILURE)
println "Category disc applied for SKU"

Mobile.verifyNotEqual(TotalValue, Discountedprice, FailureHandling.STOP_ON_FAILURE)
println("Since price and TotalValue are not same  tax is applied")

Mobile.verifyMatch(CompDisc.toString(), TotalDisc1.toString(), false, FailureHandling.STOP_ON_FAILURE)
println "Category disc applied"

//Mobile.verifyEqual(ordervalue, TotalValue, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(compDiscSymbol, findTestData('Phase2.1/TestData/Test_Data').getValue(2, 30), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_164'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

