import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_03/TestData').getValue(
		2, 10), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_8'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 1)

def ActualHeading = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

println(ActualHeading)

def ExpectedScreenTitle = findTestData('Phase2/TY_03/TestData').getValue(3, 10)

println(ExpectedScreenTitle)

Mobile.verifyEqual(ActualHeading, ExpectedScreenTitle, FailureHandling.STOP_ON_FAILURE)

println('Displaying Screen heading as expected')

def ActualSchemeName = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

println(ActualSchemeName)

def ExpectedSchemeName = findTestData('Phase2/TY_03/TestData').getValue(5, 10)

println(ExpectedSchemeName)

Mobile.verifyEqual(ActualSchemeName, ExpectedSchemeName, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme name as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_44_ApplyingScheme'], FailureHandling.STOP_ON_FAILURE)

if(Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0))
{
AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> elements = driver.findElementsById('com.ivy.bimbomx.mexico.view.uat:id/btn_show_free_products')

println('The size of elements is ::' + elements.size())

def size = elements.size()

elements.get(0).click()

// for (int i = 0; i < size; i++) {
println(size)

//for (int j = i; j < 1; j++) {
def ActualSlabName = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println(ActualSlabName)

def ExpectedSlabName1 = findTestData('Phase2/TY_03/TestData').getValue(4, 10)

Mobile.verifyEqual(ActualSlabName, ExpectedSlabName1, FailureHandling.STOP_ON_FAILURE)

println('Displaying Slab name as expected')

def ActualSchemeSKU_name = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(ActualSchemeSKU_name)

def ExpectedSchemeSKU_name = findTestData('Phase2/TY_03/TestData').getValue(6, 10)

println(ExpectedSchemeSKU_name)

Mobile.verifyEqual(ActualSchemeSKU_name, ExpectedSchemeSKU_name, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme SKU name as expected')

def ActualSIH_Remaining = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(ActualSIH_Remaining)

def ExpectedSIH_Remaining = findTestData('Phase2/TY_03/TestData').getValue(7, 10)

println(ExpectedSIH_Remaining)

Mobile.verifyEqual(ActualSIH_Remaining, ExpectedSIH_Remaining, FailureHandling.OPTIONAL)

println('Displaying SIH remaining name as expected')

def ActualSchemeGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(ActualSchemeGetQty)

def ExpectedSchemeGetQty = findTestData('Phase2/TY_03/TestData').getValue(8, 10)

println(ExpectedSchemeGetQty)

Mobile.verifyEqual(ActualSchemeGetQty, ExpectedSchemeGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying SIH remaining name as expected')

def ActualSchemeLogicTextView = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(ActualSchemeLogicTextView)

def ExpectedSchemeLogicTextView = findTestData('Phase2/TY_03/TestData').getValue(9, 10)

println(ExpectedSchemeLogicTextView)

Mobile.verifyEqual(ActualSchemeLogicTextView, ExpectedSchemeLogicTextView, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme logic name as expected')

def ActualMinGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

println(ActualMinGetQty)

def ExpectedMinGetQty = findTestData('Phase2/TY_03/TestData').getValue(10, 10)

println(ExpectedMinGetQty)

Mobile.verifyEqual(ActualMinGetQty, ExpectedMinGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying minimum Get qty as expected')

def ActualMaxGetQty = Mobile.getText(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

println(ActualMaxGetQty)

def ExpectedMaxGetQty = findTestData('Phase2/TY_03/TestData').getValue(11, 10)

println(ExpectedMaxGetQty)

Mobile.verifyEqual(ActualMaxGetQty, ExpectedMaxGetQty, FailureHandling.STOP_ON_FAILURE)

println('Displaying maximum Get qty as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_44_SlabScreen01'],
FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

elements.get(1).click()

def ActualSlabName2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println(ActualSlabName2)

def ExpectedSlabName2 = findTestData('Phase2/TY_03/TestData').getValue(4, 11)

println(ExpectedSlabName2)

Mobile.verifyEqual(ActualSlabName2, ExpectedSlabName2, FailureHandling.STOP_ON_FAILURE)

println('Displaying Slab name as expected')

def ActualSchemeSKU_name2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(ActualSchemeSKU_name2)

def ExpectedSchemeSKU_name2 = findTestData('Phase2/TY_03/TestData').getValue(6, 11)

println(ExpectedSchemeSKU_name2)

Mobile.verifyEqual(ActualSchemeSKU_name2, ExpectedSchemeSKU_name2, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme SKU name as expected')

def ActualSIH_Remaining2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(ActualSIH_Remaining2)

def ExpectedSIH_Remaining2 = findTestData('Phase2/TY_03/TestData').getValue(7, 11)

println(ExpectedSIH_Remaining2)

Mobile.verifyEqual(ActualSIH_Remaining2, ExpectedSIH_Remaining2, FailureHandling.OPTIONAL)

println('Displaying SIH remaining name as expected')

def ActualSchemeGetQty2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(ActualSchemeGetQty2)

def ExpectedSchemeGetQty2 = findTestData('Phase2/TY_03/TestData').getValue(8, 11)

println(ExpectedSchemeGetQty2)

Mobile.verifyEqual(ActualSchemeGetQty2, ExpectedSchemeGetQty2, FailureHandling.STOP_ON_FAILURE)

println('Displaying scheme Get qty as expected')

def ActualSchemeLogicTextView2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(ActualSchemeLogicTextView2)

def ExpectedSchemeLogicTextView2 = findTestData('Phase2/TY_03/TestData').getValue(9, 11)

println(ExpectedSchemeLogicTextView2)

Mobile.verifyEqual(ActualSchemeLogicTextView2, ExpectedSchemeLogicTextView2, FailureHandling.STOP_ON_FAILURE)

println('Displaying Scheme logic name as expected')

def ActualMinGetQty2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

println(ActualMinGetQty2)

def ExpectedMinGetQty2 = findTestData('Phase2/TY_03/TestData').getValue(10, 11)

println(ExpectedMinGetQty2)

Mobile.verifyEqual(ActualMinGetQty2, ExpectedMinGetQty2, FailureHandling.STOP_ON_FAILURE)

println('Displaying minimum Get qty as expected')

def ActualMaxGetQty2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

println(ActualMaxGetQty2)

def ExpectedMaxGetQty2 = findTestData('Phase2/TY_03/TestData').getValue(11, 11)

println(ExpectedMaxGetQty2)

Mobile.verifyEqual(ActualMaxGetQty2, ExpectedMaxGetQty2, FailureHandling.STOP_ON_FAILURE)

println('Displaying maximum Get qty as expected')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_44_2'],
FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

}

Mobile.closeApplication()

