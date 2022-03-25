import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)
Mobile.tap(findTestObject('Object Repository/Phase2/BIStarFilterOrderAndInvoiceScreen01/All_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)
Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(3, 6), 0)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2/Common_Data/CommonData_02').getValue(6, 5)
GlobalVariable.SchemeBuySkuName = findTestData('Phase2/Common_Data/CommonData_02').getValue(9, 2)
GlobalVariable.SchemeGetSkuName1 = findTestData('Phase2/Common_Data/CommonData_02').getValue(10, 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)
Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()
def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()
def Expected_Toast_Message = findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(18, 6)

//Verification of toast message
Actual_Toast_Message.contains(Expected_Toast_Message)
println Actual_Toast_Message

def Actual_SIH_Qty=Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/SIH_Qty'), 0, FailureHandling.STOP_ON_FAILURE)
def Actual_Invoice_Qty=Mobile.getText(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.longPress(findTestObject('Object Repository/Phase2/BIOrderAndInvoiceScreen01/Schem_Buy_SKU_Text_view'), 0, FailureHandling.STOP_ON_FAILURE)


def Actual_BUY_SKU_Piece=Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_BuyValue'), 0, FailureHandling.STOP_ON_FAILURE)
Actual_BUY_SKU_Piece=Actual_BUY_SKU_Piece.substring(0, 1)
println Actual_BUY_SKU_Piece

def Actual_GET_SKU_Piece=Mobile.getText(findTestObject('Object Repository/Phase2/BISchemeScreen01/SLAB1_GetValue'), 0, FailureHandling.STOP_ON_FAILURE)
println Actual_GET_SKU_Piece
Actual_GET_SKU_Piece=Actual_GET_SKU_Piece.substring(0, 1)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_47A'], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BISchemeScreen01/Back_Button'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

//Verification of item not added
Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/No_Items_Added_OK_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/No_Items_Added_OK_Button'), 0, FailureHandling.STOP_ON_FAILURE)

def Expected_SIH_Qty= findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(20, 6)
def Expected_Invoice_Qty= findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(19, 6)
def Expected_BUY_SKU_Piece= findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(12, 6)
def Expected_GET_SKU_Piece= findTestData('Phase2/TY_02/Test_Data_Phase2').getValue(21, 6)

//Verification to check that Scheme is not applied
Mobile.verifyElementNotVisible(findTestObject('Phase2/BIApplyingSchemeScreen/Applying_Scheme_TextView'), 0, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_SIH_Qty, Expected_SIH_Qty, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_Invoice_Qty, Expected_Invoice_Qty, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_BUY_SKU_Piece, Expected_BUY_SKU_Piece, false, FailureHandling.STOP_ON_FAILURE)
Mobile.verifyMatch(Actual_GET_SKU_Piece, Expected_GET_SKU_Piece, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/ApplyingScheme/Screenshot'), [('testCaseName') : 'TC_47'], FailureHandling.STOP_ON_FAILURE)

println('Scheme is not been applied')
Mobile.closeApplication()