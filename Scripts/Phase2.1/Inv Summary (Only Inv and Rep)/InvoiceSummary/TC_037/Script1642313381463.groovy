import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4003'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Unload_Button'), 0)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 1)

Mobile.setText(findTestObject('Phase2/BIUnload/Salable/OP_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(16, 
        53), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_037_1st_set_digit'],
	FailureHandling.STOP_ON_FAILURE)

def OPAmt = Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

println(OPAmt.length())

for (int i = 0; i < OPAmt.length(); i++) {
	Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

println('0123 number are clickable')

Mobile.setText(findTestObject('Phase2/BIUnload/Salable/OP_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(17,
	53), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_037_2nd_set_digit'],
	FailureHandling.STOP_ON_FAILURE)

def OPAmt1 = Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

println(OPAmt1.length())

for (int i = 0; i < OPAmt1.length(); i++) {
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

println('456 number are clickable')

Mobile.setText(findTestObject('Phase2/BIUnload/Salable/OP_Indexing'), findTestData('Phase2.1/TY_04/Phase2.1').getValue(18,
	53), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_037_3rd_set_digit'],
	FailureHandling.STOP_ON_FAILURE)

def OPAmt2 = Mobile.getText(findTestObject('Object Repository/Phase2/BIUnload/Salable/OP_Indexing'), 0)

println(OPAmt2.length())

for (int i = 0; i < OPAmt2.length(); i++) {
Mobile.tap(findTestObject('Phase2/BINumberKeyboardCollection01/BackSpace_NumButton'), 0)
}

println('789 number are clickable')

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/InvoiceSummary/Screenshot'), [('testCaseName') : 'TC_037'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()