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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_03/TestData').getValue(
        2, 5), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_6'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def ActualHeading = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

println(ActualHeading)

def ExpectedScreenTitle = findTestData('Phase2/TY_03/TestData').getValue(3, 5)

println(ExpectedScreenTitle)

Mobile.verifyEqual(ActualHeading, ExpectedScreenTitle, FailureHandling.STOP_ON_FAILURE)

println('Displaying Screen heading as expected')

def ActualSlabName = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Slab_Indexing'), 0)

println(ActualSlabName)

def ExpectedSlabName = findTestData('Phase2/TY_03/TestData').getValue(4, 5)

println(ExpectedSlabName)

Mobile.verifyEqual(ActualSlabName, ExpectedSlabName, FailureHandling.STOP_ON_FAILURE)

println('Displaying Slab name as expected')

def ActualSchemeName = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

println(ActualSchemeName)

def ExpectedSchemeName = findTestData('Phase2/TY_03/TestData').getValue(5, 5)

println(ExpectedSchemeName)

Mobile.verifyEqual(ActualSchemeName, ExpectedSchemeName, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme name as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_42A'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

def ActualSchemeSKU_name = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(ActualSchemeSKU_name)

def ExpectedSchemeSKU_name = findTestData('Phase2/TY_03/TestData').getValue(6, 5)

println(ExpectedSchemeSKU_name)

Mobile.verifyEqual(ActualSchemeSKU_name, ExpectedSchemeSKU_name, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme SKU name as expected')

def ActualSIH_Remaining = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(ActualSIH_Remaining)

def ExpectedSIH_Remaining = findTestData('Phase2/TY_03/TestData').getValue(7, 5)

println(ExpectedSIH_Remaining)

Mobile.verifyEqual(ActualSIH_Remaining, ExpectedSIH_Remaining, FailureHandling.OPTIONAL)

println('Displaying SIH remaining name as expected')

def ActualSchemeGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(ActualSchemeGetQty)

def ExpectedSchemeGetQty = findTestData('Phase2/TY_03/TestData').getValue(8, 5)

println(ExpectedSchemeGetQty)

Mobile.verifyEqual(ActualSchemeGetQty, ExpectedSchemeGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying SIH remaining name as expected')

def ActualSchemeLogicTextView = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(ActualSchemeLogicTextView)

def ExpectedSchemeLogicTextView = findTestData('Phase2/TY_03/TestData').getValue(9, 5)

println(ExpectedSchemeLogicTextView)

Mobile.verifyEqual(ActualSchemeLogicTextView, ExpectedSchemeLogicTextView, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme logic name as expected')

def ActualMinGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

println(ActualMinGetQty)

def ExpectedMinGetQty = findTestData('Phase2/TY_03/TestData').getValue(10, 5)

println(ExpectedMinGetQty)

Mobile.verifyEqual(ActualMinGetQty, ExpectedMinGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying minimum Get qty as expected')

def ActualMaxGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

println(ActualMaxGetQty)

def ExpectedMaxGetQty = findTestData('Phase2/TY_03/TestData').getValue(11, 5)

println(ExpectedMaxGetQty)

Mobile.verifyEqual(ActualMaxGetQty, ExpectedMaxGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying maximum Get qty as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_42'], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

