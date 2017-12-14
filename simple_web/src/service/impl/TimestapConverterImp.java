package service.impl;

import java.util.Date;

import service.ITimestapConverter;

public class TimestapConverterImp implements ITimestapConverter{
	
	 @Override
	public Date timestampStringToDate(String unixString) {
		if(unixString!=null) {
		long timestamp = Long.parseLong(unixString.substring(6, unixString.length()-7));
		return new Date(timestamp);
		}
		return null;
	}
	 
	 public void GetData() {}
}
