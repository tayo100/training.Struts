/**
 * training.Struts Feb 4, 2010
 */
package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.crm.model.Contact;

/**
 * @author mobreza
 * 
 */
public class ContactBridge implements FieldBridge {
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Contact contact = (Contact) value;

		Field field = new Field(name, contact.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}

}
