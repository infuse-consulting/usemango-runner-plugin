package it.infuse.jenkins.usemango.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class Project extends GenericJson {

	@Key("Id")
	private String id;

	@Key("Name")
	private String name;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Project)) {
			return false;
		}
		return super.equals(o) && ((Project) o).name.equalsIgnoreCase(name);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
