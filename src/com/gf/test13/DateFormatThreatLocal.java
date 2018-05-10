package com.gf.test13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreatLocal {

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd");
		};
	};
	
	public static Date convert(String source) throws Exception{
		return df.get().parse(source);
	}
	
}
