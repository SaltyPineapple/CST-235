package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class timerService {
	
	@Resource
	TimerService timer;
	
	
	private static final Logger logger = Logger.getLogger("business.timerService");
	
	public timerService() {
		
	}
	
	public void setTimer(long interval) {
		timer.createTimer(interval, "Setting a programmatic timer");
	}
	
	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("@Timeout programmatic timer at " + new java.util.Date());
	}
	
}
