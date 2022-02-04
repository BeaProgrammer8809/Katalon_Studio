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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(
        3, 4), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Back_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIProductBuyingScreen01/Product_Buying_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIProductBuyingScreen01/Product_Buying_Screen_Title'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.comment('Screen title verified')

Mobile.verifyElementText(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(
        2, 4))

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

def Title = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0)

Mobile.verifyMatch(findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(2, 4), Title, false)

Mobile.callTestCase(findTestCase('Phase2/Applying_Scheme/Trade_Coverage/Screenshot'), [('testCaseName') : 'TC_55'], FailureHandling.STOP_ON_FAILURE)

Mobile.comment('scheme name verified')

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData').getValue(5, 1)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

Mobile.verifyElementText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(
        4, 4))

def schemeName = Mobile.getText(findTestObject('Phase2/BIApplyingSchemeScreen/Scheme_TextView_Indexing'), 0)

Mobile.verifyMatch(schemeName, findTestData('Phase2/TY_06/Applying Scheme/Navigation Page').getValue(4, 4), false)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIApplyingSchemeScreen/Qty_CheckBox_Indexing'), 0)

Mobile.closeApplication()

