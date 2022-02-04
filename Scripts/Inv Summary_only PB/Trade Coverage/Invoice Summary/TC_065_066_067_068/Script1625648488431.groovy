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

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Done Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Invoice Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/OK Button Popup'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Invoice created successfully Message popup'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/OK Button 2 popup'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Folio No. Title'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Folio No. Title'), 'Folio No.')

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), '123456789123', 
    0)

Mobile.callTestCase(findTestCase('Inv Summary_only PB/Trade Coverage/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_065'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), '123', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Create Final Invoice Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Delivery Final Summary Screen Title'), 
    'Delivery Final Summary', FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv Summary_only PB/Trade Coverage/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_066_067'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), '1.23', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Create Final Invoice Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv Summary_only PB/Trade Coverage/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_068(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 'a12', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Create Final Invoice Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv Summary_only PB/Trade Coverage/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_068(2)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Folio Input Field'), '1 23', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/Create Final Invoice Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv Summary_only PB/Trade Coverage/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_068(3)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

