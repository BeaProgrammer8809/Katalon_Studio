import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

GlobalVariable.SchemeName = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(4, 6)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(5, 6)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(6, 6)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/TY_03/TestData_Phase2.1').getValue(3, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 
    0)

Mobile.longPress(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

def schemeName = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeName'), 0)

println(schemeName)

def buySKUName = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0)

println(buySKUName)

def getSKUName = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeGetProductName_value'), 0)

println(getSKUName)

Mobile.callTestCase(findTestCase('Phase2.1\\Inv Summary(Only PB)\\TradeCoverage/ScreenShot'), [('testCaseName') : 'TC_023_SchemeScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.verifyMatch(buySKUName, GlobalVariable.ProductName, false, FailureHandling.STOP_ON_FAILURE)

println('Scheme product is used for product buying ')

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BISchemeScreen01/SchemeGetProductName_value'), 0, FailureHandling.STOP_ON_FAILURE)

println('scheme is not applied for product buying sku')

Mobile.callTestCase(findTestCase('Phase2.1\\Inv Summary(Only PB)\\TradeCoverage/ScreenShot'), [('testCaseName') : 'TC_023_InvoiceSummary'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

