package dguerrar.test.blueliv.domain;

import java.io.Serializable;

public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 508775345634071727L;
	private String name;
	private String dni;
	private String city;

	public Person(String name, String dni) {
		super();
		this.name = name;
		this.dni = dni;
	}
	
	
	
	public Person(String city) {
		super();
		this.city = city;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (name != null) {
			builder.append(name);
			builder.append(", ");
		}
		if (dni != null) {
			builder.append(dni);
			builder.append(", ");
		}
		if (city != null) {
			builder.append(city);
		}
		builder.append("\n");
		return builder.toString();
	}

	

}
