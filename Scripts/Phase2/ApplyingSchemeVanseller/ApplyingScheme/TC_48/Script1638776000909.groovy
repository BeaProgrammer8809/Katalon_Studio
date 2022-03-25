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
import org.testng.Assert as Assert

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(3, 7), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 5)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

def Actual_BUY_SKU_SIH_Value= Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0, FailureHandling.STOP_ON_FAILURE)
println Actual_BUY_SKU_SIH_Value
def Actual_Invoice_Qty=Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
println Actual_Invoice_Qty

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_48'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button'), 0)

/*Verification to check that "Scheme should be applied but only available SIH of get sku should be displayed on applying scheme screen
 1.Sku name:001_lak_qt,  2.Get qty=1, 3.SIH of get sku, 4.Group logic:Only, 5.Min:3 max:3"*/

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 2)

def Actual_GET_SKU_Name = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
println('SKU Name' + Actual_GET_SKU_Name)

def Actual_GET_SKU_SIH_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0, FailureHandling.STOP_ON_FAILURE)
println('SIH Value' + Actual_GET_SKU_SIH_Value)

def Actual_GET_SKU_SIH_Logic = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'),0, FailureHandling.STOP_ON_FAILURE)
println('SKU Logic' + Actual_GET_SKU_SIH_Logic)

def Actual_GET_SKU_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
println('SKU Qty' + Actual_GET_SKU_Qty)

def Actual_GET_SKU_MIN_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0, FailureHandling.STOP_ON_FAILURE)
println('MIN' + Actual_GET_SKU_MIN_Value)

def Actual_GET_SKU_MAX_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0, FailureHandling.STOP_ON_FAILURE)
println('MAX' + Actual_GET_SKU_MAX_Value)

def Expected_GET_SKU_Name = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(5, 7)
def Expected_GET_SKU_Qty = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(7, 7)
def Expected_GET_SKU_SIH_Logic = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(8, 7)
def Expected_GET_SKU_MIN_Value = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(9, 7)
def Expected_GET_SKU_MAX_Value = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(10, 7)
def Expected_GET_SKU_SIH_Value = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(6, 7)
def Expected_BUY_SKU_SIH_Value = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(20, 7)
def Expected_Invoice_Qty = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(19, 7)

Mobile.verifyMatch(Actual_GET_SKU_Name, Expected_GET_SKU_Name, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_Qty, Expected_GET_SKU_Qty, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_SIH_Logic, Expected_GET_SKU_SIH_Logic, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_MIN_Value, Expected_GET_SKU_MIN_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_MAX_Value, Expected_GET_SKU_MAX_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_SIH_Value, Expected_GET_SKU_SIH_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_BUY_SKU_SIH_Value, Expected_BUY_SKU_SIH_Value, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Invoice_Qty, Expected_Invoice_Qty, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_48B'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
