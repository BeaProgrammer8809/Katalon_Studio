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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/TradeCoverage_RaghuNormalCash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 15)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
	0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

def returnProduct = Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'),
	0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue('ProductName', 27)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

def Product_Buying = Mobile.getText(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

println("$Product_Buying")

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Summary_ScreenTitle'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def ProductName1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'),
	0)

println("$ProductName1")

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

def ProductName2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Product_TextView_Indexing'),
	0)

println("$ProductName2")

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

def LegalEntityName = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/LegalEntityName_TextView _Indexing'),
	0)

println("$LegalEntityName")

def LegalEntityname=LegalEntityName.toString().toUpperCase()

def legalEntity=LegalEntityname.substring(1, 26)

Mobile.verifyMatch(LegalEntityName, findTestData('Phase2.1/TY_05/Collection').getValue(4, 69), false, FailureHandling.STOP_ON_FAILURE)


Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Folio_ProdBuy_EditText'),
	findTestData('Phase2.1/TY_05/Collection').getValue(3, 62), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

def LegalEntityName1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/LegalEntityName_TextView _Indexing'),
	0)

println("$LegalEntityName1")

def LegalEntityname1=LegalEntityName1.toString().toUpperCase()

Mobile.verifyMatch(LegalEntityName1, findTestData('Phase2.1/TY_05/Collection').getValue(5, 69), false, FailureHandling.STOP_ON_FAILURE)


Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'),
	findTestData('Phase2.1/TY_05/Collection').getValue(3, 62), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'),
	0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def InvoiceSheet = Mobile.getText(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)


println "$InvoiceSheet"

Boolean Printpreview=InvoiceSheet.contains(legalEntity)

Mobile.verifyMatch(Printpreview.toString(),findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false,FailureHandling.STOP_ON_FAILURE)

println('Legal entity should be ricolino for product buying products')

Boolean Printpreview1=InvoiceSheet.contains(LegalEntityname1)
Mobile.verifyMatch(Printpreview1.toString(),findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false,FailureHandling.STOP_ON_FAILURE)

println('Legal entity should be barcel for replacement products')


Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_293'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()