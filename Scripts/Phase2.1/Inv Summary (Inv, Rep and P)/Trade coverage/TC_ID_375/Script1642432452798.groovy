import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4001'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_ManoharCashInterfacturaOnsiteINE'), [:], 
    FailureHandling.STOP_ON_FAILURE)

'To Click on OrderAndInvoice_Button'
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

'To Click on Search Button'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        6, 38), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Num_2'), 0)

Mobile.tap(findTestObject('Object Repository/Phase2/BINumberKeypad01/OK_Button'), 0)

'To click on Next_Button in OrderAndInvoice Screen'
Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

'To Tap on NEXT button in Product_Buying Screen'
Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/IneComplement_Icon'), 0)

//"INE_TipoComite"
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_TipoComite', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.setText(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/INE_ID_Contabilidad_EditText'), findTestData(
        'Phase2.1/Common_Data/CommonData').getValue(5, 4), 0)

//'TipoProceso'
GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 3)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

GlobalVariable.DropdownOption = findTestData('Phase2.1/Common_Data/CommonData').getValue('TipoProceso', 2)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Option'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/INE_Complement_Popup/Submit_btn'), 0)

// for Toast Message
AppiumDriver driver = MobileDriverFactory.getDriver()

def ActualToastMessage = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(ActualToastMessage + 'Actual toast msg')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Inv, Rep and P)/Trade coverage/Screenshot'), [('testCaseName') : 'TC_ID_375ToastMsg'], 
    FailureHandling.STOP_ON_FAILURE)

// Expected toast msg
def ExpectedToastMsg = findTestData('Phase2.1/TY_13/Inv Summary (Inv, Rep and P').getValue(4, 31)

println(ExpectedToastMsg + '--Expected toast msg')

// Verifying if the Actual toast msg and Expected toast msg are matched ..
Mobile.verifyMatch(ActualToastMessage, ExpectedToastMsg, false, FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

