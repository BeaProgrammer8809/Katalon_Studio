import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_04/Applying_Scheme').getValue(
        2, 5), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_04/Applying_Scheme').getValue(
        3, 5), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

def Actual = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println('Actualresult=' + Actual)

def Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(7, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Slab2 is displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(11, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Scheme buy sku should displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(9, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('SIH value should displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(6, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Get quatity is displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(5, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Maximum values is displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(4, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Minimum values is displayed')

Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(8, 5)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Screen should be navigated to Applying scheme screen')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_30'], FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()

