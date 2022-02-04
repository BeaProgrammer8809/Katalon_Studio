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

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv summary_invoice and pb/Cash Retailer Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC01'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC02'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Next Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC03'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

