/**
 * training.Struts Feb 4, 2010
 */
package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.crm.model.Person;

/**
 * @author mobreza
 * 
 */
public class PersonBridge implements FieldBridge {

	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Person person = (Person) value;
		StringBuffer sb = new StringBuffer();
		sb.append(person.getLastName()).append(" person ");
		sb.append(person.getFirstName()).append(" ");
		sb.append(person.getOtherNames()).append(" ");
		sb.append(person.getCountry()).append(" ");
		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}

}
