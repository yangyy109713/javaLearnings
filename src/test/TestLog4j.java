package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j {
	public static void main(String[] args){
		//Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		Logger log = LogManager.getLogger("mylog");//if not find the mylog from log4j2.xml , then use ROOT_LOGGER_NAME
		log.trace("trace level");
		log.debug("debug level");
		log.info("info level");
		log.warn("warn level");
		log.error("error level");
		log.fatal("fatal level");
		
	}
}
