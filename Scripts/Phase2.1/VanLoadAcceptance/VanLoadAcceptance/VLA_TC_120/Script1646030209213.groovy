import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
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

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Checkbox_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)


GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)


Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
 
def TotalField=Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0)


Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Reject_Qty_Textfield_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadRejection01/Missing_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadRejection01/Missing_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Object Repository/Phase2/BIVanloadRejection01/Missing_EditText'), 0)


((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_2))

((driver) as AndroidDriver<MobileElement>).pressKey(new KeyEvent(AndroidKey.DIGIT_0))

def MissingField= Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadRejection01/Missing_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BIVanloadRejection01/Back_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def RejectField=Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Reject_Qty_Textfield_Indexing'), 0)

Mobile.verifyMatch(MissingField, RejectField, false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
 
def RejectionTotalField=Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Qty_TextView_Indexing'), 0)

Mobile.verifyNotEqual(TotalField, RejectionTotalField, FailureHandling.STOP_ON_FAILURE)


println "Total value should be updated as expected after the vanload rejection"

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'TC_120'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()