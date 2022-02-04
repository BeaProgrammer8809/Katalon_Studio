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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2/Common_Data/CommonData').getValue(2, 21)], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 15)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 3)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def SkuName = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 
    0)

println('Sku name is ' + SkuName)

def ProductBuyQty = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'), 
    0)

def UnitPrice = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

DecimalFormat df = new DecimalFormat('0.00')

def totalValue = Double.parseDouble(UnitPrice) * Double.parseDouble(ProductBuyQty)

totalValue = df.format(totalValue)

println totalValue

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

def skuQty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_Indexing'), 
    0)

def amount1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIDeliveryFinalSummaryScreen/Amount_Value_Indexing'), 
    0)

def discount = Double.parseDouble(totalValue) - Double.parseDouble(amount1)

Mobile.verifyNotEqual(totalValue, amount1, FailureHandling.STOP_ON_FAILURE)

println "Item discount is applied for sku"

def actualTax = Double.parseDouble(amount1) + discount - Double.parseDouble(totalValue)

actualTax=df.format(actualTax)

def expAmount=Double.parseDouble(totalValue)-(discount) + Double.parseDouble(actualTax)
 
expAmount=df.format(expAmount)

Mobile.verifyEqual(amount1, expAmount, FailureHandling.STOP_ON_FAILURE)

println "Amount is as expected"

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitOnlyPB/ProductBuyingDeliveryFinalSummary/Screenshot'), ['testCaseName':'TC_67_DeliveryFinalSummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
