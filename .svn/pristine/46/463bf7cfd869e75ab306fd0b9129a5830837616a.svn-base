/**
 * 
 */
package org.iita.trainingunit.applications.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.search.annotations.DocumentId;

/**
 * @author ken
 *
 */
@MappedSuperclass
public class BaseEntity {

	private Long id;
	private int version = 0;

	public BaseEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue
	@DocumentId
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the version
	 */
	@Version
	@Column(nullable = false)
	public int getVersion() {
		return version;
	}

}
