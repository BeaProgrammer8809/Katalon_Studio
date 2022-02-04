import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Home Screen/Menu Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Menus/Trade Coverage'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search icon'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/Search field'), findTestData('Phase 1/Anen/Inv Summary(Only PB)/Inv Summary(Only PB)').getValue(
        'cash_retailer', 1), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Trade Coverage Screen/1st Seller Name'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Retailer Profile Screen/Start Visit'), 0)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Odometer Verification'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Store Activity Screen Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

not_run: Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search Input Field'), findTestData(
        'Phase 1/Anen/Inv summary_invoice and pb/Inv summary_invoice and pb').getValue('skuname', 1))

not_run: Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search Input Field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/skus').getValue(
        'sku_with_tax&Discount', 1))

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/input_1st Row Piece'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/Backspace'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/Backspace'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/2'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

'Unit_price_Order&Invoice'
total_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Total Value value'), 0)

println(total_Value)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Product Buying Screen Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/skus').getValue(
        'sku_with_tax&Discount', 1))

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Total Piece 1st Row'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Select Reason Drop down'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Salable'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Input Field'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/1'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Number Pad Return Screen/OK Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Return Screen/Done Button'), 0)

'PB Toal Value'
total_ValuePB = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Value amout'), 0)

println(total_ValuePB)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Summary Page Title'), 0)

summary_Total = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Value value bottom'), 0)

println(summary_Total)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - Invoice'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Do you want to save'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Button - OK'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/TextView - Invoice created successfully.'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Invoice Pop-up/Button - OK'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Summary/Button - Create Ticket Invoice'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Summary/Button - Create Ticket Invoice'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Header - Delivery Final Summary'), 
    0, FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Payment - CheckBox'), 
    0)

inv_Amt = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Delivery Final Summary/1st Row Amt Value'), 0)

println(inv_Amt)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Payment - CheckBox'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Header_Collection'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/label_Inv Amt'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/value_Inv Amt'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/checkbox_Efectivo'), 0)

Balance_Amt = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/value_Balance'), 0)

Balance_Amt = Balance_Amt.substring(Balance_Amt.indexOf(':') + 2, Balance_Amt.indexOf('o') - 1)

println(Balance_Amt)

Total_Paid_Inputamt = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), 0)

println(Total_Paid_Inputamt)

paidamt_dble = Double.parseDouble(inv_Amt)

paidamt_dble = (paidamt_dble + 1)

println(paidamt_dble)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), 0)

String paidamt = String.format('%.2f', paidamt_dble)

toastmsg = 'Amount exceeds the balance, please check.'

println(toastmsg)

Mobile.clearText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), 0)

Mobile.delay(4)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), paidamt, 0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

//def toast = driver.findElementByXPath('//android.widget.Toast[@text=\'Please Pay Total Balance Amount $1.0\']')
def toast = driver.findElementByXPath('//android.widget.Toast[1]')

//def toast = driver.findElementByXPath("//android.widget.Toast[@text='Saved Successfully']")
println(toast.getText())

txtSuccessmsg = toast.getText()

Mobile.verifyMatch(toastmsg, txtSuccessmsg, false)

if (toast == null) {
    KeywordUtil.markFailed('ERROR: Toast object not found!')
}

//Mobile.verifyMatch(Balance_Amt, '0', false)
//
//Mobile.verifyMatch(Total_Paid_Inputamt, summary_Total, false)
Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_387'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.delay(2)

tot_amt = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), 0)

amt_len = tot_amt.length()

println(amt_len)

if (amt_len.equals('1')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('2')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('3')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('4')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('5')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('6')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('7')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('8')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else if (amt_len.equals('9')) {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
} else {
    Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Collection Numpad/Backspace'), 0)
}

Mobile.delay(2)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_390'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/input_value_Total Amount'), inv_Amt, 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_391'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/button_Submit'), 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_391(1)'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource1/Van Seller/Collection/Header_Collection'), 0)

Mobile.callTestCase(findTestCase('Inv summary_invoice and pb/Trade Coverage/Inv summary/Screenshot'), [('testCaseName') : 'TC_ID_392'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

