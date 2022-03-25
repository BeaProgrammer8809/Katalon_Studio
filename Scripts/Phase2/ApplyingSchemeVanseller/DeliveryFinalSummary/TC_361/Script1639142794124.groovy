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

GlobalVariable.Getsku = findTestData('Phase2/Common_Data/CommonData_08').getValue(6, 2)

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
        2, 26), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 3)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

//Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_3'), 0)
String InvoicedSKU = Mobile.getText(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

println(InvoicedSKU)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)


Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIDeliverySummaryScreen/Invoice_Count_EditText'), findTestData('Phase2/TY_08/ScriptsData').getValue(
        3, 26), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)


GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)


Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/ExtraInv1_EditView_Indexing'), 0)


Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/2_NumButton'), 0)


Mobile.tap(findTestObject('Phase2/BISplitDeliverySummary01/Create_Final_Invoice_Button'), 0)


GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 1)

String LinesQtyExtraInv = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

println(LinesQtyExtraInv)


GlobalVariable.index = findTestData('Phase2.1/CommonData/CommonData').getValue('Number', 2)

String LinesQtySplitInv = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Lines_Value_Indexing'), 0)

println(LinesQtySplitInv)


Mobile.verifyEqual(LinesQtyExtraInv, findTestData('Phase2/TY_08/ScriptsData').getValue(4, 26), FailureHandling.STOP_ON_FAILURE)

Mobile.verifyEqual(LinesQtySplitInv, findTestData('Phase2/TY_08/ScriptsData').getValue(5, 26), FailureHandling.STOP_ON_FAILURE)

//String SplitInvQty = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Skus_Qty_Value'), 0)
//
//String ExtraInvQty = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/SKUs_Qty_2'), 0)
//
//println(SplitInvQty)
//
//println(ExtraInvQty)
//
//Mobile.verifyEqual(SplitInvQty, GetSKU, FailureHandling.STOP_ON_FAILURE)
//
//Mobile.verifyEqual(ExtraInvQty, InvoicedSKU, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/DeliveryFinalSummary/Screenshot'), [('testCaseName') : 'TC_361'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

