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

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/Inv Summary_only Inv Rep1/Collection/Order_Invoice_Inv Summary1'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtview_Payment'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtview_Payment'), 
    0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/PayMentCheckBox'), 
    0)

Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)

Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)

if (Mobile.verifyElementNotExist(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/header_Collection'), 
    0)) {
    println('To check for collection option is not coming for credit cutomer invoices')
}
	
	Mobile.closeApplication()