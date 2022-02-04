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

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 1002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData_03').getValue(2, 10)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 4)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.ProductName = findTestData('Phase2/Common_Data/CommonData_03').getValue(16, 8)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName,
		0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/Common_Data/CommonData_03').getValue(
		16, 21), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'),
0, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/Phase2/BIApplyingSchemeScreen/Next_Button'), 0)
}

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BICollectionScreen01/Submit_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData('Phase2/Common_Data/CommonData_03').getValue(
	15, 1), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

def uuid=Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0)

def splitUUID=uuid.split(":")

uuid=splitUUID[1]

if(uuid.equals("Failure"))
{
	println "UUID generation is getting failed"
}
else
{
println "Generated UUID is : "+uuid
}

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC359_UUID'],
FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/OK_Button_Uuid'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/Summary/Screenshot'), [('testCaseName') : 'TC359_PrintPreviewScreen'],
FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()