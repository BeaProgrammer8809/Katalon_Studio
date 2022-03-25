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

println(GlobalVariable.apk_File)

key = findTestData('Login Credentials/Mobile/Key Manager').getValue(1, 1)

println(key)

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 0)
}

Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), 10, FailureHandling.OPTIONAL)

Mobile.setText(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), key, 0)

Mobile.tap(findTestObject('Login/Mobile/Activation Screen/AK_Activation Icon'), 0)

Mobile.waitForElementPresent(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

txtSuccessMsg = Mobile.getText(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

println(txtSuccessMsg)

Mobile.tap(findTestObject('Login/Mobile/Activation Screen/akPopUp_OK'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/Company_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/Company_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

println('Company name with icon is displayed at center of login screen')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/txt_Username'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/txt_Username'), 0, FailureHandling.STOP_ON_FAILURE)

println('Username is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/txt_Password'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/txt_Password'), 0, FailureHandling.STOP_ON_FAILURE)

println('Password is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/btn_Login'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/btn_Login'), 0, FailureHandling.STOP_ON_FAILURE)

println('Login button is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/Settings_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/Settings_Button'), 0, FailureHandling.STOP_ON_FAILURE)

println('Settings button displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/Version_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/Version_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('Version is displayed')

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Login/Reserved_Rights_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Object Repository/Login/Mobile/Login/Reserved_Rights_TextView'), 0, FailureHandling.STOP_ON_FAILURE)

println('Copy rights text displayed')

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), ['testCaseName':'SP_TC_01_Login'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

