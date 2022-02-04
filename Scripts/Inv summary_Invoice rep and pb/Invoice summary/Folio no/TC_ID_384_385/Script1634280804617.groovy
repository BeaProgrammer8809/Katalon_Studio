import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.AppiumDriver as AppiumDriver
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

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Reusable Cases/Order_Invoice_Inv Summary_Return'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    '', 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_386'], 
    FailureHandling.STOP_ON_FAILURE)

txtFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

println(txtFolioNo)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_177_393'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

String returntoastmsg1 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(returntoastmsg1)

Mobile.verifyMatch('Please enter folio number', returntoastmsg1, false)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    '123456', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    'Default ProdBuy')

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    0)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

String returntoastmsg2 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(returntoastmsg2)

Mobile.verifyMatch('Please enter folio number', returntoastmsg2, false)

Mobile.closeApplication()

