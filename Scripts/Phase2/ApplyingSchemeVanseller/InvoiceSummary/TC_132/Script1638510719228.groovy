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
Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Credit'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(3, 12), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.takeScreenshot()

/*Verification to check 1.Scheme buy sku is displayed with order qty and order price, 2.Scheme get sku is displayed with get qty but 0 price, 3.Below details is displayed on invoice summary screen
 Scheme buy sku :001_lak_qt pieces=1 order price=pieces*unit price, Scheme get sku:002_lak_qt pieces=2 order price=0"*/
GlobalVariable.Buysku = findTestData('Phase2/Common_Data/CommonData_02').getValue('Buysku', 1)
GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_02').getValue('Getsku', 1)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)


def ActualBUYSKUName = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 30, FailureHandling.STOP_ON_FAILURE)
println(ActualBUYSKUName)
def ActualBUYSKUPiece = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 30, FailureHandling.STOP_ON_FAILURE)
println(ActualBUYSKUPiece)
def ActualBUYOrderQty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'),30, FailureHandling.STOP_ON_FAILURE)
println(ActualBUYOrderQty)
def ActualBUYSKUUnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 30, FailureHandling.STOP_ON_FAILURE)
println(ActualBUYSKUUnitPrice)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def ActualGETSKUName = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'), 30, FailureHandling.STOP_ON_FAILURE)
println(ActualGETSKUName)
def ActualGETSKUOrder_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'), 30, FailureHandling.STOP_ON_FAILURE)
println(ActualGETSKUOrder_Qty)

//Formula
def Expected_BUY_Order_Qty = Integer.parseInt(ActualBUYSKUPiece) * Float.parseFloat(ActualBUYSKUUnitPrice)
println(Expected_BUY_Order_Qty)
DecimalFormat df = new DecimalFormat('0.00')
Expected_BUY_Order_Qty = df.format(Expected_BUY_Order_Qty)
println(Expected_BUY_Order_Qty)

def Expected_BUY_SKU_Name = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(14, 12)
def Expected_GET_SKU_Name = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(5, 12)
def Expected_GET_SKU_Order_Qty = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(7, 12)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(ActualBUYSKUName, Expected_BUY_SKU_Name, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(ActualBUYOrderQty, Expected_BUY_Order_Qty, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(ActualGETSKUName, Expected_GET_SKU_Name, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyEqual(ActualGETSKUOrder_Qty, Expected_GET_SKU_Order_Qty, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_132'], FailureHandling.STOP_ON_FAILURE)
Mobile.closeApplication()

