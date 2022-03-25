import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 22)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB Qty'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 22)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def pieces = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
def UnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),0)
def totalsum1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),0)
def U_Price_Value = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BuySchemeDetails/Buy_U.Price_Value'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

def Actual_Amount_Value = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 0)
println(Actual_Amount_Value)

def Actual_Amount = Double.parseDouble(U_Price_Value) - Double.parseDouble(Actual_Amount_Value)
DecimalFormat df = new DecimalFormat('0.00')
Actual_Amount = df.format(Actual_Amount)
println Actual_Amount
println('IEPS tax is not applied in Amount field when detail IEPS flag is enabled for the retailer')

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Do_You_Want_To_Print_Invoicing_Without_Preticket_OK_Button'), 0)
Mobile.delay(30)
Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'), 0)

def Print_Preview_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)
def Invoice_Sheet_Text = Mobile.getText(findTestObject('Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)
println(Invoice_Sheet_Text)

def GrossAmt = Double.parseDouble(pieces) * Double.parseDouble(U_Price_Value)
println GrossAmt
def itemDiscount = CustomKeywords.'com.ty.keywords.MobileKeywords.itemNil'(GrossAmt)
println itemDiscount
def secondGrossAmt = GrossAmt - itemDiscount
println secondGrossAmt
def catDiscount = CustomKeywords.'com.ty.keywords.MobileKeywords.category10_Percent'(secondGrossAmt)
println catDiscount
def totalPrice = secondGrossAmt - catDiscount
println totalPrice
def totalDiscount1 = itemDiscount + catDiscount
println totalDiscount1

Mobile.verifyGreaterThan(U_Price_Value, Actual_Amount_Value, FailureHandling.STOP_ON_FAILURE)

boolean Value = Invoice_Sheet_Text.contains(Actual_Amount)

//Amount Calculation
double Expected_Amount_Value = Double.parseDouble(UnitPrice) - Double.parseDouble(Actual_Amount)
println Expected_Amount_Value

//Verification to check that Actual Amount value and calculated Expected Amount value is displayed accoridng to the calculation
Mobile.verifyEqual(Actual_Amount_Value, Expected_Amount_Value.toString(), FailureHandling.STOP_ON_FAILURE)

//Verification to check that calculated Discount amount is displayed in the print preview page
Mobile.verifyMatch(Value.toString(), findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(2, 98), false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/ProductBuyingDeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC60_Expected_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()