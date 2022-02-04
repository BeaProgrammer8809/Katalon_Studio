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

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 8), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 8)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 10)

Mobile.setText(findTestObject('Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName, 0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(16, 9)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Return_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Return_Qty = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC324_Actual_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Return_Qty = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Actual_Return_Value_Indexing'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC324_Expected_Return_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Pre_Ticket_Ok_Button'), 0)
Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/FolioNo._EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(15, 1), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

def Actual_Invoice_And_UUID_PopUp_Text =Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0)

def Expected_Invoice_Popup_Text = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 212)
boolean Invoice_PopUp_Text=Actual_Invoice_And_UUID_PopUp_Text.contains(Expected_Invoice_Popup_Text)

def Expected_UUID_Popup_Text = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 212)
boolean UUID_PopUp_Text=Actual_Invoice_And_UUID_PopUp_Text.contains(Expected_UUID_Popup_Text)

//Verification to check that Onsite invoice is successfully created PopUp is visible and displayed 
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Invoice_PopUp_Text.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 212), false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that UUID is gerenated 
Mobile.verifyMatch(UUID_PopUp_Text.toString(), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(7, 212), false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC324_Invoice_Created_Successfully_And_UUID_Generated'], FailureHandling.STOP_ON_FAILURE)
println UUID_PopUp_Text

//Verification to check the return qty
Mobile.verifyMatch(Actual_Return_Qty, Expected_Return_Qty, false, FailureHandling.STOP_ON_FAILURE)

println "Onsite invoice is success and UUID is generated"
Mobile.closeApplication()