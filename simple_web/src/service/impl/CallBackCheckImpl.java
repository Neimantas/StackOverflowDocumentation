package service.impl;

import javax.servlet.http.HttpServletRequest;

import service.ICallBackCheck;

public class CallBackCheckImpl implements ICallBackCheck{

	@Override
	public boolean postbackControl(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		return (request != null && request.getParameter("postBack") == null 
				|| request != null && request.getParameter("postBack") == "") 
				? false : true;
	
	}

}
