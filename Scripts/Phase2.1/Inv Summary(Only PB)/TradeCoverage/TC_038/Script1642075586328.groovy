import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/HamBurger_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 1'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Num- 3'), 0)

def OPvalue = Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

for (int i = 0; i < OPvalue.length(); i++) {
    Mobile.tap(findTestObject('Object Repository/Phase2/BINumberPad/Back_Space'), 0)
}

def Actual = Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

def Expected = findTestData('Phase2.1/TY_05/Collection').getValue(3, 41)

Mobile.verifyEqual(Actual, Expected)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_038'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

