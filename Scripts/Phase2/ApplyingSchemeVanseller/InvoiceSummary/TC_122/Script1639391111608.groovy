import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable


Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/OdometerAndVanload'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_11/TestData').getValue(
		2, 1), 0)

GlobalVariable.Buysku = findTestData('Phase2/TY_11/TestData').getValue(2, 1)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_11/TestData').getValue(2, 1)

GlobalVariable.SchemeName = findTestData('Phase2/TY_11/TestData').getValue(4, 1)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_122_SchemeDetails'],
	FailureHandling.STOP_ON_FAILURE)

'SchemeName'
println(Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/Scheme_header_Textview'), 0))

'SchemeBuySKU_Name'
println(Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0))

'SlabName'
println(Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB 1_Header'), 0))

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println(schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Object Repository/Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = schemeBuyQty

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def orderQuantity = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.verifyEqual(schemeBuyQty, orderQuantity, FailureHandling.STOP_ON_FAILURE)

println('Entering order quantity equal to scheme buy quantity')

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)


def UnitPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/U.Price_Value_Indexing'), 0)

def ExpectedOrderPrice = Integer.parseInt(orderQuantity) * Float.parseFloat(UnitPrice)

DecimalFormat df = new DecimalFormat('0.00')

ExpectedOrderPrice = df.format(ExpectedOrderPrice)

println(ExpectedOrderPrice)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def ActualOrderPrice = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

Mobile.verifyEqual(ActualOrderPrice, ExpectedOrderPrice, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_122'],
	FailureHandling.STOP_ON_FAILURE)
Mobile.closeApplication()
