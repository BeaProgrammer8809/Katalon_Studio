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

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			1, 8), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue(2, 27)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		'Onsite Products', 23), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/OnlyProduct_Buying_Quantity'), [('testData1') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('Onsite Products', 22)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

//To accept INE complement
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

//
Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/Submit_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
		4, 40), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

Mobile.setText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Folio_NO_Indexing'), findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
		4, 40), 0)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/InvoiceSummary/Screenshot'),
	[('testCaseName') : 'TC_126DeliveryFinalSummary'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Create_Final_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Preticket_PopUp_OK_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully_OK_Button'),
	0, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/InvoiceSplitInvoiceReplacement/InvoiceSummary/Screenshot'),
	[('testCaseName') : 'TC_126SplittedInvoice-UUID'], FailureHandling.STOP_ON_FAILURE)

def ActualResult = Mobile.getText(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Splitted_Invoice_Saved_Successfully._TextView'),
	0)
println(ActualResult + "---->Actual Text of Splitted_Invoice popup")

def ExpectedResult = findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(3, 40)

def ExpectedResult1 = findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(7, 40)

boolean actualMessage = ActualResult.contains(ExpectedResult)

boolean actualMessage1 = ActualResult.contains(ExpectedResult1)

def verifytheMessage = actualMessage.toString()

println('verifytheMessage' + verifytheMessage)

def verifytheMessage1 = actualMessage1.toString()

println(verifytheMessage1 + 'Verify the message 1')

Mobile.verifyMatch(verifytheMessage, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(6,
		40), false, FailureHandling.STOP_ON_FAILURE)

'verifying failure message is not coming & generating id'
Mobile.verifyMatch(verifytheMessage1, findTestData('Phase2.1/TY_13/SplitInvoiceReplacementAndProductBuying').getValue(
		5, 40), false, FailureHandling.OPTIONAL)

Mobile.closeApplication()

