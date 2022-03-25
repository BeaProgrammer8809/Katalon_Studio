import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(
        2, 5), 0)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(17, 5)

println(GlobalVariable.SchemeBuySkuName)

GlobalVariable.SchemeName = findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(19, 5)

println(GlobalVariable.SchemeName)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(18, 5)

println(GlobalVariable.SchemeGetSkuName1)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_28_SchemeDetails'], FailureHandling.STOP_ON_FAILURE)

'SchemeName'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeName'), 0))

'SchemeBuySKU_Name'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0))

def getSkuname = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SchemeGetProductName_value'), 
    0)

println(getSkuname)

'SlabName'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB 1_Header'), 0))

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println('Scheme buy qty' + schemeBuyQty)

def schemeGetQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_GetValue'), 0)

schemeGetQty = schemeGetQty.substring(0, 1)

println('Scheme get qty' + schemeGetQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def invoiceQty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

println(invoiceQty)

Mobile.verifyEqual(invoiceQty, schemeBuyQty, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//Verification for Applying screen title
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

def Actual_Scheme_BUY_SKU_Name = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(Actual_Scheme_BUY_SKU_Name)

def Actual_Scheme_Logic = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(Actual_Scheme_Logic)

def Actual_SIH_Value = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(Actual_SIH_Value)

def Actual_Get_Qty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(Actual_Get_Qty)

///Mobile.verifyEqual(Actual_Get_Qty, schemeGetQty, FailureHandling.STOP_ON_FAILURE)
def Expected_Scheme_Logic = findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(7, 5)

def Expected_SIH_Value = findTestData('Phase2/TY_07/Applying Scheme/Execute').getValue(8, 5)

Mobile.verifyEqual(Actual_Scheme_BUY_SKU_Name, getSkuname, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_Scheme_Logic, Expected_Scheme_Logic, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_SIH_Value, Expected_SIH_Value, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_Get_Qty, schemeGetQty, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_28'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
