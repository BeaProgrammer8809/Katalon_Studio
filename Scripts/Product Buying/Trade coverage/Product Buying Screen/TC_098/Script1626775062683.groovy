import com.google.common.io.Files as Files
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import io.appium.java_client.MobileElement as MobileElement
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By

CustomKeywords.'anen.webUILogin04.catalog_Login'()

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Master'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Master'))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Store Management'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Store Management'))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Store Master'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Store Master'))

WebUI.delay(5)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('GroupName', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_1'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_GroupManager'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('SalesDirector', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_2'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_SalesDirector'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('regionalSM', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_3'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_RegionSalesManager'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('SM', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_4'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_SalesManager'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('DM', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_5'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_DivisionalManager'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

GlobalVariable.mAttributetext = findTestData('Phase 1/Anen/Web/Route Manager').getValue('centro', 1)

println(GlobalVariable.mAttributetext)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input__select-dropdown_6'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Store Management/Advance Search Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Store Management/input_Retailer Search Name'), 0)

WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Store Management/input_Retailer Search Name'), findTestData('Phase 1/Anen/Product Buying Screen/Product Buying Screen TD').getValue(
        'deactivated_Sku', 1))

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Store Management/button_Search Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Store Management/button_Deactivated'))

WebUI.delay(3)

store_Name = WebUI.getText(findTestObject('Phase 1.1/Resource1/Web/Store Management/value_1st Row StoreName'))

store_Name

WebUI.delay(3)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Home Screen/Menu Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

route_Name = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/RouteName'), 0)

println(route_Name)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search icon'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search field'), findTestData('Phase 1/Anen/Product Buying Screen/Product Buying Screen TD').getValue(
        'retailer', 1), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/1st Seller Name'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Start Visit'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search Icon'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), store_Name)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), '  ')

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Sku name 1st row - Copy'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_098'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

