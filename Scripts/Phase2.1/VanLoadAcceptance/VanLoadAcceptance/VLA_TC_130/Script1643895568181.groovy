import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

Mobile.callTestCase(findTestCase('Login/Mobile/Bimbo_Login'), [('username') : findTestData('Login Credentials/Mobile/Login Info').getValue(
            1, 4), ('password') : findTestData('Login Credentials/Mobile/Login Info').getValue(2, 4)], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 10, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0, FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 2, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.waitForElementPresent(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 2)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Odometer_Button'), 0)

Mobile.setText(findTestObject('Phase2/BIOdometer01/Start_Trip_Reading_EditText'), findTestData('Phase2.1/Common_Data/CommonData').getValue(
        'OdometerReading', 1), 0)

Mobile.tap(findTestObject('Phase2/BIOdometer01/Start_Journey_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIOdometer01/OK_Button'), 0)

AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

if (Mobile.verifyElementExist(findTestObject('Phase2/BIVanloadAcceptance01/Checkbox'), 0, FailureHandling.OPTIONAL)) {
    checkboxes = driver.findElementsByClassName('android.widget.CheckBox')

    List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

    def Expected_Size = findTestData('Phase2.1/CommonData/CommonData').getValue(5, 1)

    def Actual_size = elements.size()
	
	println(Actual_size)
    
	println('The size of elements is ::' + elements.size())

    Mobile.verifyGreaterThan(Actual_size, Expected_Size, FailureHandling.STOP_ON_FAILURE)
	
	println('User is able to accept multiple vanload')
	
    //for (int i = 0; i < size; i++) {
    for (int i = 0; i < Actual_size; i++) {
        elements.get(i).click()

        Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

        Mobile.verifyElementAttributeValue(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 'enabled', findTestData(
                'Phase2.1/TY_04/Phase2.1_Sheet3').getValue(18, 119), 0)

        Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 0, FailureHandling.STOP_ON_FAILURE)

        def Actual_Toast_Message = driver.findElementByXPath('//android.widget.Toast[1]').getText()

        println('Actual_Toast_Message')

        def Expected_Toast_Message = findTestData('Phase2.1/TY_04/Phase2.1_Sheet3').getValue(5, 120)

        println(Actual_Toast_Message)

        Mobile.verifyMatch(Actual_Toast_Message, Expected_Toast_Message, false, FailureHandling.STOP_ON_FAILURE) //Mobile.verifyElementExist(findTestObject('Object Repository/Phase2/BIVanloadAcceptance01/Vanload Acceptance_TextView'),0, FailureHandling.STOP_ON_FAILURE)

    }
}

Mobile.callTestCase(findTestCase('Phase2.1/VanLoadAcceptance/VanLoadAcceptance/Screenshot'), [('testCaseName') : 'VLA_TC_130'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.closeApplication()