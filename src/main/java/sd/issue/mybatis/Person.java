package sd.issue.mybatis;

import java.io.Serializable;

public class Person implements Serializable{

	/** serial VUID */
	private static final long serialVersionUID = -5731776079455875083L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	/**
	 * Getter for id
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter for firstName
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Setter for firstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Getter for lastName
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Setter for lastName
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return String.format("id=%d - firstName=%s - lastName=%s", id, firstName, lastName);
	}
}
