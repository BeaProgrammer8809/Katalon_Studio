import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.AndroidKeyCode as AndroidKeyCode
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

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

driver.pressKeyCode(AndroidKeyCode.SPACE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

println(inputFolioNo)

Mobile.verifyMatch('', inputFolioNo, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

driver.pressKeyCode(AndroidKeyCode.SPACE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

println(inputFolioNo)

Mobile.verifyMatch('', inputFolioNo, false)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    'ATTest', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

driver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_COMMA)

driver.pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_DOT)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

println(inputFolioNo)

Mobile.verifyMatch('ATTst', inputFolioNo, false)

if (Mobile.verifyMatch('ATTst', inputFolioNo, false, FailureHandling.STOP_ON_FAILURE)) {
    println('Special char not allowed except (-&_)')
}

Mobile.closeApplication()