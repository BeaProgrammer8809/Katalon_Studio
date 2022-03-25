import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

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
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			'Username', 3), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue('Password', 3)],
	FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/HamBurger_Icon'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Back_Button'), 0)

Mobile.delay(5)

//
//AppiumDriver driver = MobileDriverFactory.getDriver()
//
//driver.findElementByClassName('android.widget.Button').click()

def BackPop=Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/AcceptPendingChargesWithASaleDateForToday and earlier to continue'), 0)

def BackNotAccept=findTestData('Phase2.1/TY_05/Collection').getValue(3, 79)

def BackPopUp=BackPop.contains(BackNotAccept)

Mobile.verifyMatch(BackPopUp.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(5, 46), false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/OK_ButtonAcceptPendingChargesPopup'), 0)

println "seller without accepting backward from vanload acceptance screen it again navigate into the vanload acceptance"

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Checkbox_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Vanload Acceptance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Vanload Acceptance_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Vanload_List_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Vanload_List_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

println "Vanload should be available in vanload acceptance screen"

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'TC_121'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()