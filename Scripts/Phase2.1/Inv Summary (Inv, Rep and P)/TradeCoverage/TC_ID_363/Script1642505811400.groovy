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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 2)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 3)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Replacement_Quantity'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 3)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Product_Buying_Quantity'), [('testData1') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue('ProductName', 3)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/IneComplement_Icon'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 3)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/INE_ID_Contabilidad_EditText'), findTestData(
        'Phase2.1/TY_01/TestData2').getValue(2, 30), 0)

//GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_Ambito', 1)
//
//Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
//
//GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_Ambito', 2)
//
//Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)
//
//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
//
//GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 1)
//
//Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)
//
//GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 2)
//
//Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/Submit_btn'), 0)

//assertion
AppiumDriver driver = MobileDriverFactory.getDriver()

actualtoastmessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println("$actualtoastmessage")

Mobile.verifyMatch(actualtoastmessage, findTestData('Phase2.1/TY_01/TestData2').getValue(4, 30), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_363'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

