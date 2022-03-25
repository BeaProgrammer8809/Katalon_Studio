import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/End_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/Stock_Proposal_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), 0)

'To set the SKU name in Search Edit Text field of Stock Proposal Screen'
Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/Search_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
		6, 1), 0)

Mobile.tap(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/OP_EditText'), 1)

Mobile.setText(findTestObject('Phase2/BIEndOfTheDay/BIStockProposalScreen/OP_EditText'), '1', 0)

// To calculate total value

def srp=Mobile.getText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/SRP_Price'), 0)

double srp_price=Double.parseDouble(srp)

def Op=Mobile.getText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/OP_EditText'),0)

double piece_price = Double.parseDouble(Op)

def Total_value = (piece_price*srp_price)
println(Total_value + " -- Expected Total_value Calculated")

def Total_value1=Total_value.toString()

def T2 =Mobile.getText(findTestObject('Object Repository/Phase2/BIEndOfTheDay/BIStockProposalScreen/Value_Dynamic'), 0)
println(T2 + " -- Actual Total_value Fetched")

     double T3  =Double.parseDouble(T2).round(1)
	 def Total_value2=T3.toString()

Mobile.verifyMatch(Total_value1, Total_value2, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/StockProposal/EndofDay/Screenshot'), [('testCaseName') : 'SP_TC_39'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()
