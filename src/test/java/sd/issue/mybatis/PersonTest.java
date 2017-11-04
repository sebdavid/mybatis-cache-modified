package sd.issue.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PersonTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private IPersonService personService;
	
	@Autowired
	private PersonMapper personMapper;
	
	
	/**
	 * Scenario:
	 * 0. the object is not in the cache
	 * 1. read and modify from transac. method:
	 *   1.1. start a transaction
	 *   1.2. read the object
	 *   1.3. modify the POJO
	 *   1.4. end the transaction
	 * 2. read the object -> the result is the modified object
	 */
	@Test
	public void objectModifiedTest(){
		
		System.out.println("--- objectModifiedTest ---");
		
		
		System.out.println("Calling transac. get");
		
		Person p1 = personService.transactionalGet(1);
		
		System.out.println("Value after trans. get: "+ p1);

		Assert.assertEquals("ABCD", p1.getFirstName());
		
		
		
		p1 = personMapper.get(1);
		
		System.out.println("Value after mapper get: "+ p1);
		System.out.println();
		
		Assert.assertEquals("Jane", p1.getFirstName());
	}

	/**
	 * Scenario:
	 * 0. the object is not in the cache
	 * 1. read the object
	 * 2. read and modify from transac. method:
	 *   2.1. start a transaction
	 *   2.2. read the object
	 *   2.3. modify the POJO
	 *   2.4. end the transaction
	 * 3. read the object -> the result is the non-modified object
	 */
	@Test
	public void objectNotModifiedTest(){

		System.out.println("--- objectNotModifiedTest ---");

		
		Person p2 = personMapper.get(2);
		System.out.println("Value after mapper get: "+ p2);
		
		Assert.assertEquals("John", p2.getFirstName());
		
		
		System.out.println("Calling transac. get");
		p2 = personService.transactionalGet(2);
		System.out.println("Value after trans. get: "+ p2);
		
		Assert.assertEquals("ABCD", p2.getFirstName());
		
		
		p2 = personMapper.get(2);
		System.out.println("Value after mapper get: "+ p2);
		System.out.println();

		Assert.assertEquals("John", p2.getFirstName());
	}
}
