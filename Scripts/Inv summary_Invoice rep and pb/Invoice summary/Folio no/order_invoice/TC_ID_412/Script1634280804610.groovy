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

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

int userInputsize = folioNo.length()

println(userInputsize)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    folioNo, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

println(inputFolioNo)

folioNoLength = inputFolioNo.length()

Mobile.verifyEqual(userInputsize, folioNoLength, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

String returntoastmsg = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(returntoastmsg)

Mobile.verifyMatch('Folio number should be atleast 6 characters', returntoastmsg, false)

Mobile.delay(0, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    '123456', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    folioNo, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputProdBuy = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

println(inputProdBuy)

folioProdBuyLength = inputProdBuy.length()

Mobile.verifyEqual(userInputsize, folioProdBuyLength, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/btn_Create Final Invoice'), 
    0)

String returntoastmsg1 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(returntoastmsg1)

Mobile.verifyMatch('Folio number should be atleast 6 characters', returntoastmsg1, false)

Mobile.closeApplication()

