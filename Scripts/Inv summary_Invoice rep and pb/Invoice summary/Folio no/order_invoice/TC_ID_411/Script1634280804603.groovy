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

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Reusable Cases/Order_Invoice_Inv Summary_Return'), 
    [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

int userInputsize = folioNo.length()

println(userInputsize)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    folioNo, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioNo = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_Folio.No'), 
    0)

println(inputFolioNo)

folioNoLength = inputFolioNo.length()

Mobile.verifyNotEqual(userInputsize, folioNoLength, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyNotEqual(userInputsize, folioNoLength, FailureHandling.STOP_ON_FAILURE)) {
    println('“Folio No fields should not accepts data length more than 15 characters.')
} else {
    FailureHandling.STOP_ON_FAILURE
}

Mobile.delay(3)

Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    0)

Mobile.verifyElementText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/txtView_Default ProdBuy'), 
    'Default ProdBuy')

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    folioNo, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

inputFolioProdBy = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/input_ProdBuy'), 
    0)

println(inputFolioProdBy)

folioProdBuyLength = inputFolioProdBy.length()


Mobile.verifyNotEqual(userInputsize, folioProdBuyLength, FailureHandling.STOP_ON_FAILURE)

if (Mobile.verifyNotEqual(userInputsize, folioProdBuyLength, FailureHandling.STOP_ON_FAILURE)) {
	println('“ProdBuy No fields should not accepts data length more than 15 characters.')
} else {
	FailureHandling.STOP_ON_FAILURE
}
Mobile.closeApplication()