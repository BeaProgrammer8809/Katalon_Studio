import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_08/ScriptsData').getValue(
        2, 27), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

String actual1 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(actual1)

Mobile.verifyEqual(actual1, findTestData('Phase2/TY_08/ScriptsData').getValue(3, 27), FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

String actual2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

println(actual2)

Mobile.verifyEqual(actual2, findTestData('Phase2/TY_08/ScriptsData').getValue(4, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

String actual3 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

println(actual3)

Mobile.verifyEqual(actual3, findTestData('Phase2/TY_08/ScriptsData').getValue(5, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

String actual4 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(actual4)

Mobile.verifyEqual(actual4, findTestData('Phase2/TY_08/ScriptsData').getValue(6, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

String actual5 = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(actual5)

Mobile.verifyEqual(actual5, findTestData('Phase2/TY_08/ScriptsData').getValue(7, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

String actual6 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(actual6)

Mobile.verifyEqual(actual6, findTestData('Phase2/TY_08/ScriptsData').getValue(8, 27), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_134'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

