import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Actual_SIH_Value = Mobile.getText(findTestObject('Phase2/BIUnload/Salable/SIH_Indexing'), 0)

println(Actual_SIH_Value)

def Entering_OP_Value = Actual_SIH_Value + 1

println(Entering_OP_Value)

Mobile.setText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), Entering_OP_Value, 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1').getValue(5, 52)

println(Actual_Toast_Message)

println('OP text field is not taking the value greater then the actual SIH value')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Invoice Summary/Screenshot'), [('testCaseName') : 'TC_036_After_Entering_Value'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

