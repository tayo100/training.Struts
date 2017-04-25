/**
 * training.Struts Feb 9, 2010
 */
package org.iita.trainingunit.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.model.Trainee;

/**
 * @author mobreza
 *
 */
public class TraineeBridge  implements FieldBridge {
	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Trainee trainee =  (Trainee) value;
		StringBuffer sb = new StringBuffer();
		sb.append(trainee.getResearchTopic()).append(" trainee ");
		sb.append(trainee.getDegree()).append(" ");
		sb.append(trainee.getDiscipline()).append(" ");
		sb.append(trainee.getLocation()).append(" ");
		sb.append(trainee.getProgram()).append(" ");
		sb.append(trainee.getPerson().getFullName()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}
}
