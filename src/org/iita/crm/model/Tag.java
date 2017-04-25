package org.iita.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Tag entity
 * 
 * @author koraegbunam
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tag {
	private Long id;
	private String tag;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Column(length = 200, nullable=false)
	public String getTag() {
		return tag;
	}
}
