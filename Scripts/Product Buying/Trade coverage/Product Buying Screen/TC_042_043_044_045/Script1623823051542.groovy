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

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Funnel Filter'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/MARCA Title'), 'MARCA')

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/MARCA Title'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_042_1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st row - Copy'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca Tick1'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st Row tick'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_042_2'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/CATEGORA Title'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_043_1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st row - Copy'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Catagory Tick'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st Row tick'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_043_2'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/SEGMENTO Title'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_044_1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st row - Copy'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Segmento Tick'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st Row tick'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_044_2'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/LNEA Title'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_045_1'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st row - Copy'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Clear Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Linea Tick'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Porduct Buy Filter/Marca 1st Row tick'), 0)

Mobile.callTestCase(findTestCase('Product Buying/Trade coverage/Product Buying Screen/Screenshot'), [('testCaseName') : 'TC_045_2'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

