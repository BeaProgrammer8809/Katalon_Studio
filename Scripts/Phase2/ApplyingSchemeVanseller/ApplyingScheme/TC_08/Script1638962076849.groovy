import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Credit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_08/ScriptsData').getValue(
        2, 8), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

////GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)
//GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)
String slab = Mobile.getText(findTestObject('Phase2/BISlabScreen/Slab_TextView'), 0)

println(slab)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

String actual1 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Get_Qty_EditText'), 0)

println(actual1)

Mobile.verifyEqual(actual1, findTestData('Phase2/TY_08/ScriptsData').getValue(3, 8), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

String actual2 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Max_Value'), 0)

println(actual2)

Mobile.verifyEqual(actual2, findTestData('Phase2/TY_08/ScriptsData').getValue(4, 8), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

String actual3 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Min_Value'), 0)

println(actual3)

Mobile.verifyEqual(actual3, findTestData('Phase2/TY_08/ScriptsData').getValue(5, 8), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

String actual4 = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Logic_TextView'), 0)

println(actual4)

Mobile.verifyEqual(actual4, findTestData('Phase2/TY_08/ScriptsData').getValue(6, 8), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

String actual5 = Mobile.getText(findTestObject('Phase2/BISlabScreen/SIH_Value'), 0)

println(actual5)

//Mobile.verifyMatch(SIH, findTestData('Phase2/TY_08/ScriptsData').getValue(5, 8), FailureHandling.OPTIONAL)
Mobile.verifyElementVisible(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

String Scheme = Mobile.getText(findTestObject('Phase2/BISlabScreen/Scheme_Buy_SKU_TextView'), 0)

println(Scheme)

Mobile.verifyMatch(Scheme, findTestData('Phase2/TY_08/ScriptsData').getValue(8, 8), false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_08'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

