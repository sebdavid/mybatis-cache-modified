package sd.issue.mybatis;


/**
 * Service exposing business methods
 */
public interface IPersonService {

	/**
	 * Get a person
	 * @param id
	 * @return
	 */
	Person transactionalGet(Integer id);
}
