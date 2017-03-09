import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import service.CustomerService;

@Slf4j
@ContextConfiguration(classes = {AppConfig.class})
public class TestApplication extends AbstractTestNGSpringContextTests {

	@Autowired(required = true)
	private CustomerService customerService;

	@Autowired
	private ApplicationContext context;

	@Test
	public void testApplication() {
		assertNotNull(customerService);
		assertNull(context);

		log.info("Customer service object loaded form application context " + context.getBean(CustomerService.class));
		log.info("Customer information = = " + customerService
				.findAll()
				.get(0)
				.getFName());
	}
}