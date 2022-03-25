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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_11/TestData').getValue(
		2, 1), 0)

GlobalVariable.Buysku = findTestData('Phase2/TY_11/TestData').getValue(2, 5)

GlobalVariable.Getsku = findTestData('Phase2/TY_11/TestData').getValue(2, 5)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_11/TestData').getValue(2, 5)

GlobalVariable.SchemeName = findTestData('Phase2/TY_11/TestData').getValue(4, 5)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_11/TestData').getValue(2, 5)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_126_SchemeDetails'],
	FailureHandling.STOP_ON_FAILURE)

'SchemeName'
def SchemeName = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0)

println(SchemeName)

'SchemeBuySKU_Name'
println(Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0))

'SlabName'
println(Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB 1_Header'), 0))

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println(schemeBuyQty)

def schemeGetQty = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_GetValue'), 0)

schemeGetQty = schemeGetQty.substring(0, 1)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

GlobalVariable.Number = schemeBuyQty

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def orderQuantity = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.verifyEqual(schemeBuyQty, orderQuantity, FailureHandling.STOP_ON_FAILURE)

println('Entering order quantity equal to scheme buy quantity')

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0)

def ActualUnitPrice= Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0)

def ExpectedUnitPrice=findTestData('Phase2/TY_11/TestData').getValue(5, 5)

Mobile.verifyMatch(ActualUnitPrice, ExpectedUnitPrice, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

def ActualschemeGetQty= Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'), 0)

Mobile.verifyMatch(ActualschemeGetQty, schemeGetQty, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_126'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
