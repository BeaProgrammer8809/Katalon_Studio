import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

for (def i = 0; i < 2; i++) {
    if (i == 0) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 16)
    } else if (i == 1) {
        GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 17)
    }
    
    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

    Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

    Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Cancel_Button'), 0)
}

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def piecesSKU1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println(piecesSKU1)

def uPriceSKU1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

println(uPriceSKU1)

def DiscountedPriceSKU1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(DiscountedPriceSKU1)

def returnQtySKU1 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 
    0)

println(returnQtySKU1)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def piecesSKU2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println(piecesSKU2)

def uPriceSKU2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

println(uPriceSKU2)

def DiscountedPriceSKU2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

println(DiscountedPriceSKU2)

def returnQtySKU2 = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 
    0)

println(returnQtySKU2)

def actualValue = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println(actualValue)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/I_Icon'), 0)

def actualTotalDiscountForSKU = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/CompDisc_Value'), 
    0)

def splitDisc = actualTotalDiscountForSKU.split(' ')

actualTotalDiscountForSKU = (splitDisc[1])

println('Actual composite discount for sku is ' + actualTotalDiscountForSKU)

def actualOrderValueForSKU = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/OrderValue_Value'), 
    0)

println('Actual order value is ' + actualOrderValueForSKU)

def actualInvoicedPriceForSKU = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Total_Value'), 
    0)

println('Actual discounted price for sku is ' + actualInvoicedPriceForSKU)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIAmountSplitUpPopup01/Close_Button'), 0)

def totalPrice = Integer.parseInt(piecesSKU1) * Double.parseDouble(uPriceSKU1)

println(totalPrice)

Mobile.verifyEqual(DiscountedPriceSKU1, totalPrice, FailureHandling.STOP_ON_FAILURE)

println('Replacemenmt qty is not included in total price calculation')

totalPrice = Integer.parseInt(piecesSKU2) * Double.parseDouble(uPriceSKU2)

println(totalPrice)

Mobile.verifyEqual(DiscountedPriceSKU2, totalPrice, FailureHandling.STOP_ON_FAILURE)

println('Replacemenmt qty is not included in total price calculation')

double totalSum = Double.parseDouble(DiscountedPriceSKU1) + Double.parseDouble(DiscountedPriceSKU2)

println(totalSum)

double tax = Double.parseDouble(actualOrderValueForSKU) - totalSum

println('IEPS Tax applied for these products is ' + tax)

def ExpectedValue = (totalSum - Double.parseDouble(actualTotalDiscountForSKU)) + tax

DecimalFormat df = new DecimalFormat('0.00')

ExpectedValue = df.format(ExpectedValue)

println(ExpectedValue)

Mobile.verifyEqual(actualValue, ExpectedValue, FailureHandling.STOP_ON_FAILURE)

println('The Value field amount should be updated based on invoiced Sku amount, Tax for invoiced sku and ' + 'discount applied for invoiced sku without considering the replacement sku amount.')

def actualTaxPercentage = findTestData('Phase2.1/CommonData/CommonData').getValue(18, 1)

def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(tax,totalSum)

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage, false, FailureHandling.STOP_ON_FAILURE)

println "Tax IEPS is applied for sku"

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC96_InvoiceSummary'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PrintPreticket_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PreTicket_Created_Successfully_Ok_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/PreTicket_Print_Preview_Title'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC96_PrintPreviewScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

