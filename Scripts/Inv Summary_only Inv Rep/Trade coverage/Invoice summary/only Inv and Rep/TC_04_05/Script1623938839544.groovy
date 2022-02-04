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

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Order and Invoice/Trade Coverage_Order and Invoice'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Inv Summary/Delivery Summary_Edit'), [:], FailureHandling.STOP_ON_FAILURE)

not_run: Mobile.sendKeys(findTestObject('Phase 1.1/Resource2/Order and Invoice/EditText - qty'), '1')

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Order and invoice Button - Next'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Total Piece'), 0)

Mobile.setText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Pieces - EditText'), '1', 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Select - Select Reason'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Option - Non-Salable'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Button - Done'), 0)

Mobile.tap(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product buying Button - Next'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource2/Order and Invoice/Product Buying/Screen Header - Summary'), 
    'Summary')

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Invoice No'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView0 - SKU Name'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - SKU Total Value'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Pieces'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - BAG'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Actual Return'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Sales Return'), 
    0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - U.Price'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - i - image'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/TextView - Total Qty'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - Invoice'), 0)

Mobile.verifyElementExist(findTestObject('Phase 1.1/Resource2/Order and Invoice/Summary Screen/Button - Edit'), 0)

Mobile.callTestCase(findTestCase('Inv Summary_only Inv Rep/Trade coverage/Invoice summary/only Inv and Rep/Screenshot'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()

