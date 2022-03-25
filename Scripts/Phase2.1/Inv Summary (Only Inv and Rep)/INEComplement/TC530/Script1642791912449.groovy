import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement

Mobile.callTestCase(findTestCase('Login/Mobile/Van Seller Login - 4004'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2/VanloadAndOdometer'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.callTestCase(findTestCase('Reusable Cases/Mobile/Phase2.1/Trade_Coverage_ManoharCashInterfacturaOnsiteINE'), [:],
	FailureHandling.STOP_ON_FAILURE)
Mobile.tap(findTestObject('Phase2/BIStoreActivitiesScreen01/Order_and_Invoice_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Search_Edit_Text'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'ProductName', 15), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Pieces_EditText'), 0)

GlobalVariable.Number = findTestData('Phase2.1/Common_Data/CommonData').getValue('Number', 2)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/Number'), 0)

Mobile.tap(findTestObject('Phase2/BINumberKeypad01/OK_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOrderAndInvoiceScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIProductBuyingScreen01/Next_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIInvoiceSummaryScreen/IneComplement_Icon'), 0)

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/INEComplement/Screenshot'), [('testCaseName') : 'TC_530(1)'], 
    FailureHandling.STOP_ON_FAILURE)

GlobalVariable.index = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 2)

GlobalVariable.DropdownName = findTestData('Phase2.1/Common_Data/CommonData').getValue(12, 1)

Mobile.tap(findTestObject('Phase2/BIDropdown/Dropdown_Name_Indexing'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

List dropList = driver.findElementsByXPath('//*[@resource-id="android:id/text1"]')

for (int i = 0; i < dropList.size(); i++) {
    MobileElement listItem = ((dropList.get(i)) as MobileElement)

    def DropdownText = listItem.getText()

    switch (DropdownText) {
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 2):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                   2), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 3):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    3), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 4):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    4), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 5):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    5), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 6):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    6), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 7):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    7), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 8):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    8), false)
			println(DropdownText + "DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 9):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    9), false)

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 10):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    10), false)

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 11):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    11), false)

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 12):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    12), false)

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 13):
            Mobile.verifyMatch(DropdownText, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    13), false)

            break

    }
}

Mobile.scrollToText(findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad',  39))

Mobile.callTestCase(findTestCase('Phase2.1/Inv Summary (Only Inv and Rep)/INEComplement/Screenshot'), [('testCaseName') : 'TC_530(2)'],
	FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5)

LinkedHashSet<String> dropList2 = new LinkedHashSet<String>();

dropList2 = driver.findElementsByXPath('//*[@resource-id="android:id/text1"]')

println(dropList2.size())

 for (int i = 0; i < dropList2.size(); i++) {
//	 String[] drplist2 = dropList2.toArray(new String[dropList2.size()]);
	 
	 MobileElement  listItem = ((dropList2[i]) as MobileElement)
 
	 def DropdownText1 = listItem.getText()
 
	 switch (DropdownText1) {
		 case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 35):
            Mobile.verifyMatch(DropdownText1, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    35), false)
			
			println(DropdownText1 + "   DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 36):
            Mobile.verifyMatch(DropdownText1, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    36), false)
			
			println(DropdownText1 + "   DropdownText")

            break
        case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 37):
            Mobile.verifyMatch(DropdownText1, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 
                    37), false)
			
			println(DropdownText1+ "   DropdownText")

            break
		case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 38):
			Mobile.verifyMatch(DropdownText1, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad',
					38), false)
			
			println(DropdownText1+ "   DropdownText")

			break
		case findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad', 39):
			Mobile.verifyMatch(DropdownText1, findTestData('Phase2.1/Common_Data/CommonData').getValue('INE_ClaveEntidad',
					39), false)
			
			println(DropdownText1+ "   DropdownText")

			break
    }
}


Mobile.closeApplication()

