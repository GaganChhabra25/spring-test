import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import model.Employee;
import repository.CustomerRepository;
import service.CustomerService;

@Slf4j
@ContextConfiguration(classes = {AppConfig.class})
public class TestSpring extends AbstractTestNGSpringContextTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	@Qualifier("defaultCustomerServiceImpl")
	private CustomerService customerService;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Employee employee;

	@Test()
	public void testAutowire() {
		System.out.println("Total Beans  = " + Arrays.asList(applicationContext.getBeanDefinitionNames()));
		assertNotNull(customerRepository);
		assertNotNull(customerService);
	}

	@Test
	public void testQualifier() {
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
		System.out.println("cccccccc = " + customerService.findAll().get(0).getFName());
	}

	@Test(description = "Check scopes of objects")
	public void testObjectScopes() {
		/*->  All objects are having same hashcode.
		->  This means by default : spring will share same object everytime. "SCOPE=SINGLETON"*/

		log.info("Hashcode of customerRepository object  = " + customerRepository.hashCode());
		log.info("Hashcode of customerRepository object  = " + customerRepository.hashCode());
		log.info("Hashcode of customerRepository object  = " + customerRepository.hashCode());
		log.info("Hashcode of customerRepository object  = " + customerRepository.hashCode());
		/*
		 		OUTPUT :
		 		------

				[main] INFO TestSpring - Hashcode of customerRepository object  = 1754662105
				[main] INFO TestSpring - Hashcode of customerRepository object  = 1754662105
				[main] INFO TestSpring - Hashcode of customerRepository object  = 1754662105
				[main] INFO TestSpring - Hashcode of customerRepository object  = 1754662105
		 */
	}

	@Test(description = "To inject values into bean properties using Annotation")
	public void testValueAnnotation() {
		log.info("Employee name : " + employee.getFName());
	}

	@Test
	public void testRequired() {
		log.info("====== Emplyee First name is mandatory. ==================");
		employee.setfName("bbb");
	}
}
