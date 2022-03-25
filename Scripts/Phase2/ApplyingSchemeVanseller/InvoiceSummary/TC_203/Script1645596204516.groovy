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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(6, 53)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('Scheme is applied for sku')

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def buySkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def buySkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def buySkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 2)

def getSkuQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 
    0)

def getSkuTotalPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 
    0)

def getSkuUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 
    0)

def expGetPrice = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10)

Mobile.verifyEqual(getSkuTotalPrice, expGetPrice, FailureHandling.STOP_ON_FAILURE)

println('Get sku total price is zero as expected')

//Discount Calculation

def GrossAmt = Double.parseDouble(buySkuUnitPrice) * Double.parseDouble(buySkuQty)

def itemDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.item10_Percent'(GrossAmt)


def GrossAmtAfterItemDisc=GrossAmt-itemDisc

def categoryDisc = CustomKeywords.'com.ty.keywords.MobileKeywords.category10_Percent'(GrossAmtAfterItemDisc)

double amountAfterCategoryDisc= GrossAmtAfterItemDisc-categoryDisc

DecimalFormat df = new DecimalFormat('0.00')

expTotalPrice = df.format(amountAfterCategoryDisc)

Mobile.verifyEqual(buySkuTotalPrice, expTotalPrice, FailureHandling.STOP_ON_FAILURE)

println('Item and Category discount is included in total price calculation')

def totalSum = Double.parseDouble(buySkuTotalPrice)

def IVAtax = CustomKeywords.'com.ty.keywords.MobileKeywords.taxIVA'(totalSum)

def expTotalPrice2 = expTotalPrice +IVAtax

Mobile.verifyNotEqual(buySkuTotalPrice, expTotalPrice2, FailureHandling.STOP_ON_FAILURE)

println('Tax IVA is not included in total price calculation')

def actualTaxPercentage = findTestData('Phase2.1/Common_Data/CommonData').getValue(19, 1)

def expTaxPercentage = CustomKeywords.'com.ty.keywords.MobileKeywords.taxPercentage'(IVAtax, totalSum)

Mobile.verifyMatch(actualTaxPercentage, expTaxPercentage.toString(), false, FailureHandling.STOP_ON_FAILURE)

println('Tax IVA is applied for sku')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_203'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

