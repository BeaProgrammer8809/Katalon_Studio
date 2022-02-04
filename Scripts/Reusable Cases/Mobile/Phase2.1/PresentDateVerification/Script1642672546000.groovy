import java.text.SimpleDateFormat

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

SimpleDateFormat formatter = new SimpleDateFormat('dd-MM-yyyy')

Date date = new Date()

def PresentDate = formatter.format(date)

println(PresentDate)

def DateinCollection = CollectionDate

KeywordLogger log = new KeywordLogger()

Date date1 = formatter.parse(PresentDate)

Date date2 = formatter.parse(DateinCollection)

if (date1.equals(date2)) 
{
	
	println  (date2 + " ====  Selected date is Present Date")
}

if (date1.after(date2)) {
        
	    KeywordUtil.markFailed(date2 + " ======Selected date is Past Date")
	    
		log.logFailed()
		
		println(date2 + " ======Selected date is Past Date");
}

if (date1.before(date2)) 
{
	KeywordUtil.markFailed(date2 + " =========Selected date is future Date")
	
	log.logFailed()
	
	println(date2 + " =========Selected date is future Date")
}

