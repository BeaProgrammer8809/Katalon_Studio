import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDate as LocalDate
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.sun.java.swing.plaf.motif.MotifInternalFrameTitlePane.Title as Title
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.AppiumDriver as AppiumDriver

/*Select the  past date */

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BIChequesScreen01/Calendar_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/PreviousMonth_Button'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/1_Date'), 0)

Mobile.tap(findTestObject('Phase2/BICollectionScreen01/BICalenderPopup/OK_button'), 0)

