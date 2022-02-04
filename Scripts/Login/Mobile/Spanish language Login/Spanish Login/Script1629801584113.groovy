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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

println(GlobalVariable.apk_File)

Mobile.startApplication(GlobalVariable.apk_File, false)

CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

GlobalVariable.userName = findTestData('Login Credentials/Mobile/Login Info').getValue(1, 2)
//GlobalVariable.userName = '021739_2006'

println(GlobalVariable.userName)

GlobalVariable.password = findTestData('Login Credentials/Mobile/Login Info').getValue(2, 2)
//GlobalVariable.password = '2'

println(GlobalVariable.password)

key = findTestData('Login Credentials/Mobile/Key Manager').getValue(1, 1)

//key = 'KPC0TYM9E2PVIOBY'
println(key)

Mobile.startApplication(GlobalVariable.apk_File, false)

if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/Allow'), 15, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/Allow'), 0)

    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/Allow'), 0)
}

if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), 15, FailureHandling.OPTIONAL)) {
    Mobile.setText(findTestObject('Login/Mobile/Activation Screen/AK_Activation Key'), key, 0)

    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/AK_Activation Icon'), 0)

    Mobile.waitForElementPresent(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

    txtSuccessMsg = Mobile.getText(findTestObject('Login/Mobile/Activation Screen/akPopup_Successfully activated.'), 0)

    println(txtSuccessMsg)

    Mobile.tap(findTestObject('Login/Mobile/Activation Screen/akPopUp_OK'), 0)

    Mobile.waitForElementPresent(findTestObject('Login/Mobile/Login/txt_Username'), 0)

    Mobile.tap(findTestObject('Login/Mobile/Login/txt_Password'), 0)

    Mobile.hideKeyboard()

    Mobile.setText(findTestObject('Login/Mobile/Login/txt_Username'), GlobalVariable.userName, 0)

    Mobile.setText(findTestObject('Login/Mobile/Login/txt_Password'), GlobalVariable.password, 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Login/Mobile/Login/btn_Login'), 0)

    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

    if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Login/popup_Do you want to continue in this device'), 15, 
        FailureHandling.OPTIONAL)) {
        Mobile.tap(findTestObject('Login/Mobile/Login/popup_Yes'), 0)
    }
    
    Mobile.delay(10)

    if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/Choose the seller'), 15, FailureHandling.OPTIONAL)) {
        Mobile.tap(findTestObject('Login/Mobile/Activation Screen/Employee Name'), 0)
    }
    
    Mobile.delay(40, FailureHandling.STOP_ON_FAILURE)

    if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Activation Screen/Allow'), 0, FailureHandling.OPTIONAL)) {
        Mobile.tap(findTestObject('Login/Mobile/Activation Screen/Allow'), 0)
    }
} else {
    not_run: Mobile.waitForElementPresent(findTestObject('Login/Mobile/Login/txt_Username'), 0)

    Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

    userName = Mobile.getText(findTestObject('Login/Mobile/Login/txt_Username'), 0)

    println(userName)

    if (userName != 'Username') {
        Mobile.setText(findTestObject('Login/Mobile/Login/txt_Password'), GlobalVariable.password, 0)

        Mobile.hideKeyboard()

        Mobile.tap(findTestObject('Login/Mobile/Login/btn_Login'), 0)

        if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Login/popup_Do you want to continue in this device'), 
            0, FailureHandling.OPTIONAL)) {
            Mobile.tap(findTestObject('Login/Mobile/Login/popup_Yes'), 0)
        }
    } else {
        Mobile.tap(findTestObject('Login/Mobile/Login/txt_Username'), 0)

        Mobile.hideKeyboard()

        Mobile.setText(findTestObject('Login/Mobile/Login/txt_Username'), GlobalVariable.userName, 0)

        Mobile.setText(findTestObject('Login/Mobile/Login/txt_Password'), GlobalVariable.password, 0)

        Mobile.hideKeyboard()

        Mobile.tap(findTestObject('Login/Mobile/Login/btn_Login'), 0)

        if (Mobile.verifyElementVisible(findTestObject('Login/Mobile/Login/popup_Do you want to continue in this device'), 
            0, FailureHandling.OPTIONAL)) {
            Mobile.tap(findTestObject('Login/Mobile/Login/popup_Yes'), 0)
        }
        
        Mobile.delay(40)
    }
}

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Menu/Hamburger Icon'), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'Hamber_Icon_Tap'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/setting_Icon'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/setting_Icon'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/setting_Icon'), 0)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'Settings'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/lbl_Language'), 0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/lbl_Language'), 'Language')

txtLangName = Mobile.getText(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Name of the Language'), 
    0)

Mobile.verifyMatch('Choose your language', txtLangName, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Name of the Language'), 0)

txtSpLang = Mobile.getText(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Language_PopUp/ctv_Spanish'), 
    0)

Mobile.verifyMatch('Spanish', txtSpLang, false)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Language_PopUp/ctv_Spanish'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Language_PopUp/ctv_Spanish'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Menu Screen/Settings/Language_PopUp/btn_Ok'), 0)

Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Spanish Language/Login/editTxt-Contrasea_Password'), GlobalVariable.password, 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Spanish Language/Login/btn_Iniciar sesin_Login'), 0)

