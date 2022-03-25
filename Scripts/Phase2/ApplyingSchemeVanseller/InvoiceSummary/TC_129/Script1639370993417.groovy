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
import org.testng.Assert as Assert

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Credit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

GlobalVariable.SchemeName = findTestData('Phase2/TY_08/ScriptsData').getValue(3, 28)

println(GlobalVariable.SchemeName)

GlobalVariable.SchemeBuySkuName = findTestData('Phase2/TY_08/ScriptsData').getValue(4, 28)

println(GlobalVariable.SchemeBuySkuName)

GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/TY_08/ScriptsData').getValue(5, 28)

println(GlobalVariable.SchemeGetSkuName1)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_08/ScriptsData').getValue(
        2, 28), 0)

Mobile.longPress(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_129_SchemeDetails'], 
    FailureHandling.STOP_ON_FAILURE)

'SchemeName'
Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SchemeName'), 0)

'SchemeBuySKU_Name'
Mobile.getText(findTestObject('Phase2/BISchemeScreen01/Scheme_Buy_Sku_Name_1'), 0)

'SlabName'
Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB 1_Header'), 0)

'SchemeBuyQty'
def schemeBuyQty = Mobile.getText(findTestObject('Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0)

schemeBuyQty = schemeBuyQty.substring(0, 1)

println(schemeBuyQty)

'BackButton'
Mobile.tap(findTestObject('Phase2/BISchemeScreen01/Back_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)
String OrderQty = Mobile.getText(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

println(OrderQty)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

String Expected = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 0)
println(Expected)

//String Expected = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 0)
//println(Expected)

Mobile.verifyEqual(schemeBuyQty, OrderQty, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 0)

//Mobile.verifyElementExist(findTestObject('Phase2/BIOrderAndInvoiceScreen01/android.widget.TextView0 - Ordered (11)'), 0)
//
//Mobile.verifyElementVisible(findTestObject('Phase2/BIOrderAndInvoiceScreen01/android.widget.TextView0 - Ordered (11)'), 

// 0)


String Actual = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 0)
println(Actual)

//def Expected=findTestData('Phase2/TY_08/ScriptsData').getValue(6, 28)
//println(Expected)

Actual.contains(Expected)

println("Displaying Ordered summary screen")


//Mobile.verifyEqual(Actual, findTestData('Phase2/TY_08/ScriptsData').getValue(6, 28), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_129'], FailureHandling.STOP_ON_FAILURE)

//CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()
Mobile.closeApplication()

