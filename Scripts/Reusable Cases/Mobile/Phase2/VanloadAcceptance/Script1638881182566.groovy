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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import org.openqa.selenium.WebElement as WebElement

//add wait statement for hamburgur icon
AppiumDriver driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Phase2/BIKPIDashboard01/Hamburger_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIHamburger01/Start_Of_The_Day_Button'), 0)

Mobile.tap(findTestObject('Phase2/BIStartOfTheDay01/Vanload_Acceptance_Button'), 0)

//need to add the code for click on hamburgur ico and click on startof the day and click on vanload acceptance
if (Mobile.verifyElementExist(findTestObject('Phase2/BIVanloadAcceptance01/Checkbox'), 0, FailureHandling.OPTIONAL)) {
    checkboxes = driver.findElementsByClassName('android.widget.CheckBox')

    List<WebElement> elements = driver.findElementsByClassName('android.widget.CheckBox')

    def size = elements.size()

    println('The size of elements is ::' + elements.size())

    for (int i = 0; i < size; i++) {
        elements.get(i).click()

        Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Submit_Button'), 0, FailureHandling.OPTIONAL)
		
        Mobile.delay(1, FailureHandling.STOP_ON_FAILURE)
    }
    
    Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)
} else {
    Mobile.tap(findTestObject('Phase2/BIVanloadAcceptance01/Back_Button'), 0)
}


