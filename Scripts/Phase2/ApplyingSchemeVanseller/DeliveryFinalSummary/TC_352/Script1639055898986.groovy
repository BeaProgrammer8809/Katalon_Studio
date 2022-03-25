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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_01/Test_Data').getValue(
        2, 17), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//List<WebElement> viewbutton = driver.findElementsByXPath('//android.widget.Button[@text=\'View\']')
//
//SizeofViewButton = viewbutton.size()
//
//viewbutton.get(0).click()
GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/View_Button_Indexing'), 0)

def Actual_GET_SKU_SIH_Logic1 = Mobile.getText(findTestObject('Object Repository/Phase2/BISlabScreen/Scheme_Logic_TextView'), 
    0, FailureHandling.STOP_ON_FAILURE)

println('SKU Logic' + Actual_GET_SKU_SIH_Logic1)

println('The Scheme Logic is ONLY')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_352_SlabScreen'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BISlabScreen/Done_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2/TY_01/Test_Data').getValue(
        3, 17), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 2'), 0)

Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Invoice_Split_Text = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println("$Invoice_Split_Text")

def split = Invoice_Split_Text.split('-')

Actual_Invoice_split = (split[0])

println(Actual_Invoice_split)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 1)

def Invoice_Split_LineValue = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 
    0)

println("$Invoice_Split_LineValue")

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

//def ExtraInvoice_text = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice_split_2'), 0)
def ExtraInvoice_text = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Invoice Split_Indexing'), 0)

println("$ExtraInvoice_text")

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

//def ExtraInvoice_LineValue = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Qty_2'), 0)
def ExtraInvoice_LineValue = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 
    0)

println("$ExtraInvoice_LineValue")

Mobile.verifyMatch(Actual_Invoice_split, findTestData('Phase2/TY_01/Test_Data').getValue(4, 17), true, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(Invoice_Split_LineValue, findTestData('Phase2/TY_01/Test_Data').getValue(5, 17), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(ExtraInvoice_text, findTestData('Phase2/TY_01/Test_Data').getValue(6, 17), true, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(ExtraInvoice_LineValue, findTestData('Phase2/TY_01/Test_Data').getValue(7, 17), FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_352'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

