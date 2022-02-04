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

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/Inv Summary_only Inv Rep1/Collection/Order_Invoice_Inv Summary'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    0)

txtPaidAmount = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    0)

println(txtPaidAmount)

int lenAmt = txtPaidAmount.length()

println(lenAmt)

for (int i = 0; i <= lenAmt; i++) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/KeyValues/btn_'), 
        i)
}

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Float totalValue = Float.parseFloat(txtPaidAmount)

println(totalValue)

Float halfValue = totalValue / 2

println(halfValue)

partialValue = halfValue.toString()

println(partialValue)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    partialValue, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/rbt_Cheques'), 
    0)

'TC_ID_112--> To check the Select Bank field'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Bank'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Bank'), 
    0)

GlobalVariable.bankInfo = findTestData('Phase 1/Surendran/Invoice Summary/Collection/Bank Info').getValue(1, 1)

if (Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/selectBankInfo'), 
    0, FailureHandling.STOP_ON_FAILURE)) {
    Mobile.scrollToText(GlobalVariable.bankInfo)
}

'TC_ID_113--> To check whether able to select Bank from dropdown'
Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/selectBankInfo'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Branch'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Branch'), 
    0)

GlobalVariable.bankInfo = findTestData('Phase 1/Surendran/Invoice Summary/Collection/Bank Info').getValue(2, 1)

if (Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/selectBankInfo'), 
    0, FailureHandling.OPTIONAL)) {
    Mobile.scrollToText(GlobalVariable.bankInfo)
}

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/selectBankInfo'), 
    0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Cheque Type'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_Select Cheque Type'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_Select Cheque Type'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_FOREIGN'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_FOREIGN'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_FOREIGN'), 
    'FOREIGN')

txtForeign = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_FOREIGN'), 
    0)

Mobile.verifyMatch('FOREIGN', txtForeign, false)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_LOCAL'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_LOCAL'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_LOCAL'), 
    'LOCAL')

txtLocal = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_LOCAL'), 
    0)

Mobile.verifyMatch('LOCAL', txtLocal, false)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/ct_LOCAL'), 
    0)

txtBeforeEnterValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txt_Cheque Num'), 
    0)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txt_Cheque Num'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txt_Cheque Num'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txt_Cheque Num'), 
    findTestData('Phase 1/Surendran/Invoice Summary/Collection/Bank Info').getValue(3, 1), 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.closeApplication()

