package service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimeUtil {

	static Calendar calendar = Calendar.getInstance(Locale.CHINA);//创建一个日历实例，用的中国当地时间
	  public static String getDate2()                            //同理getDate2()
	  {
		  LocalDate localDate = LocalDate.now(); 
		  DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd "); 		
		  String str = localDate.format(f);		  
		  return str;
	  }
	  public static String getTime2()
	  {
		  StringBuffer str=new StringBuffer();
		  str.append(getDate2()).append("");
		  str.append(addzero((calendar.get(calendar.HOUR)+12)%24, 2)).append(":");
		  str.append(addzero(calendar.get(calendar.MINUTE), 2)).append(":");
		  str.append(addzero(calendar.get(calendar.SECOND), 2)).append("");
		  return str.toString();
	  }
	public static String addzero(int temp,int len)           //此方法用来首位补零
	{
		StringBuffer add=new StringBuffer();
		add.append(temp);
		while(add.length()<len)
		{
			add.insert(0,0);
		}
		return add.toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TimeUtil.getTime2());
	}

}
