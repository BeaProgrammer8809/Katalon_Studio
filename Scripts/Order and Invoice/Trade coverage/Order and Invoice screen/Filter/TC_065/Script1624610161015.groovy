import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/title_Order and  Invoice'), 
    0)

Mobile.delay(4)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal filter_Icon'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_SEGMENTO'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_SEGMENTO'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/filterItem_SEGMENTO'), 
    0)

txtSegmentData = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/first Data'), 
    0)

println(txtSegmentData)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

List<MobileElement> greenTickCount = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/selectedfilters')

int beforeSelectfilter = greenTickCount.size()

println(beforeSelectfilter)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/Green Selected Filter'), 
    0)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_065_BeforeSelect'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/first Data'), 
    0)

List<MobileElement> greenTickCount1 = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/selectedfilters')

int afterSelectfilter = greenTickCount1.size()

println(afterSelectfilter)

Mobile.verifyNotEqual(beforeSelectfilter, afterSelectfilter, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_065_AfterSelect'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/Green Selected Filter'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/second Data'), 
    0)

txtNewSegmentData = Mobile.getText(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Activities Screeen/Order And Invoice Screen/Normal Filter/Green Tick Icon/second Data'), 
    0)

println('previously selected skus segment should be unselected and the new skus segment should be selected.' + txtNewSegmentData)

Mobile.verifyNotMatch(txtSegmentData, txtNewSegmentData, false, FailureHandling.STOP_ON_FAILURE)

List<MobileElement> greenTickCount2 = driver.findElementsById('com.ivy.bimbomx.mexico.view:id/selectedfilters')

int selectOtherBrand = greenTickCount2.size()

println(selectOtherBrand)

Mobile.verifyEqual(afterSelectfilter, selectOtherBrand, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Order and Invoice/Trade coverage/Order and Invoice screen/Screenshot'), [('testCaseName') : 'TC_065_SelectOtherBrand'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

