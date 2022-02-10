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


Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap( findTestObject('Object Repository/Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)
Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanLoadNo_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanLoadNo_Indexing') , 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist( findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Lines_Value_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible( findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Lines_Value_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)
def actualDate2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanloadDate_indexing'),0)

def expectedDate2 = findTestData('Phase2.1/TY_14/Testdata').getValue( 'Data2', 78)

Mobile.verifyMatch(actualDate2, expectedDate2, false, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanLoadNo_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanLoadNo_Indexing') , 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist( findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Lines_Value_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible( findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Total_Lines_Value_TextView_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def actualDate = Mobile.getText(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/VanloadDate_indexing'),0)

def expectedDate = findTestData('Phase2.1/TY_14/Testdata').getValue( 'Data2', 79)

Mobile.verifyMatch(actualDate, expectedDate, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_91'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
