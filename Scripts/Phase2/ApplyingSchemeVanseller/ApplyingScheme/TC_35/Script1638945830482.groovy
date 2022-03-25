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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_01/Test_Data').getValue(
        2, 3), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_4'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//AppiumDriver driver = MobileDriverFactory.getDriver()
//
//List<WebElement> viewbutton = driver.findElementsByXPath('//android.widget.Button[@text=\'View\']')
//
//SizeofViewButton = viewbutton.size()

//viewbutton.get(0).click()

GlobalVariable.index=findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'),0)

//Verification to check Scheme is applied but only available SIH of get sku is displayed on applying scheme screen
def Actual_GET_SKU_Name1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('SKU Name' + Actual_GET_SKU_Name1)

def Actual_GET_SKU_SIH_Value1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('SIH Value' + Actual_GET_SKU_SIH_Value1)

def Actual_GET_SKU_SIH_Logic1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('SKU Logic' + Actual_GET_SKU_SIH_Logic1)

def Actual_GET_SKU_Qty1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println('SKU Qty' + Actual_GET_SKU_Qty1)

def Actual_GET_SKU_MIN_Value1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('MIN' + Actual_GET_SKU_MIN_Value1)

def Actual_GET_SKU_MAX_Value1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('MAX' + Actual_GET_SKU_MAX_Value1)

def Actual_SlabName1 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println(Actual_SlabName1)

def Expected_SlabName1 = findTestData('Phase2/TY_01/Test_Data').getValue(4, 3)

def Expected_GET_SKU_Name1 = findTestData('Phase2/TY_01/Test_Data').getValue(5, 3)

def Expected_GET_SKU_Qty1 = findTestData('Phase2/TY_01/Test_Data').getValue(6, 3)

def Expected_GET_SKU_SIH_Logic1 = findTestData('Phase2/TY_01/Test_Data').getValue(7, 3)

def Expected_GET_SKU_MIN_Value1 = findTestData('Phase2/TY_01/Test_Data').getValue(8, 3)

def Expected_GET_SKU_MAX_Value1 = findTestData('Phase2/TY_01/Test_Data').getValue(9, 3)

Mobile.verifyEqual(Actual_SlabName1, Expected_SlabName1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_Name1, Expected_GET_SKU_Name1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_Qty1, Expected_GET_SKU_Qty1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_SIH_Logic1, Expected_GET_SKU_SIH_Logic1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_MAX_Value1, Expected_GET_SKU_MAX_Value1, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_MIN_Value1, Expected_GET_SKU_MIN_Value1, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

//SizeofViewButton = viewbutton.size()
//
//viewbutton.get(1).click()
//Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View2'), 0)

GlobalVariable.index=findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'),0)


def Actual_GET_SKU_Name2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('SKU Name' + Actual_GET_SKU_Name2)

def Actual_GET_SKU_SIH_Value2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('SIH Value' + Actual_GET_SKU_SIH_Value2)

def Actual_GET_SKU_SIH_Logic2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('SKU Logic' + Actual_GET_SKU_SIH_Logic2)

def Actual_GET_SKU_Qty2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

println('SKU Qty' + Actual_GET_SKU_Qty2)

def Actual_GET_SKU_MIN_Value2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('MIN' + Actual_GET_SKU_MIN_Value2)

def Actual_GET_SKU_MAX_Value2 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0, FailureHandling.STOP_ON_FAILURE)

println('MAX' + Actual_GET_SKU_MAX_Value2)

def Actual_SlabName2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println(Actual_SlabName2)

def Expected_SlabName2 = findTestData('Phase2/TY_01/Test_Data').getValue(10, 3)

def Expected_GET_SKU_Name2 = findTestData('Phase2/TY_01/Test_Data').getValue(11, 3)

def Expected_GET_SKU_Qty2 = findTestData('Phase2/TY_01/Test_Data').getValue(12, 3)

def Expected_GET_SKU_SIH_Logic2 = findTestData('Phase2/TY_01/Test_Data').getValue(13, 3)

def Expected_GET_SKU_MIN_Value2 = findTestData('Phase2/TY_01/Test_Data').getValue(14, 3)

def Expected_GET_SKU_MAX_Value2 = findTestData('Phase2/TY_01/Test_Data').getValue(15, 3)

Mobile.verifyEqual(Actual_SlabName2, Expected_SlabName2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_Name2, Expected_GET_SKU_Name2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_Qty2, Expected_GET_SKU_Qty2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_SIH_Logic2, Expected_GET_SKU_SIH_Logic2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_MAX_Value2, Expected_GET_SKU_MAX_Value2, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Actual_GET_SKU_MIN_Value2, Expected_GET_SKU_MIN_Value2, FailureHandling.STOP_ON_FAILURE)


Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_35'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

