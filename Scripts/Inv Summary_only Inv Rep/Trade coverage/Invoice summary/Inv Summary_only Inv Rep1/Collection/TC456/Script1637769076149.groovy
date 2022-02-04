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

txtInvoiceAmt = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/Inv_Amount'), 
    0)

println(txtInvoiceAmt)

txtlblBalance = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Balance'), 
    0)

println(txtlblBalance)

String[] balanceSplit = txtlblBalance.split('Balance : ')

String[] balanceSplit1 = balanceSplit[1].split(' of ')

println('Balance Amounnt Is: ' + (balanceSplit1[0]))

println(balanceSplit1[1])

Mobile.verifyMatch('0', balanceSplit1[0], false, FailureHandling.STOP_ON_FAILURE)

Mobile.verifyMatch(txtPaidAmount, balanceSplit1[1], false, FailureHandling.STOP_ON_FAILURE)

int lenAmt = txtPaidAmount.length()

println(lenAmt)

for (int i = 0; i <= lenAmt; i++) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/KeyValues/btn_'), 
        i)
}

Mobile.delay(30)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/TE/rbt_Transferencias Electrnicas'), 
    0)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    txtPaidAmount, 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/TE/txtView-Reference Num'), 
    '123', 0)

Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.tapAndHold(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0, 0)

Mobile.takeScreenshot('.\\Screenshot\\Run Time Images\\Run Time\\SelectBankTabandhold.png')

Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Cheques/btn_Submit'), 
    0)

Mobile.delay(10)

//String testvalues = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('G:\\Bimbo Mobile Testing\\Bimbo Mobile\\Screenshot\\Run Time Images\\Run Time\\SelectBankTabandhold.png')
String testvalues = CustomKeywords.'com.android.keywords.ReadImage.crackingImage'('.\\Screenshot\\Run Time Images\\Run Time\\SelectBankTabandhold.png')

String checkData = testvalues.trim()

bank = checkData.substring(checkData.length() - 11)

println(bank)

Mobile.verifyMatch('Select Bank', bank, false)

