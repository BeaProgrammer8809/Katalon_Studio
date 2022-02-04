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
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/ProductReturnActivity_Reusable'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/Non_Salable_Action_Bar'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 1)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/Total_Piece_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Dropdown_Name_Indexing'), 0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Clod_Stock_Option'), 0)

def DropDownname = Mobile.getText(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Dropdown_Name_Indexing'), 
    0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary(Only PB)/TradeCoverage/Screenshot'), [('testCaseName') : 'TC_057'], 
    FailureHandling.STOP_ON_FAILURE)

def PiecesBeforeUpdate = Mobile.getText(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Pieces_Edit_Text_Indexing'), 
    0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Pieces_Edit_Text_Indexing'), 0)

int len = PiecesBeforeUpdate.length()

for (int i = 0; i < len; i++) {
    Mobile.tap(findTestObject('Phase2/BINumberPad/Back_Space'), 0)
}

Mobile.tap(findTestObject('Phase2/BINumberPad/Num- 1'), 0)

Mobile.tap(findTestObject('Phase2/BIUnload/NonSalable/NoSalable_Stock_Popup/Done_Button'), 0)

Mobile.comment('Screen should redirect to Unload screen means it was accepted ')

Mobile.verifyElementExist(findTestObject('Phase2/BIUnload/Unload_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase2/BIUnload/Unload_Screen_Title'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementText(findTestObject('Phase2/BIUnload/Unload_Screen_Title'), findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary01').getValue(
        2, 10), FailureHandling.STOP_ON_FAILURE)

Mobile.comment('Verifying the Type as Cold Stock')

Mobile.verifyMatch(DropDownname, findTestData('Phase2.1/TY_06/Trade_Coverage/Invoice_Summary/Invoice_Summary01').getValue(
        3, 10), false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

