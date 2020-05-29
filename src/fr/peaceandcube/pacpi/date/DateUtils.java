package fr.peaceandcube.pacpi.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(date);
	}
	
	public static String getCurrentMonthDay() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM");
		return format.format(date);
	}
	
	public static String getCurrentYearDay() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		return format.format(date);
	}
}
