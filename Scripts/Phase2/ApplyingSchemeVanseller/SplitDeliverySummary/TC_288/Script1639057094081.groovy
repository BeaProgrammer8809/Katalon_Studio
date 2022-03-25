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

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Credit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_08/ScriptsData').getValue(
        2, 21), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_1'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

String Actual = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

println(Actual)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

//Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 0)
//
//Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text'), 0)
String Actual1 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Product_Name_Text_Indexing'), 0)

println(Actual1)

Mobile.verifyEqual(Actual1, findTestData('Phase2/TY_08/ScriptsData').getValue(3, 15), FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text'), 0)

//Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

String Actual2 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/SRP_Text_Indexing'), 0)

println(Actual2)

Mobile.verifyEqual(Actual2, findTestData('Phase2/TY_08/ScriptsData').getValue(4, 15), FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), 0)

//Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

String Actual3 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Stock_Delivered_Text_Indexing'), 0)

println(Actual3)

Mobile.verifyEqual(Actual3, findTestData('Phase2/TY_08/ScriptsData').getValue(5, 15), FailureHandling.STOP_ON_FAILURE)

//Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text'), 0)

//Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text'), 0)

GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

String Actual4 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Text_Indexing'), 0)

println(Actual4)

Mobile.verifyEqual(Actual4, findTestData('Phase2/TY_08/ScriptsData').getValue(6, 15), FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Qty_Text'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Qty_Text'), 0)

String Actual5 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Total_Qty_Text'), 0)

println(Actual5)

Mobile.verifyEqual(Actual5, findTestData('Phase2/TY_08/ScriptsData').getValue(7, 15), FailureHandling.STOP_ON_FAILURE)


Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)

Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)


//String Actual6 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), 0)
//
//println(Actual6)
//Mobile.verifyElementExist(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//Mobile.verifyElementVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

String Actual7 = Mobile.getText(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

println(Actual7)

Mobile.verifyEqual(Actual7, findTestData('Phase2/TY_08/ScriptsData').getValue(8, 15), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/SplitDeliverySummary/Screenshot'), [('testCaseName') : 'TC_288'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

