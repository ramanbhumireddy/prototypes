package com.mmtc.springboot;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {
	
	final static Logger logger = Logger.getLogger(SessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.info("==== Session is created ====");
		HttpSession session = event.getSession();
		session.setMaxInactiveInterval(5 * 60);  //seconds 60 = 1 min  // here total 5 mins
		logger.info("SessionID :" + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("==== Session is destroyed ====");
	}
	
	public void registSesionListener(){
		//servletContext.
	}
}


//public class WebSessionListener implements ApplicationListener<ApplicationEvent> {
//    
//    private static final Logger LOG = Logger.getLogger(WebSessionListener.class);
// 
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        
//        if(applicationEvent instanceof HttpSessionCreatedEvent){ //If event is a session created event
// 
//           HttpSession httpSession = httpSessionDestroyedEvent.getSession(); //get session object
//           String sessionId = httpSession.getId(); //get session id
//           ....
//           persistSessionData(sessionId); //save session data to DB
//           LOG.debug(" Session is invalidated |SESSION_ID :" + sessionId ); //log data
//         
//        }else if(applicationEvent instanceof HttpSessionDestroyedEvent){ //If event is a session destroy event
//           ...
//        }else{
//           ...
//        }
//    }
//}