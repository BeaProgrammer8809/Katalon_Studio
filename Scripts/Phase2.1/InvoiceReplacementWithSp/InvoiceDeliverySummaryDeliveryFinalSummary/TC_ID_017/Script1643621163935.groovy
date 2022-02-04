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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
            'Phase2.1/Common_Data/CommonData').getValue(4, 3)], FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'), 
    [('testCaseName') : 'TC_ID_017'], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Quantity_3'), [('testData1') : findTestData('Phase2.1/Common_Data/CommonData').getValue(
            'ProductName', 30)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/IneComplement_Icon'), 0)

//"INE_TipoComite"
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/INE_ID_Contabilidad_EditText'), findTestData(
        'Phase2.1/Common_Data/CommonData').getValue(5, 4), 0)

//"INE_ClaveEntidad and INE_Ambito
//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_Ambito', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_Ambito', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

//'TipoProceso'
//GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/Submit_btn'), 0)

// to select the reason dropdown
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownName', 4)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('DropdownOption', 6)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIWildCardRetailer/Please_collect_cash_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BIDeliverySummaryScreen/Delivery_Summary_Screen_Title'), 0)

Mobile.verifyElementNotVisible(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Delivery_Final_Summary_ScreenTitle'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceReplacementWithSp/InvoiceDeliverySummaryDeliveryFinalSummary/Screenshot'),
	[('testCaseName') : 'TC_ID_017AfterTapOnInvoiceButtonInSummaryScreen'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()