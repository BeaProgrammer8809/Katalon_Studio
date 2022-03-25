import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        2, 7), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        3, 7), 0)

def Invoice_Qty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

def schemeBuyQty = findTestData('Phase2/TY_05/Applying_Scheme').getValue(3, 7)

Mobile.verifyEqual(Invoice_Qty, schemeBuyQty, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

/*AppiumDriver driver = MobileDriverFactory.getDriver()
 
 List<WebElement> viewbutton = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/btn_show_free_products')
 
 def SizeofViewButton = viewbutton.size()
 
 viewbutton.get(0).click()*/

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_05').getValue(7, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        4, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        5, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        9, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        6, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        8, 7))

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        7, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        10, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BISlabScreen/Done_Button'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

//viewbutton.get(1).click()

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_05').getValue(7, 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        11, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        12, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        16, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        13, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        15, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        14, 7), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        17, 7), FailureHandling.STOP_ON_FAILURE)

println('Slab3 and slab2 should be applied successfully and above details should be displayed on applying scheme screen')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_40'], FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()

