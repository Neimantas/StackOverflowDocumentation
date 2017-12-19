package service;

import javax.servlet.http.HttpServletRequest;

public interface ICallBackCheck  {
	boolean postbackControl(HttpServletRequest request); 

}
