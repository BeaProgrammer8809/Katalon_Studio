import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import android.os.Build.*
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_03/TestData').getValue(2, 1)

println(GlobalVariable.SchemeBuySkuName)

GlobalVariable.SchemeName = findTestData('Phase2/TY_03/TestData').getValue(4, 1)

println(GlobalVariable.SchemeName)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_03/TestData').getValue(2, 1)

println(GlobalVariable.SchemeGetSkuName1)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.SchemeBuySkuName, 0)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_14_SchemeDetails'], 
    FailureHandling.STOP_ON_FAILURE)

'SchemeName'
println Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeName'), 0)

'SchemeBuySKU_Name'
println Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0)

'SlabName'
println Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB 1_Header'), 0)

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println"Scheme buy qty"+(schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 5)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0, FailureHandling.STOP_ON_FAILURE)

def replacementQty = Mobile.getText(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

println("Replacement qty is "+replacementQty)

Mobile.verifyEqual(replacementQty, schemeBuyQty, FailureHandling.STOP_ON_FAILURE)

println('Entering replacement qty equals to scheme buy qty')

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

def ActualScreenTitle = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

println(ActualScreenTitle)

def ExpectedScreenTitle = findTestData('Phase2/TY_03/TestData').getValue(3, 1)

println(ExpectedScreenTitle)

Mobile.verifyMatch(ActualScreenTitle, ExpectedScreenTitle, true, FailureHandling.STOP_ON_FAILURE)

println('Displaying screen title as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_14_summaryScreen'], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

