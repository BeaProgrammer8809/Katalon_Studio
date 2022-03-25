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

GlobalVariable.userName = findTestData('Login Credentials/Mobile/Login Info').getValue(1, 6)

println(GlobalVariable.userName)

GlobalVariable.password = findTestData('Login Credentials/Mobile/Login Info').getValue(2, 6)

println(GlobalVariable.password)

key = findTestData('Login Credentials/Mobile/Key Manager').getValue(1, 1)

//key = 'KPC0TYM9E2PVIOBY'
println(key)

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

if (Mobile.verifyElementVisible(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 0)

    Mobile.tap(findTestObject('Phase2/BIManagePhoneCallsPopup01/Allow_Button'), 0)
}

if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), 10, FailureHandling.OPTIONAL)) {
    Mobile.setText(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), key, 0)

    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/AK_Activation Icon'), 0)

    Mobile.waitForElementPresent(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

    txtSuccessMsg = Mobile.getText(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

    println(txtSuccessMsg)

    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/akPopUp_OK'), 0)

    Mobile.waitForElementPresent(findTestObject('Login/Mobile/Login/txt_Username'), 0)

    // Mobile.tap(findTestObject('Login/Mobile/Login/txt_Password'), 0)
    // Mobile.hideKeyboard()
    Mobile.setText(findTestObject('Login/Mobile/Login/txt_Username'), GlobalVariable.userName, 0)

    Mobile.setText(findTestObject('Login/Mobile/Login/txt_Password'), GlobalVariable.password, 0)

    //Mobile.hideKeyboard()
    Mobile.tap(findTestObject('Login/Mobile/Login/btn_Login'), 0)

    Mobile.delay(8, FailureHandling.STOP_ON_FAILURE)

    if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Login/popup_Do you want to continue in this device'), 5, 
        FailureHandling.OPTIONAL)) {
        Mobile.tap(findTestObject('Login/Mobile/Login/popup_Yes'), 0)
    }
}

Mobile.verifyElementVisible(findTestObject('Object Repository/Login/Mobile/Activation Screen/Choose the seller'), 0, FailureHandling.STOP_ON_FAILURE)

def actulText = Mobile.getText(findTestObject('Object Repository/Login/Mobile/Activation Screen/Choose the seller'), 0, 
    FailureHandling.STOP_ON_FAILURE)

def expText = findTestData('Phase2/TY_03/Phase2.2').getValue(2, 1)

Mobile.verifyMatch(actulText, expText, false, FailureHandling.STOP_ON_FAILURE)

println "User is able to login"

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), ['testCaseName':'SP_TC_02_HomeScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

