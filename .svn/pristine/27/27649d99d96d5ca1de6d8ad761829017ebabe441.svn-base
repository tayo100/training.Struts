package org.iita.crm.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Generic entity tag
 * 
 * @author mobreza
 * @param <T>
 */
@MappedSuperclass
public class EntityTag<T> extends Tag {
	private T entity;
	private Double percentage;

	@ManyToOne(cascade = {}, optional = false)
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
}
