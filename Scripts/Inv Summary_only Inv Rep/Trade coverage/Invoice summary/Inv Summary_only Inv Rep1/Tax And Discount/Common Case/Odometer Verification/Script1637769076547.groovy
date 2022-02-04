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

if (Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer Journey not started'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile_Odometer_Popup_OK'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Store Profile Screen/Profile BackIcon'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Start of the day'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/menu_Odometer'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), 0)

    Mobile.hideKeyboard()

    Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/txt_startingKM'), '100', 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/btn_Start Journey'), 0)

    Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_Saved Successfully.'), 
        0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Start of the day/Odometer/odometer_Popup_OK'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 
        0)

    //retailerName = findTestData('Phase 1/Surendran/Order and Invoice/Retailer Mapping').getValue(1, 1)
    //println(retailerName)
    //GlobalVariable.RetailerName = local_retailerName

    Mobile.setText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/txt_Search'), 
        'MI', 0)

    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'), 
        0)
}