/**
 * promisCRM.Struts Aug 6, 2010
 */
package org.iita.crm.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.search.annotations.ClassBridge;
import org.hibernate.search.annotations.Indexed;
import org.iita.crm.lucene.DocumentBridge;
import org.iita.entity.SimpleEntity;

/*
 * *
 * 
 * @author mobreza
 */
@Indexed
@MappedSuperclass
@ClassBridge(impl = DocumentBridge.class)
public abstract class EntityDocument<T> extends SimpleEntity {
	private static final long serialVersionUID = -3649405719147362517L;
	private T entity;
	private Document document;

	/**
	 * 
	 */
	public EntityDocument() {

	}

	@ManyToOne(cascade = {}, optional = false)
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	/**
	 * @return the document
	 */
	@ManyToOne(cascade = { javax.persistence.CascadeType.REMOVE }, optional = false)
	@Cascade(CascadeType.DELETE_ORPHAN)
	public Document getDocument() {
		return this.document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
}