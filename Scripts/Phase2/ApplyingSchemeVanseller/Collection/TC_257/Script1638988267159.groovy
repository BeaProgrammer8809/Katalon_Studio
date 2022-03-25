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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import org.openqa.selenium.WebElement as WebElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4002'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/Trade_Coverage -Cash'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Star_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List<WebElement> radio = driver.findElementsByClassName('android.widget.RadioButton')

radio.size()

radio.get(2).click()

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2/TY_01/Test_Data').getValue(
        2, 11), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_5'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIApplyingSchemeScreen/Next_Button'), 0)





Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_257_SummaryScreen'], FailureHandling.STOP_ON_FAILURE)

def TotalValue=Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/Value_Value'), 0)

println  TotalValue

//GlobalVariable.Getsku=findTestData('Phase2/Common_Data/CommonData_01').getValue(6, 4)
//
//def Actual_Get_price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/GetSchemeDetails/Get_Price_Value'),
//	0)

GlobalVariable.index = findTestData('Phase2/Common_Data/CommonData_01').getValue('Number', 2)

def Actual_Get_price = Mobile.getText(findTestObject('Phase2/BIInvoiceSummaryScreen/BISummaryProductDetails/Price_Value_Indexing'),
	0)

println("$Actual_Get_price")

println "Get price is Zero so not included in invoice Amount"



Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Summary_Save_PopUp_Ok_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/Invoice_Created_Successfully_PopUp_OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliverySummaryScreen/Create_Ticket_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIDeliveryFinalSummaryScreen/Payment_CheckBox'), 0)

def invAmt = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/InvAmt_TextView'), 0)

println('Invoice Amount in Collection screen is ' + invAmt)

println(invAmt.length())

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIEfectivoScreen01/Amount_EditText'),0)

for (int i = 0; i < invAmt.length(); i++) {
    Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
	
}

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/TransferenciasElectronicas_RadioButton'), 0)



Mobile.verifyEqual(TotalValue, invAmt, FailureHandling.STOP_ON_FAILURE)

GlobalVariable.DropdownName=findTestData('Phase2/Common_Data/CommonData_01').getValue('DropdownName', 1)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)


GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData_01').getValue('Bank', 3)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)






//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBank_DropDown'), 0)
//
//def ExpectedBank = findTestData('Phase2/TY_01/Test_Data').getValue(9, 11)
//
//println(ExpectedBank)
//
//Mobile.delay(8, FailureHandling.STOP_ON_FAILURE)
//
//List<WebElement> dropdown = driver.findElementsById('android:id/text1')
//
//for (WebElement ele : dropdown) {
//	String val = ele.getText()
//
//	if (val.equals(ExpectedBank)) {
//		ele.click()
//
//		break
//	}
//}

//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/ICICI_Bank'), 0)



GlobalVariable.DropdownName=findTestData('Phase2/Common_Data/CommonData_01').getValue('DropdownName', 2)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2/Common_Data/CommonData_01').getValue('Branch', 3)
Mobile.tap(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Option'), 0)
















//Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)
//
//def ExpectedBranch = findTestData('Phase2/TY_01/Test_Data').getValue(11, 11)
//
//println(ExpectedBranch)
//
//Mobile.delay(8, FailureHandling.STOP_ON_FAILURE)
//
//List<WebElement> dropdowns = driver.findElementsById('android:id/text1')
//
//for (WebElement ele : dropdowns) {
//	String val = ele.getText()
//
//	if (val.equals(ExpectedBranch)) {
//		
//		ele.click()
//		
//		break
//	}
//}

GlobalVariable.DropdownName=findTestData('Phase2/Common_Data/CommonData_01').getValue('Branch', 3)

def Branch_Name=Mobile.getText(findTestObject('Object Repository/Phase2/BIDropdown/Dropdown_Name'), 0)
println(Branch_Name)




//def Branch_Name = Mobile.getText(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/SelectBranch_DropDown'), 0)
//
//println(Branch_Name)




Mobile.verifyEqual(Branch_Name, findTestData('Phase2/TY_01/Test_Data').getValue(11, 11))

println('Select Branch is be displayed after choosing any bank from Select Bank field and It is a mandatory field')

Mobile.callTestCase(findTestCase('Phase2/ApplyingSchemeVanseller/Collection/Screenshot'), [('testCaseName') : 'TC_257'], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

