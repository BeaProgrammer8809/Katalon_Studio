import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DecimalFormat

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 2)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Actual_Buy_pieces = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),
	0)

println("$Actual_Buy_pieces")

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Actual_UnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),
	0)

println(Actual_UnitPrice)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Discount_Price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println("$Discount_Price")

def Amount = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(Amount)


def gross_amount = Integer.parseInt(Actual_Buy_pieces) * Float.parseFloat(Actual_UnitPrice)

println(gross_amount)

DecimalFormat df1 = new DecimalFormat('0.00')

GrossAmt2 = df1.format(gross_amount)

println(GrossAmt2)

Double GrossAmt=Double.parseDouble(GrossAmt2)

"*****************Discount calculation*************************"
def ItemDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.item5_Percent'(GrossAmt)

secondGrossAmt = (GrossAmt - ItemDisc)

def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 16))
def catDisc=secondGrossAmt*(Disc/100)

def TotalDisc = ItemDisc + catDisc.round(3)

DecimalFormat df=new DecimalFormat("0.00")

def TotalDisc1 = df.format(TotalDisc)

println TotalDisc1



"***********Tax percentage verifaction*********************"
def totalSum = Double.parseDouble(Discount_Price)


//Tax = Value - Order Value
double tax = Double.parseDouble(Amount) - Double.parseDouble(Discount_Price)
println('Tax amount applied for this product is ' + tax)


def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(20, 1)

def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax, totalSum)

println expTaxPercentage

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)

println('Tax IEPS  is not aapplied for sku')

def ActualCompDisc1= Double.parseDouble(Discount_Price)-(gross_amount)

println ActualCompDisc1

DecimalFormat df2=new DecimalFormat("0.00")

def ActualCompDisc = df2.format(ActualCompDisc1)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def compDiscText = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'),
	0)

println(compDiscText)

def compDiscSymbol = compDiscText.substring(0, 1)

println(compDiscSymbol)

Mobile.verifyEqual(compDiscSymbol, findTestData('Phase2.1/TY_01/Test_Data').getValue(4, 30))


def split=compDiscText.split(' ')

compDiscText1 =split[0]
compDiscText2 =split[1]


compDisc=compDiscText1+compDiscText2

println(compDisc)

Mobile.verifyEqual(ActualCompDisc, compDisc, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(TotalDisc1, compDiscText2, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_176'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()


