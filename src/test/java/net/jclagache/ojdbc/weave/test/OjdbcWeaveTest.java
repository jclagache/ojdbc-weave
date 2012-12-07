package net.jclagache.ojdbc.weave.test;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.sql.DataSource;

import net.jclagache.ojdbc.weave.test.config.OjdbcWeaveTestConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={OjdbcWeaveTestConfig.class})
public class OjdbcWeaveTest {
		
	private JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testBeforeCreateStatement() {
		ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
		final Appender mockAppender = mock(Appender.class);
	    when(mockAppender.getName()).thenReturn("MOCK");
	    root.addAppender(mockAppender);
	    
		template.execute("select * from dual");
		
		verify(mockAppender).doAppend(argThat(new ArgumentMatcher() {
		      @Override
		      public boolean matches(final Object argument) {
		        return ((LoggingEvent)argument).getFormattedMessage().contains("before creating statement");
		      }
		    }));
	}
}
