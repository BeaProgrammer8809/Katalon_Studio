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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

def Expected_Product_Name_Text = findTestData('Phase2.1/TY_04/Phase2.1').getValue(17, 45)

def Expected_SIH_Text = findTestData('Phase2.1/TY_04/Phase2.1').getValue(18, 45)

def Expected_OP_Text = findTestData('Phase2.1/TY_04/Phase2.1').getValue(19, 45)

def Actual_Product_Name_Text = Mobile.getText(findTestObject('Phase2/BIUnload/Salable/Product_Name_Text'), 0)

def Actual_SIH_Text = Mobile.getText(findTestObject('Phase2/BIUnload/Salable/SIH_Text'), 0)

def Actual_OP_Text = Mobile.getText(findTestObject('Phase2/BIUnload/Salable/OP_Text'), 0)

Mobile.verifyMatch(Expected_Product_Name_Text, Actual_Product_Name_Text, false)

println('A grid where first field is Product Name')

Mobile.verifyMatch(Expected_SIH_Text, Actual_SIH_Text, false, FailureHandling.STOP_ON_FAILURE)

println('Second field- SIH')

Mobile.verifyMatch(Expected_OP_Text, Actual_OP_Text, false, FailureHandling.STOP_ON_FAILURE)

println('Third- OP')

Mobile.takeScreenshot()

Mobile.closeApplication()