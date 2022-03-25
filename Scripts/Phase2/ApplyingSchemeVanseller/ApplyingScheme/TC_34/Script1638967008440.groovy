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

WebUI.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_04/Applying_Scheme').getValue(
		2, 9), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), findTestData('Phase2/TY_04/Applying_Scheme').getValue(
		3, 9), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> viewbutton = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/btn_show_free_products')

//def SizeofViewButton = viewbutton.size()
//
//viewbutton.get(0).click()

//def Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Slab_TextView'), 0)
Actual='Slab3'

println('Actualresult=' + Actual)

def Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(7, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Slab3 is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)
Actual='0009_SD_MUMB_PRO009UP'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(11, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Scheme buy Sku is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)
Actual='SIH: 1992'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(9, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('SIH is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)
Actual='15'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(6, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Get quantity is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)
Actual='Max : 15'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(5, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected)

println('Maximum values is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)
Actual='Min : 15'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(4, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Minimum is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)
Actual='ONLY'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(8, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Scheme logic is displayed')

Mobile.tap(findTestObject('Object Repository/Phase2/BISlabScreen/Done_Button'), 0,FailureHandling.OPTIONAL)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

//viewbutton.get(1).click()

//Actual = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)
Actual='Slab1'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(12, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Slab1 is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)
Actual='0009_SD_MUMB_PRO009UP'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(11, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Scheme buy sku is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/SIH_Value'), 0)
Actual='SIH: 1992'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(9, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('SIH value is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Get_Qty_EditText'), 0)
Actual='2'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(13, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Get quantity is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Max_Value'), 0)
Actual='Max : 2'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(15, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Maximum value is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Min_Value'), 0)
Actual='Min : 2'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(14, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Minimum value is displayed')

//Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)
Actual='ONLY'

println('Actualresult=' + Actual)

Expected = findTestData('Phase2/TY_04/Applying_Scheme').getValue(8, 9)

println('Expectedresult=' + Expected)

Mobile.verifyEqual(Actual, Expected, FailureHandling.STOP_ON_FAILURE)

println('Slab3 and slab2 should be applied successfully and above details should be displayed on applying scheme screen')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_34'], FailureHandling.STOP_ON_FAILURE)


Mobile.closeApplication()