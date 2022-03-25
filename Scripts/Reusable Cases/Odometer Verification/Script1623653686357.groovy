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

if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Odometer Journey not started'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/OK'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Back Arrow'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Home Screen/Menu Button'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Start of the day'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Odometer/Odometer'), 0)

    Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Odometer/Enter Time Field'), '111', 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Odometer/Start Journey Button'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/OK'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Home Screen/Menu Button'), 0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search icon'), 0)

    Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search field'), findTestData('Phase 1/Anen/Product Buying Screen/Product Buying Screen TD').getValue(
            'retailer', 1), 0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/1st Seller Name'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Start Visit'), 0)
}
