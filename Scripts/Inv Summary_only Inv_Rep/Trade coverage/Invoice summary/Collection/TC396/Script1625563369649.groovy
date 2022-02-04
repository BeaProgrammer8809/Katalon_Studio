import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.awt.geom.Arc2D.Float as Float
import java.text.DecimalFormat as DecimalFormat
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

Mobile.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - qty'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - qty'), '1')

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.clearText(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - second_Returns'), 0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - second_Returns'), '1')

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    0)

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

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/EditText - Folio Number text field'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Payment - CheckBox'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Payment - CheckBox'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Pop-up Header - Collection'), 
    'Collection')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Label - Inv Amt'), 
    'Inv Amt')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Label - Min.Amt'), 
    'Min.Amt')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/RadioButton - Credit Note'), 
    'Credit Note')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/RadioButton - Efectivo'), 
    'Efectivo')

Mobile.verifyElementChecked(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/RadioButton - Efectivo'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/RadioButton - Cheques'), 
    'Cheques')

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/RadioButton - Transferencias Electrnicas'), 
    'Transferencias Electrónicas')

balance = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Balance  value'), 
    0)

entered_Collection_Value = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/EditText - collection Amount'), 
    0)

Mobile.verifyMatch(balance.replace('Balance : 0 of ', ''), entered_Collection_Value, false)

Mobile.clearText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/EditText - collection Amount'), 
    0)

Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/EditText - collection Amount'), 
    '50.00')

collect_Value = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/EditText - collection Amount'), 
    0)

total_Paid = Mobile.getText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Total Paid  value'), 
    0)

paidamt = total_Paid.replace('Total Paid : ', '')

Mobile.verifyMatch(paidamt, collect_Value, false)

Mobile.verifyNotMatch('0', entered_Collection_Value, false)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Delivery Final Summary/Collection Pop-up/Number Key Pad'), 
    0)

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/only Inv and Rep/Screenshot'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

