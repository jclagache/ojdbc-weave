package net.jclagache.ojdbc.weave.test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class OjdbcWeaveTestLoggingAspect {
	
	final Logger logger = LoggerFactory.getLogger(OjdbcWeaveTestLoggingAspect.class);
	
	@Before("call(* java.sql.Connection.createStatement(..))")
	public void beforeCreatingStatement() {
		logger.debug("before creating statement");
	}
}
