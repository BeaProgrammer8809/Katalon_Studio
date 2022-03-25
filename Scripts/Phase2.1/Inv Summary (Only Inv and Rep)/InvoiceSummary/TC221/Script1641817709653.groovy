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

import java.text.DecimalFormat

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 21)

//'Provide order quantity'
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 10, FailureHandling.OPTIONAL)

Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def Pieces_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def U_Price_VAlue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def Actual_Value_Amt = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC221'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def CompDisc_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 
    0)

def DistDisc_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/DistDisc_Value'), 
    0)

def OrderValue_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 
    0)
println OrderValue_Value
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC221'], FailureHandling.STOP_ON_FAILURE)

//Total order value= pieces * U.price
def Total_Order_Value = Integer.parseInt(Pieces_Value) * Double.parseDouble(U_Price_VAlue)

println('Total price against sku1 is ' + Total_Order_Value)

//Discount= Order Value - ActualTotalPrice
double Discount = Double.parseDouble(Price_Value) - Total_Order_Value

println('Discount for sku1 is ' + Discount)
DecimalFormat df=new DecimalFormat("0")
def DiscountPercentage=df.format(Discount)
def expDiscountPercentage = DiscountPercentage+'%'

DecimalFormat df1=new DecimalFormat("0.00")
def Discount1=df1.format(Discount)

//Tax = Value - Order Value
double tax_Value = Double.parseDouble(Actual_Value_Amt) - Double.parseDouble(Price_Value)
println('Tax amount applied for this product is ' + tax_Value)

def totalSum = Double.parseDouble(Price_Value)
def tax=CustomKeywords.'com.ty.keywords.MobileKeywords.taxIEPS'(totalSum)
def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)
def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax, totalSum)
def actualDiscountPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(20, 1)

//Verification to check the discount for the SKU
Mobile.verifyNotMatch(actualDiscountPercentage, expDiscountPercentage, false, FailureHandling.STOP_ON_FAILURE)
println('Discount Comp & Item is applied for sku')

//Verification to check the Tax percentage for the SKU
Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)
println('Tax IEPS & IVA is applied for sku')


double Expected_Order_Value = Double.parseDouble(OrderValue_Value) + Double.parseDouble(Discount1)
Expected_Order_Value
Mobile.verifyEqual(Actual_Value_Amt, Expected_Order_Value, FailureHandling.STOP_ON_FAILURE)

println(Expected_Order_Value)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC221'], FailureHandling.STOP_ON_FAILURE)

println('Total amount is calculated based on the formula --> Total = Order value - Comp Disc')

Mobile.closeApplication()

