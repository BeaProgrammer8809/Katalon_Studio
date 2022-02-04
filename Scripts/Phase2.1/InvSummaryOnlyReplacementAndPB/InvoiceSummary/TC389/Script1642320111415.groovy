import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.text.DecimalFormat
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

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 4), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 4)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2/Common_Data/CommonData').getValue(3, 2)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'),0)
Mobile.tap(findTestObject('Phase2/BINoCartePorteGeneratedPopup01/OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIBlueLabelProcess01/Back_Button'), 0 ,FailureHandling.OPTIONAL)
Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 3)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_PB_Qty=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC389_Actual_PB_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC389_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

//Verification to check that collection icon is not displayed for credit retailer
Mobile.verifyElementNotVisible(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Collection_Icon'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC389_Collection_Icon_Not_Displayed'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty
Mobile.verifyEqual(Actual_PB_Qty, Expected_Sales_Return, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()