package service.converter;

import java.util.Date;

public class TimestapConverter {
	public Date timestampStringToDate(String unixString) {
		if(unixString!=null) {
		long timestamp = Long.parseLong(unixString.substring(6, unixString.length()-7));
		return new Date(timestamp);
		}
		return null;
	}
}
