package service.converter;

import java.util.Date;

public class TimestapConverter {
	public Date timestampStringToDate(String unixString) {
		long timestamp = Long.parseLong(unixString.substring(8, unixString.length()-8));
		return new Date(timestamp);
	}
}
