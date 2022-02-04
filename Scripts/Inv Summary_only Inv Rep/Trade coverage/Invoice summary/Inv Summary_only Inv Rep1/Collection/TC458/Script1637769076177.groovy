import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

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

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/TE/rbt_Transferencias Electrnicas'), 
    0)

'TC_ID_--> To check the Select Bank field'
Mobile.verifyElementVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Bank'), 
    0)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/txtView_Select Bank'), 
    0)

GlobalVariable.bankInfo = findTestData('Phase 1/Surendran/Invoice Summary/Collection/Bank Info').getValue(1, 1)

if (Mobile.verifyElementNotVisible(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/selectBankInfo'), 
    0, FailureHandling.STOP_ON_FAILURE)) {
    Mobile.scrollToText(GlobalVariable.bankInfo)
}

'TC_ID_--> To check whether able to select Bank from dropdown'
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

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.tapAndHold(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0, 0)

Mobile.takeScreenshot('.\\Screenshot\\Run Time Images\\Run Time\\toastReferenceNo.png')

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.delay(10)

//String testvalues = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('G:\\Bimbo Mobile Testing\\Bimbo Mobile\\Screenshot\\Run Time Images\\Run Time\\SelectBankTabandhold.png')
String testvalues = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('.\\Screenshot\\Run Time Images\\Run Time\\toastReferenceNo.png')

String checkData = testvalues.trim()

toastReferenceNo = checkData.substring(checkData.length() - 18)

println(toastReferenceNo)

if (Mobile.verifyMatch('Enter Reference No', toastReferenceNo, false, FailureHandling.OPTIONAL)) {
    Mobile.verifyMatch('Enter Reference No', toastReferenceNo, false) //String testvalues = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('G:\\Bimbo Mobile Testing\\Bimbo Mobile\\Screenshot\\Run Time Images\\Run Time\\SelectBankTabandhold.png')
} else {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
        0)

    Mobile.tapAndHold(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
        0, 0)

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
        0)

    Mobile.takeScreenshot('.\\Screenshot\\Run Time Images\\Run Time\\toastReferenceNo1.png')

    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
        0)

    Mobile.delay(10)

    String testvalues1 = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('.\\Screenshot\\Run Time Images\\Run Time\\toastReferenceNo1.png')

    String checkData1 = testvalues1.trim()

    toastReferenceNo1 = checkData1.substring(checkData1.length() - 18)

    println(toastReferenceNo1)

    Mobile.verifyMatch('Enter Reference No', toastReferenceNo1, false, FailureHandling.STOP_ON_FAILURE)
}

