import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.sun.org.apache.xpath.internal.compiler.Keywords as Keywords
import java.sql.Connection as Connection
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
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

not_run: Mobile.startApplication(GlobalVariable.apk_File, false)

not_run: CustomKeywords.'com.android.keywords.AndroidKeyword.Resetapk'()

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv summary_invoice and pb/Cash Retailer Navigation'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Store Activity Screen/Order and  Invoice'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Next Button'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Product Buying Screen Title'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Order and Invoice Screen/Search icon'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource1/Van Seller/Product Buying/Search input field'), findTestData('Phase 1/Anen/Inv summary_invoice and pb/Sku List').getValue(
        'sku_ Both_IVA&IEPS_and_Catagory_Level_discounts', 1), 0)

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

summary_Total = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Sku right Value 1st Row'), 0)

println(summary_Total)

Mobile.verifyMatch(summary_Total, '0', false)

summaryValue_Total = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Value value bottom'), 0)

println(summaryValue_Total)

Mobile.verifyMatch(summaryValue_Total, '0', false)

summaryValue_TotalQty = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Total Qty Value Bottom'), 
    0)

println(summaryValue_TotalQty)

Mobile.verifyMatch(summaryValue_TotalQty, '0', false)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC35_108'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Screen/Information icon Bottom'), 0)

Comp_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Comp Disc Value'), 
    0)

println(Comp_Value)

Comp_Value = Comp_Value.substring(2)

println(Comp_Value)

Mobile.verifyMatch(Comp_Value, '0', false)

Distdisc_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Dist Disc Value'), 
    0)

println(Distdisc_Value)

Distdisc_Value = Distdisc_Value.substring(2)

println(Distdisc_Value)

Mobile.verifyMatch(Distdisc_Value, '0', false)

Order_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Order Value value'), 
    0)

println(Order_Value)

Mobile.verifyMatch(Order_Value, '0', false)

splittotal_Value = Mobile.getText(findTestObject('Phase 1.1/Resource1/Van Seller/Summary Amount split up(info-icon)/Total Value'), 
    0)

println(splittotal_Value)

Mobile.verifyMatch(splittotal_Value, '0', false)

Mobile.callTestCase(findTestCase('Inv summary_Only Replacement and pb/Invoice summary/Reusables/Screenshot'), [('testCaseName') : 'TC159_191_243'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

