package org.iita.trainingunit.model;

import javax.persistence.Entity;

import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.entity.VersionedEntity;


@Entity
@Indexed
@ClassBridge(impl = org.iita.trainingunit.lucene.DepartmentBridge.class)
public class Department extends VersionedEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5403387403711065760L;
	private String name;
	
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
