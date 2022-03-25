package com.ty.keywords

import java.text.DecimalFormat
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import java.text.DecimalFormat as DecimalFormat
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import internal.GlobalVariable as GlobalVariable
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
import com.kms.katalon.core.annotation.Keyword

public class MobileKeywords {



	@Keyword
	public static double taxIVA(double totalSum) {
		def IVA = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 17)
		IVA = Double.parseDouble(IVA)
		DecimalFormat df=new DecimalFormat("0.00")
		'totalSum=totalPrice1 + totalPrice2'
		def tax=totalSum*(IVA/100)
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static double taxIEPS(double totalSum) {
		def IEPS = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 8)
		IEPS = Double.parseDouble(IEPS)
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=totalSum*(IEPS/100)
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static double taxIEPS_IVA(double totalSum) {
		def IEPS = findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 8)
		def IVA = Double.parseDouble(findTestData('Phase2.1/Common_Data/CommonData').getValue(5, 10))
		IEPS = Double.parseDouble(IEPS)
		def IEPSIVA=IEPS+IVA
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=totalSum*(IEPSIVA/100)
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static String taxPercentage(double tax, double totalSum) {
		DecimalFormat df=new DecimalFormat("0")
		def taxPercent=(tax/totalSum)*100
		taxPercent=df.format(taxPercent)
		return (taxPercent)+'%'
	}

	@Keyword
	public static double tax(double totalSum, double value) {
		DecimalFormat df=new DecimalFormat("0.00")
		def tax=value - totalSum
		tax=df.format(tax)
		return Double.parseDouble(tax)
	}

	@Keyword
	public static double value(double totalSum, double tax) {
		DecimalFormat df=new DecimalFormat("0.00")
		'totalSum=totalPrice1 + totalPrice2'
		def value=tax + totalSum
		value=df.format(value)
		return Double.parseDouble(value)
	}

	@Keyword
	public static double itemNil(double GrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10))
		def itemDisc=GrossAmt*(Disc/100)
		itemDisc=df.format(itemDisc)
		return Double.parseDouble(itemDisc)
	}

	@Keyword
	public static double item5_Percent(double GrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 5))
		def itemDisc=GrossAmt*(Disc/100)
		itemDisc=df.format(itemDisc)
		return Double.parseDouble(itemDisc)
	}

	@Keyword
	public static double item10_Percent(double GrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 11))
		def itemDisc=GrossAmt*(Disc/100)
		itemDisc=df.format(itemDisc)
		return Double.parseDouble(itemDisc)
	}

	@Keyword
	public static double categoryNil(double secondGrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 10))
		def catDisc=secondGrossAmt*(Disc/100)
		catDisc=df.format(catDisc)
		return Double.parseDouble(catDisc)
	}

	@Keyword
	public static double category10_Percent(double secondGrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 11))
		def catDisc=secondGrossAmt*(Disc/100)
		catDisc=df.format(catDisc)
		return Double.parseDouble(catDisc)
	}

	@Keyword
	public static double category15_Percent(double secondGrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 16))
		def catDisc=secondGrossAmt*(Disc/100)
		catDisc=df.format(catDisc)
		return Double.parseDouble(catDisc)
	}

	@Keyword
	public static double category20_Percent(double secondGrossAmt)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 21))
		def catDisc=secondGrossAmt*(Disc/100)
		catDisc=df.format(catDisc)
		return Double.parseDouble(catDisc)
	}

	@Keyword
	public static double billDiscount(double totalSum)
	{
		DecimalFormat df=new DecimalFormat("0.00")
		def Disc = Double.parseDouble(findTestData('Phase2/Common_Data/CommonData_03').getValue(5, 11))
		def billDisc=totalSum*(Disc/100)
		billDisc=df.format(billDisc)
		return Double.parseDouble(billDisc)
	}
}