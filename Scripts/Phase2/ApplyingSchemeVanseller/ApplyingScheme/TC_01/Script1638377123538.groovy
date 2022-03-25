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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_02/Test_Data_Phase2').getValue( 3, 2), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.SchemeName = findTestData('Phase2/Common_Data/CommonData_02').getValue(11, 1)
GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)
Mobile.longPress(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0, FailureHandling.STOP_ON_FAILURE)

def Actual_Scheme_Discription = Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SchemeName'), 0, FailureHandling.STOP_ON_FAILURE)
println Actual_Scheme_Discription

Mobile.tap(findTestObject('Object Repository/Phase2/BISchemeScreen01/Back_Button'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//Verification to check Applying scheme is loaded
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'),0, FailureHandling.STOP_ON_FAILURE)

def Expected_Scheme_Discription = Mobile.getText(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Scheme_TextView'),0, FailureHandling.STOP_ON_FAILURE)
println Expected_Scheme_Discription

//Verifying the scheme are matching
Mobile.verifyMatch(Actual_Scheme_Discription, Expected_Scheme_Discription, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_01'], FailureHandling.STOP_ON_FAILURE)

println('Applying scheme is loaded')

Mobile.closeApplication()


