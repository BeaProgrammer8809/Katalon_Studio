import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        2, 2), 0)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/Common_Data/CommonData_05').getValue(4, 2)

println(GlobalVariable.SchemeBuySkuName)

GlobalVariable.SchemeName = findTestData('Phase2/Common_Data/CommonData_05').getValue(5, 2)

println(GlobalVariable.SchemeName)

GlobalVariable.SchemeGetSkuName = findTestData('Phase2/Common_Data/CommonData_05').getValue(6, 2)

println(GlobalVariable.SchemeGetSkuName)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_10A'], FailureHandling.STOP_ON_FAILURE)


'SchemeName'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeName'), 0))

'SchemeBuySKU_Name'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0))

'SlabName'
println(Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB 1_Header'), 0))

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println('Scheme buy qty ' + schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        3, 2), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button'), 0)

def ActualGetSku = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println('Actualresult=' + ActualGetSku)

def ExpectedGetSku = findTestData('Phase2/TY_05/Applying_Scheme').getValue(4, 2)

println('Expectedresult=' + ExpectedGetSku)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyEqual(ActualGetSku, ExpectedGetSku, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

def ActualBuySku = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyNotMatch(ActualBuySku, ExpectedGetSku, false)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

def PromotionSlab = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

def ExpectedPromotionSlab = findTestData('Phase2/TY_05/Applying_Scheme').getValue(5, 1)

Mobile.verifyMatch(PromotionSlab, ExpectedPromotionSlab, false)

println('Scheme get sku should  be displayed on promotion slab screen')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_10'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

