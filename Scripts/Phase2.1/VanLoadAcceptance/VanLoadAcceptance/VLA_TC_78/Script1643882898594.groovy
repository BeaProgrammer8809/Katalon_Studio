import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 15), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 15)], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.OPTIONAL)
Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOdometer01/Start_Trip_Reading_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(1, 1), 0)
Mobile.tap(findTestObject('Phase2/BIOdometer01/Start_Journey_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase 1.1/Resource3/Order and Invoice/Menu/Menu_Trade Coverage'), 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/btn_Search'), 0)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(3, 3)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'),0)

//Verification to check the alert popup is displayed as per expected 
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIStoreScreen01/VanLoadAcceptamceIsNotDone_PopupTitle'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_78_Actual_Alert_Message'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()