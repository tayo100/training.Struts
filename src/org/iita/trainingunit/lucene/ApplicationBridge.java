package org.iita.trainingunit.lucene;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.applications.model.Application;

/**
 * @author koraegbunam
 */
public class ApplicationBridge implements FieldBridge {

	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Application app = (Application) value;
		StringBuffer sb = new StringBuffer();
		if (app.getRefNumber() != null) {
			Matcher m = Pattern.compile("\\w\\w\\-(\\d+)").matcher(app.getRefNumber());
			if (m.find())
				sb.append(Integer.parseInt(m.group(1))).append(" ");
		}
		
		sb.append(app.getRefNumber()).append(" ");
		sb.append(app.getBiodata().getFullName()).append(" ");
		sb.append(app.getBiodata().getOwner().getFullName()).append(" ");
		sb.append(app.getAnnouncement().getTitle()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);

		if (!app.isRejected())
			field.setBoost(0.5f + boost);
		else
			field.setBoost(boost);

		document.add(field);
	}

}
