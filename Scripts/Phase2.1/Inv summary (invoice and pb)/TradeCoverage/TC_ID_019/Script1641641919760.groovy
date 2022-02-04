import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 3)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 18)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

def actualInvoicedSKU = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

println('Actual invoiced sku is ' + actualInvoicedSKU)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def actualInvoicedQty = Mobile.getAttribute(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 'text', 
    0)

println('Actual inoviced qty for sku is ' + actualInvoicedQty)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 7)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), findTestData('Phase2/Common_Data/CommonData_03').getValue(
        6, 19), 0)

def actualProductBuyingSKU = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Scheme_Buy_SKU_Text_View'), 0)

println('Actual product buying sku is ' + actualProductBuyingSKU)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

def actualProductBuyingQty = Mobile.getAttribute(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 'text', 
    0)

println('Actual product buying qty is ' + actualProductBuyingQty)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

def v1 = Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)

println('Is screen title displayed as Summary? ' + v1)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def actualSalesReturnQty = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

def expectedInvoicedSKU = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

println('Expected invoiced sku is ' + expectedInvoicedSKU)

Mobile.verifyEqual(actualInvoicedSKU, expectedInvoicedSKU, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def expectedInvoicedQty = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println('Expected invoiced qty is ' + expectedInvoicedQty)

Mobile.verifyEqual(actualInvoicedQty, expectedInvoicedQty, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

def expectedSalesReturnQty = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

println('Expected Sales Return qty is ' + expectedSalesReturnQty)

Mobile.verifyEqual(actualSalesReturnQty, expectedSalesReturnQty, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def actualProductBuyingInvoicedQty = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

def expectedProductBuyingSKU = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

println('Expected product buying sku is ' + expectedProductBuyingSKU)

Mobile.verifyEqual(actualProductBuyingSKU, expectedProductBuyingSKU, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def expectedProductBuyingInvoicedQty = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

println('Expected product buying invoiced qty is ' + expectedProductBuyingInvoicedQty)

Mobile.verifyEqual(actualProductBuyingInvoicedQty, expectedProductBuyingInvoicedQty, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

def expectedProductBuyingSalesReturnQty = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

println('Expected Product buying Sales Return qty is ' + expectedProductBuyingSalesReturnQty)

Mobile.verifyEqual(actualProductBuyingQty, expectedProductBuyingSalesReturnQty, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv summary (invoice and pb)/TradeCoverage/Screenshot'), 
    [('testCaseName') : 'TC_ID_019_SummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

