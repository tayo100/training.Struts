/**
 * training.Struts Feb 5, 2010
 */
package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.crm.model.Organization;

/**
 * @author mobreza
 * 
 */
public class OrganizationBridge implements FieldBridge {
	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Organization organization = (Organization) value;
		StringBuffer sb = new StringBuffer();
		sb.append(organization.getTitle()).append(" organization ");
		sb.append(organization.getShortName()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}
}
