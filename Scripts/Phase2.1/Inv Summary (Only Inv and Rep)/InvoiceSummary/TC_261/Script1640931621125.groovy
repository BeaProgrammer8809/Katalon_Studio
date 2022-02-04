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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4005'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

//Change to different Trade_Seller Login i.e Interfactura/Ekomercio
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_RakeshCashPesitoNormalInterfactura'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To click on Order and Invoice Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

// To Set Pieces Value for 001_SD_MUMB_PRO...
'To click on Search Logo Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

'To Click on Search Edit Text Field'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), 0)

'Driving the Test Data and setting value for Search_Edit_Text Field'
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/TY_13/TY_13').getValue(
        3, 1), 0)

'Clicking on PIeces_Edit_Text Field'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

//Entering the value for Pieces using Global_Data..
GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

'To Click on OrderAndInvoice Screen Next button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To Click on Next_Button on Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

'To Verify if Summary_Screen is displayed or not by verifying the title of the screen.'
Mobile.verifyElementText(findTestObject('Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 'Summary')

'To Verify if the Tag_Icon(Edit_Icon) is present in Summary_Screen or not'
Mobile.verifyElementExist(findTestObject('Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 30)

Mobile.verifyElementVisible(findTestObject('Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 30)

'To Click on Tag_Icon(Edit_Icon)'
Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Tag_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_261'], FailureHandling.STOP_ON_FAILURE)

'To Check if the OrderedAndInvoice  is Displayed or not by validating the screen titl'
Mobile.verifyElementText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Order_And_Invoice_Screen_Title'), 'Ordered (1/1)')

//*****************************************************************************************************************************
//Verifing if SKU are diaplayed and the Pieces/Quantity selected is displayed properly or not.
Actual1 = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.verifyMatch(Actual1, findTestData('Phase2.1/TY_13/TY_13').getValue(4, 1), false)

Mobile.closeApplication()

