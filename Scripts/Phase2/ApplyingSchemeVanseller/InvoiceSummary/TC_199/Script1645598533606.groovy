import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 7)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), GlobalVariable.RetailerName, 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'),0)
Mobile.tap(findTestObject('Phase2/BINoCartePorteGeneratedPopup01/OK_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 66)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_199_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
def UnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
def TotalOrderValue = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 0)
def Actual_Value_Amt = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Value_Value'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_199_Actual_Values'], FailureHandling.STOP_ON_FAILURE)

//Total Price i.e, pieces*Unit_Price
def GrossAmt = Integer.parseInt(Expected_Pieces_Value) * Double.parseDouble(UnitPrice)
println('Total price against sku1 is ' + GrossAmt)

//Discount=Total Order Value - ActualTotalPrice ==Second gross amount = (SKU gross amount - calculated item discount)
def itemDiscount = CustomKeywords.'com.ty.keywords.MobileKeywords.item10_Percent'(GrossAmt)
def totalDiscount1 = GrossAmt - itemDiscount

//Verification to check the discount percentage
double Discount = Double.parseDouble(TotalOrderValue) - GrossAmt
println('Discount for sku1 is ' + Discount)
DecimalFormat df=new DecimalFormat("0")
def DiscountPercentage=df.format(Discount)
def expDiscountPercentage = DiscountPercentage+'%'
def actualDiscountPercentage = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(3, 256) + "%"

//Tax = Value - Order Value
double tax_Value = Double.parseDouble(Actual_Value_Amt) - Double.parseDouble(TotalOrderValue)
println('Tax amount applied for this product is ' + tax_Value)

def totalSum = Double.parseDouble(TotalOrderValue)
def tax=CustomKeywords.'com.ty.keywords.MobileKeywords.taxIEPS'(totalSum)
def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)
def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax, totalSum)

//Verification to check the Tax percentage for the SKU which is not applied 
Mobile.verifyNotMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)
println('Tax IEPS is not applied for sku')

//Verification to check the item discount not applied
Mobile.verifyMatch(Discount.toString(), totalDiscount1.toString(), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check the Discount percentage
Mobile.verifyMatch(actualDiscountPercentage, expDiscountPercentage, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check the invoice
Mobile.verifyMatch(Actual_Pieces_Value, Expected_Pieces_Value1, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()