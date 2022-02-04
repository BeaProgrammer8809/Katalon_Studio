import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
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

String[] splitInvoiceValue = txtPaidAmount.split('\\.')

println(splitInvoiceValue[0])

println(splitInvoiceValue[1])

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

txtlblTotalPaid = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/totalPaid'), 
    0)

println(txtlblTotalPaid)

float fPaidAmount = Float.parseFloat(txtPaidAmount)

String txtpaidAmount = String.format('%.02f', fPaidAmount)

println(txtpaidAmount)

lblPaidAmount = txtlblTotalPaid.replace('Total Paid : ', '')

println('Total Paid Amt is: ' + lblPaidAmount)

Mobile.verifyMatch(txtpaidAmount, lblPaidAmount, false, FailureHandling.STOP_ON_FAILURE)

float paidMinusValue = 0.1

float fPaidAmount1 = Float.parseFloat(txtPaidAmount) + paidMinusValue

String txtpaidAmount1 = String.format('%.02f', fPaidAmount1)

println(txtpaidAmount1)

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

Mobile.delay(30)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    txtpaidAmount1, 0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

String returntoastmsg1 = driver.findElementByXPath('//android.widget.Toast[1]').getText()

println(returntoastmsg1)

Mobile.verifyMatch('Amount exceeds the balance, please check.', returntoastmsg1, false, FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Inv summary_Invoice rep and pb/Invoice summary/Screenshot'), [('testCaseName') : 'TC_ID_099'], 
    FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i <= lenAmt; i++) {
    Mobile.tap(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/KeyValues/btn_'), 
        i)
}

Mobile.delay(3)

Mobile.setText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Efectivo_CollectionTextbox'), 
    splitInvoiceValue[0], 0)

txtlblBalanceValue = Mobile.getText(findTestObject('Phase 1.1/Resource3/Product Buying/Summary/Delivery Summary/Devlivery Final Summary/Collection/Efectivo/Balance'), 
    0)

println(txtlblBalanceValue)

String[] bSplit = txtlblBalanceValue.split('Balance : ')

String[] bSplit1 = bSplit[1].split(' of ')

println(bSplit1[0])

String[] splitInvoiceValue1 = txtPaidAmount.split('\\.')

println(splitInvoiceValue1[0])

amtlength = splitInvoiceValue1[1].length()

println(amtlength)

if (amtlength == 1) {
    String balanceValue = ('.' + (splitInvoiceValue1[1])) + 0

    println(balanceValue)

    Mobile.verifyMatch(bSplit1[0], balanceValue, false, FailureHandling.STOP_ON_FAILURE)
} else {
    String balanceValue = '.' + (splitInvoiceValue1[1])

    println(balanceValue)

    Mobile.verifyMatch(bSplit1[0], balanceValue, false, FailureHandling.STOP_ON_FAILURE)
}

