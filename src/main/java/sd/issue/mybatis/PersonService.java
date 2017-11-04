package sd.issue.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class PersonService implements IPersonService {

	@Autowired
	private PersonMapper mapper;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Person transactionalGet(Integer id) {
		
		Person p = mapper.get(id);
		System.out.println("Object read in service: "+ p);
		
		p.setFirstName("ABCD");
		
		return p;
	}

}
