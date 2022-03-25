import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

siteUrl = findTestData('Login Credentials/Web/Web Login Info').getValue(1, 1)

println(siteUrl)

userName = findTestData('Login Credentials/Web/Web Login Info').getValue(2, 1)

println(userName)

passWord = findTestData('Login Credentials/Web/Web Login Info').getValue(3, 1)

println(passWord)

driverpath = '.\\Drivers\\chromedriver_win32\\chromedriver.exe'

System.setProperty('webdriver.chrome.driver', driverpath)

WebDriver driver = new ChromeDriver()

DriverFactory.changeWebDriver(driver)

driver.manage().window().maximize()

driver.get('http://www.google.com')

WebUI.verifyElementVisible(findTestObject('Login/Web/input_Username'))

WebUI.setText(findTestObject('Login/Web/input_Username'), userName)

WebUI.verifyElementVisible(findTestObject('Login/Web/input__Password'))

WebUI.setEncryptedText(findTestObject('Login/Web/input__Password'), passWord)

WebUI.click(findTestObject('Login/Web/btn_Iogin'))

WebUI.waitForPageLoad(0)


