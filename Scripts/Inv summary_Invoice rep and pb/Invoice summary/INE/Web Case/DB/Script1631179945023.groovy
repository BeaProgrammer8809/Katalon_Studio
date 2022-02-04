import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import java.sql.DriverManager as DriverManager
import java.sql.ResultSet as ResultSet
import java.sql.Statement as Statement
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

String url = findTestData('DataBase Credentials/Database Info').getValue(1, 1)

println(url)

String databaseName = findTestData('DataBase Credentials/Database Info').getValue('Database-name', 1)

println(databaseName)

String userName = findTestData('DataBase Credentials/Database Info').getValue('Username', 1)

println(userName)

String passWord = findTestData('DataBase Credentials/Database Info').getValue('Password', 1)

println(passWord)

String conn = (((((('jdbc:sqlserver://' + url) + ';databaseName=') + databaseName) + ';user=') + userName) + ';password=') + 
passWord

println(conn)

connection = DriverManager.getConnection(conn)

Statement stm = connection.createStatement()

String queryString = 'select left(DATENAME(weekday,GETDATE()),3) as Day'

println(queryString)

ResultSet rs = stm.executeQuery(queryString)

def recordSet = rs

String day

while (recordSet.next()) {
    Object currentDay = recordSet.getObject('Day')

    day = currentDay.toString()

    println(day)
}

println('Day is: ' + day)

String parameter1 = ('\'%' + day) + '%\''

println(parameter1)

//Select top(1) * from ADM_Route_Retailer_Mapping where ARRM_ar_Id = 415 and ARRM_Isactive = 1 and ARRM_Visit_Day like '%Mon%'
String queryString2 = ('Select top(1) * from ADM_Route_Retailer_Mapping where ARRM_ar_Id = 415 and ARRM_Isactive = 1 and ARRM_Visit_Day like ' + 
parameter1) + ''

println(queryString2)

ResultSet rs2 = stm.executeQuery(queryString2)

def recordSet2 = rs2

String ARTRId

while (recordSet2.next()) {
    Object artrid1 = recordSet2.getObject('ARRM_ARTR_Id')

    ARTRId = artrid1.toString()

    println(ARTRId)
}

println(ARTRId)

//select  ARTR_Code,ARTR_Name from ADM_Retailer where ARTR_Id=35351 order by 1
String queryString3 = ('select  ARTR_Code,ARTR_Name from ADM_Retailer where ARTR_Id=' + ARTRId) + ' order by 1'

println(queryString3)

ResultSet rs3 = stm.executeQuery(queryString3)

def recordSet3 = rs3

String ArtrCode

String Name

while (recordSet3.next()) {
    Object artrcode = recordSet3.getObject('ARTR_Code')

    ArtrCode = artrcode.toString()

    Object artrName = recordSet3.getObject('ARTR_Name')

    Name = artrName.toString()
}

println('ARTR Code is: ' + ArtrCode)

println('Retailer Name: ' + Name)