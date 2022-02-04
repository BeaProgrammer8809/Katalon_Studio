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

GlobalVariable.ProductName = findTestData('Phase2.1/CommonData/CommonData').getValue('ProductName', 15)

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


def Itemdisccount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 0)
println(Itemdisccount)

def split=Itemdisccount.split(' ')

compDiscText1 =split[0]
compDiscText2 =split[1]
ItemDiscount=compDiscText1+compDiscText2

println(ItemDiscount)

def Tax=Double.parseDouble(TotalValue)-Double.parseDouble(Discountedprice)
println(Tax)


def SKUGross = Integer.parseInt(pieces) * Float.parseFloat( UnitPrice)
//DecimalFormat df = new DecimalFormat('0.00')
//SKUGross = df.format(SKUGross)
println(SKUGross)



def Itemmdiscountss=Double.parseDouble(Discountedprice)-SKUGross
DecimalFormat df = new DecimalFormat('0.00')
Itemmdiscountss12 = df.format(Itemmdiscountss)
println(Itemmdiscountss12)


Mobile.verifyEqual(ItemDiscount.toString(), Itemmdiscountss12.toString(), FailureHandling.STOP_ON_FAILURE)
println('Since ItemDiscount and  Itemmdiscountss are same Itemdiscountss are applied')

def OrderValue=SKUGross+Tax
println(OrderValue)

Mobile.verifyNotEqual(SKUGross, Discountedprice, FailureHandling.STOP_ON_FAILURE)
println("Since SKUGross and Discountedprice are not same  Itemdiscount applied")

Mobile.verifyEqual(TotalValue, Discountedprice, FailureHandling.STOP_ON_FAILURE)
println("Since price and TotalValue are same  tax not applied")

Mobile.verifyNotEqual(TotalOrderValue, ordervalue, FailureHandling.STOP_ON_FAILURE)
println("Since TotalOrderValue and  ordervalue are not equal Itemdisccount is  applied")


Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC_158'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

