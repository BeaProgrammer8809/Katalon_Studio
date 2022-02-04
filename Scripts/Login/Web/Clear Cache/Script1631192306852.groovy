import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import java.awt.AWTException as AWTException
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

siteUrl = 'http://bimbo-mexico-qa-03.ivycpg.com/webapi/api/help/index2'

println(siteUrl)

driverpath = '.\\Drivers\\chromedriver_win32\\chromedriver.exe'

System.setProperty('webdriver.chrome.driver', driverpath)

WebDriver driver = new ChromeDriver()

DriverFactory.changeWebDriver(driver)

driver.manage().window().maximize()

driver.get(siteUrl)

WebUI.waitForElementPresent(findTestObject('Login/Web/Clear Cache/btn_Clear Cache'), 0)

WebUI.verifyElementVisible(findTestObject('Login/Web/Clear Cache/btn_Clear Cache'))

for (int i = 0; i <= 3; i++) {
    WebUI.click(findTestObject('Login/Web/Clear Cache/btn_Clear Cache'))

    Robot robot = new Robot()

    robot.keyPress(KeyEvent.VK_ENTER)
}

