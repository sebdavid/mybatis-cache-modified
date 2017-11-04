package sd.issue.mybatis;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Person DAO
 */
@Transactional(propagation=Propagation.SUPPORTS)
public interface PersonMapper {

	Person get(Integer id);
}
