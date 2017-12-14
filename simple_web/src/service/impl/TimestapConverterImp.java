package service.impl;

import java.util.Date;

import service.TimestapConverter;

public class TimestapConverterImp implements TimestapConverter{
	
	 @Override
	public Date timestampStringToDate(String unixString) {
		if(unixString!=null) {
		long timestamp = Long.parseLong(unixString.substring(6, unixString.length()-7));
		return new Date(timestamp);
		}
		return null;
	}
}
