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

def Expected_Title = findTestData('Phase2.1/TY_04/Phase2.1').getValue(16, 44)

def Actual_Title = Mobile.getText(findTestObject('Phase2/BIUnload/Unload_Screen_Title'), 0)

Mobile.verifyMatch(Actual_Title, Expected_Title, false)

Mobile.getText(findTestObject('Phase2/BIUnload/Salable/Salable_Text'), 0)

Mobile.callTestCase(findTestCase('null'), [('testCaseName') : 'TC_028_Default_Selected'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIUnload/Menu-Next_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIUnload/NonSalable/Non_Salable_Text'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIUnload/Salable/Salable_Text'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIUnload/Number_Keyboard_Unload/Keyboard_0-9'), 0, FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIUnload/Unload_Screen_Title'), 0)
println('The above elements are present in perticular screen')

Mobile.callTestCase(findTestCase('null'), [('testCaseName') : 'TC_028'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

