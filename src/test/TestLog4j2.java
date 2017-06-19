package test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;


public class TestLog4j2 {
	/*
	 * ģ���ļ��������10M��ʱ�䳬��1������֤logger���
	 */
	public static void main(String[] args) throws IOException{
		/*
		 * �Զ���log4j2.xml�����ļ�λ��
		 */
		/*File file = new File("e:/yangyy/log4j2.xml");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		final ConfigurationSource source = new ConfigurationSource(in);
		Configurator.initialize(null , source);*/
		
		Logger log = LogManager.getLogger("mylog");
		for(int i = 0 ; i < 50000 ; i++){
			log.trace("trace level");
			log.debug("debug level");
			log.info("info level");
			log.warn("warn level");
			log.error("error level");
			log.fatal("fatal level");
			log.info("It is the " + (i + 1) + " iterator !");
		}
		try{
			Thread.sleep(1000 * 61);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		log.trace("trace level");
		log.debug("debug level");
		log.info("info level");
		log.warn("warn level");
		log.error("error level");
		log.fatal("fatal level");
	}
}
