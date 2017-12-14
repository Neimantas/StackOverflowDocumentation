package service;

import java.util.Date;

public interface TimestapConverter {
	public Date timestampStringToDate(String unixString);
}
