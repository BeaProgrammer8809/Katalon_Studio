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

Mobile.checkElement(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        2, 6), 0)


Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(
        3, 6), 0)

def Invoice_Qty=Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

def Scheme_qty=findTestData('Phase2/TY_05/Applying_Scheme').getValue(3, 6)

Mobile.verifyEqual(Invoice_Qty, Scheme_qty  ,FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index=findTestData('Phase2/Common_Data/CommonData_05').getValue(7, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(4, 6), FailureHandling.STOP_ON_FAILURE)

println('Slab3 is displayed')

Mobile.delay(2)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(5, 6) , FailureHandling.STOP_ON_FAILURE)

println('Scheme buy sku should displayed')


Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(9, 6), FailureHandling.STOP_ON_FAILURE)

println('SIH value should displayed')


Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(6, 6), FailureHandling.STOP_ON_FAILURE)

println('Get quatity is displayed')


Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(8, 6), FailureHandling.STOP_ON_FAILURE)

println('Maximum values is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(7, 6), FailureHandling.STOP_ON_FAILURE)

println('Minimum values is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), findTestData('Phase2/TY_05/Applying_Scheme').getValue(10, 6), FailureHandling.STOP_ON_FAILURE)

println('Screen should be navigated to Applying scheme screen')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_39'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

