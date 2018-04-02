package ftnt.qa.autotest.ui.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		String time = formatter.format(date);
		return time;
	}
	
}
