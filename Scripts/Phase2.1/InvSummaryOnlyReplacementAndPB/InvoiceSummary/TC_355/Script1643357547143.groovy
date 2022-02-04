import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
			'Username', 8), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue('Password', 8)],
	FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_Generic'), [('retailerName') : findTestData(
			'Phase2.1/Common_Data/CommonData').getValue('RetailerCash', 10)], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(16, 10)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Returns_Edit_Text'), 0)

Mobile.hideKeyboard()

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 5)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Search_Button'), 0)

GlobalVariable.ProductName = findTestData('Phase2.1/Common_Data/CommonData').getValue(16, 31)

Mobile.setText(findTestObject('Phase2/BIProductBuyingScreen01/Search_Edit_Text'), GlobalVariable.ProductName, 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Total_Pieces_Qty'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Select_Reason_DropDown'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIReturnProductBuyingScreen01/Salable_DD_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Pieces_Edit_Text'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIReturnProductBuyingScreen01/Done_Button'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

GlobalVariable.Folio = findTestData('Phase2.1/Common_Data/CommonData').getValue(15, 1)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/UUID_Folio No_popup'), GlobalVariable.Folio, 0)

Mobile.setText(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BIEnterTheFolioNoPopup01/Only_ProductBuying_InvQty/FolioProdBuy_EditText'), GlobalVariable.Folio, 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/UUID_OK_popup'), 0)

Mobile.delay(20)

def ActualTitle = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BI_UUID/Save _Succesfully_Text'), 0)

println "$ActualTitle"

def Actual= ActualTitle.split("\n")
def ActualRes=Actual[1]
def ActualResult=ActualRes.substring(0, ActualRes.length())
println "$ActualResult"

def ActualFinalUUID=ActualRes.substring(21, ActualRes.length())
println "$ActualFinalUUID"


def Actual1= ActualTitle.split("\n")
def ActualRes1=Actual1[2]
def ActualResult1=ActualRes1.substring(0, ActualRes1.length())
println "$ActualResult1"

def ActualFinalUUID1=ActualRes1.substring(21, ActualRes1.length())
println "$ActualFinalUUID1"

def ExpectedTitle = findTestData('Phase2.1/TY_05/Collection').getValue(4, 36)

Boolean SaveSuccessful=ActualTitle.contains(ExpectedTitle)

Mobile.verifyMatch(SaveSuccessful.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

Boolean UUIDTEXT=ActualTitle.contains(ActualResult)

Mobile.verifyMatch(UUIDTEXT.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

def Flag=findTestData('Phase2.1/TY_05/Collection').getValue(7, 69)
println "$Flag"

Boolean UUIDText=ActualTitle.contains(Flag)

Mobile.verifyMatch(UUIDText.toString(), findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Phase2/BIInvoiceSummaryScreen/BI_UUID/OK_Button_Uuid'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Print_Preview_TextView'), 0)

def InvoiceSheet = Mobile.getText(findTestObject('Object Repository/Phase2/BIPrintPreviewScreen/Invoice_Sheet'), 0)

Boolean InvoiceStatusReplacement=InvoiceSheet.contains(ActualFinalUUID)

//Mobile.verifyNotMatch(InvoiceStatusReplacement.toString(),findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false,FailureHandling.STOP_ON_FAILURE)

//Boolean OnsiteInvoiceStatusReplacement=InvoiceSheet.contains(Flag)
//
//Mobile.verifyMatch(InvoiceStatusReplacement.toString(),findTestData('Phase2.1/TY_05/Collection').getValue(6, 69), false,FailureHandling.STOP_ON_FAILURE)





println("uuid message is matching with expected  ")

Mobile.callTestCase(findTestCase('Phase2.1/InvSummaryOnlyReplacementAndPB/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_355'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()


