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

GlobalVariable.RetailerName = findTestData('Phase2.1/Common_Data/CommonData').getValue(2, 2)
GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(6, 50)

Mobile.setText(findTestObject('Object Repository/Phase2/BITradeCoverage01/Search_EditText'), GlobalVariable.RetailerName,0)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage_Retailer_Phase2.1'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Invoice_Qty'), [('testData1') : GlobalVariable.ProductName], FailureHandling.STOP_ON_FAILURE)

def Actual_Pieces_Value = Mobile.getText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_367_Actual_Pieces_Value'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

def Expected_Pieces_Value = Mobile.getText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Pieces_Value_Indexing'),0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_367_Expected_Values'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/IneComplement_Icon'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(11, 1)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(11, 2)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(12, 1)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(12, 2)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(13, 1)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(13, 2)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 4)
GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(14, 1)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue(14, 2)
Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/INE_ID_Contabilidad_EditText'), findTestData('Phase2.1/TY_02/Test_Data_Phase2').getValue(4, 90), 0)
Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_ID_367_Only_Ambito_Selected'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/Submit_btn'), 0)


//Verification to check the Invoice Qty
Mobile.verifyEqual(Actual_Pieces_Value, Expected_Pieces_Value, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()