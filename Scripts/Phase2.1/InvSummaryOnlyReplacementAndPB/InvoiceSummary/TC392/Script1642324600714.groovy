import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(1, 7), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 7)], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(3, 8)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 1)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Trade Coverage Screen/StoreName'), 0)
Mobile.tap(findTestObject('Phase 1.1/Resource3/Order and Invoice/Trade Coverage/Store Profile Screen/Profile_Start Visit'),0)
Mobile.tap(findTestObject('Phase2/BINoCartePorteGeneratedPopup01/OK_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/PB_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_PB_Qty=Mobile.getText(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC392_Actual_PB_Qty'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Sales_Return = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Sales_Return_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC392_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/OK_Button'), 0)

//Verification to check the Toast Message when tried to submit the invoice without folio number
AppiumDriver driver = MobileDriverFactory.getDriver()
def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()
println Actual_Toast_Message
def Expected_Toast_Message = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(5, 86)
def Actual_Legal_Entity_Name =Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/LegalEntityName_TextView'), 0)
def Expected_Legal_Entity_Name = findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 86)

//Verification to check that Legal entity name is displayed Aaccordingly
Mobile.verifyMatch(Actual_Legal_Entity_Name, Expected_Legal_Entity_Name, false, FailureHandling.STOP_ON_FAILURE)

//Verification to check that toast message is displayed as expected
Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC392_Actaul_Toast_Message'], FailureHandling.STOP_ON_FAILURE)

//Verification to check the PB Qty
Mobile.verifyEqual(Actual_PB_Qty, Expected_Sales_Return, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()