package service;

import java.sql.Date;

public interface ITimestapConverter {
	public Date timestampStringToDate(String unixString);
}
