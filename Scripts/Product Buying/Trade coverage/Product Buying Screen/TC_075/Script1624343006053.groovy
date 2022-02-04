import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import io.appium.java_client.MobileDriver as MobileDriver
import io.appium.java_client.MobileElement as MobileElement
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login'), [:], FailureHandling.STOP_ON_FAILURE)

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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Product Buying Screen Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

zero = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/0'), 0)

println(zero)

zero = Integer.parseInt(zero)

println(zero)

if ((zero % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

one = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

println(one)

one = Integer.parseInt(one)

println(one)

if ((one % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

two = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/2'), 0)

println(two)

two = Integer.parseInt(two)

println(two)

if ((two % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

three = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/3'), 0)

println(three)

three = Integer.parseInt(three)

println(three)

if ((three % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

four = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/4'), 0)

println(four)

four = Integer.parseInt(four)

println(four)

if ((four % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

five = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/5'), 0)

println(five)

five = Integer.parseInt(five)

println(five)

if ((five % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

six = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/6'), 0)

println(six)

six = Integer.parseInt(six)

println(six)

if ((six % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

seven = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/7'), 0)

println(seven)

seven = Integer.parseInt(seven)

println(seven)

if ((seven % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

eight = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/8'), 0)

println(eight)

eight = Integer.parseInt(eight)

println(eight)

if ((eight % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

nine = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/9'), 0)

nine = Integer.parseInt(nine)

println(nine)

if ((nine % 1) != 0) {
    System.out.println('not a integer')

    Mobile.verifyMatch('1', '0', false)
} else {
    System.out.println('integer')
}

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_075'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

