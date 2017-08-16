package com.mmtc.springboot;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import com.mmtc.springboot.model.User;
import com.mmtc.springboot.restclient.RestAPIAdapter;

public class AuthenticationInterceptor implements org.springframework.web.servlet.HandlerInterceptor{

	
	final static Logger logger = Logger.getLogger(AuthenticationInterceptor.class);

	
	@Autowired
	private RestAPIAdapter restAPIAdapter;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		logger.info("SessionID :" + session.getId());
		
		String uri = request.getRequestURI();
		String contextName = request.getContextPath();
		if (!uri.endsWith(contextName + "/") && !uri.endsWith(contextName + "/exelogin")  && !uri.endsWith(contextName + "/pagelogin") ) {
			//Date dt = new Date(System.currentTimeMillis() + 5 * 60 * 1000); // 5 * 60 // secons = 300 * 1000 // millisecons
			
			User userData = (User) request.getSession().getAttribute(AppConstatnts.LOGGEDIN_USER);
			Date sessionLsat  = (Date) request.getSession().getAttribute(AppConstatnts.LAST_SESSION_ACCESSED_TIME);
			if(sessionLsat.getTime() < System.currentTimeMillis()){
				//send request to refresh token. to renew the access token.
				//restAPIAdapter.signIn();
			}
		
			if (userData == null) {
				response.sendRedirect(contextName + "/pagelogin");
				return false;
			}
			else
			{
				logger.info("Last accessed session time : " + session.getLastAccessedTime() + " @ SessionID :" + session.getId());
				logger.info("remaining time : " + (System.currentTimeMillis() - session.getLastAccessedTime()));
			} 
		}
		if(uri.equals(contextName + "/exelogin")){
			try {
				restAPIAdapter.signIn();
				return true;
			} catch (Exception e) {
				response.sendRedirect(contextName + "/pagelogin");				
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
