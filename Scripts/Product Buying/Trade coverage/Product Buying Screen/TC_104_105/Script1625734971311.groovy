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

skuName = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Sku name 1st row - Copy'), 0)

println(skuName)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_104_105'], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'anen.webUILogin04.l1_Login'()

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Master'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Master'))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Route Management'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Route Management'))

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Route Master'), 0)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Route Master'))

WebUI.delay(3)

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

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/span_CenterDeVentes'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input_RouteName'), 0)

WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/input_RouteName'), route_Name)

route_Value = WebUI.getText(findTestObject('Phase 1.1/Resource1/Web/Route Master Screen/text_RouteValue'), FailureHandling.STOP_ON_FAILURE)

println(route_Value)

WebUI.delay(2)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Menu/menu_Route Type Master'))

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/input_RouteValueSearch'), route_Value)

WebUI.delay(3)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/1st Row'))

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/button_View'))

WebUI.delay(10)

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/select_Catagory'))

WebUI.click(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/select_Marca Dropdown'))

WebUI.delay(3)

skuName = skuName.substring(skuName.indexOf('_') + 4, skuName.length())

println(skuName)

WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/input_umppedsearch'), skuName)

WebUI.sendKeys(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/input_mappedsearchbar'), skuName)

WebUI.delay(3)

WebUI.verifyElementNotPresent(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/umappedSku'), 0)

WebUI.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Web/Route Type Master/View/mappedSku'))

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

