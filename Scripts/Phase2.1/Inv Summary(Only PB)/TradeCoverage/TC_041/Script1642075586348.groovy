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

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/Non_Salable_Action_Bar'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIUnload/NonSalable/ProductName_Text'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIUnload/NonSalable/ProductName_Text'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIUnload/NonSalable/ProductName_Text'), findTestData('Phase2.1/TY_05/Collection').getValue(
        3, 44))

Mobile.verifyElementVisible(findTestObject('Phase2/BIUnload/NonSalable/SIH_Text'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIUnload/NonSalable/SIH_Text'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIUnload/NonSalable/SIH_Text'), findTestData('Phase2.1/TY_05/Collection').getValue(
        4, 44))

Mobile.verifyElementVisible(findTestObject('Phase2/BIUnload/NonSalable/Total_Price_Text'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIUnload/NonSalable/Total_Price_Text'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIUnload/NonSalable/Total_Price_Text'), findTestData('Phase2.1/TY_05/Collection').getValue(
        5, 44))

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_041'], FailureHandling.STOP_ON_FAILURE)
Mobile.closeApplication()

