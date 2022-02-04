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


GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Bank', 4)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('Branch', 4)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 3)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('ChequeType', 2)

Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BICollectionScreen01/BIChequesScreen01/ChequeNum_EditText'),ChequeNum, 0)


