package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.announcements.model.Announcement;


/**
 * @author KOraegbunam
 * 
 */

public class AnnouncementBridge implements FieldBridge {
	
	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Announcement announcement = (Announcement) value;
		StringBuffer sb = new StringBuffer();
		sb.append(announcement.getTitle()).append(" cdo-announcement ");
		sb.append(announcement.getObjective()).append(" ");
		sb.append(announcement.getTargetGroup()).append(" ");
		sb.append(announcement.getLearningMethod()).append(" ");
		sb.append(announcement.getExpectedOutcome()).append(" ");
		sb.append(announcement.getCourseContents()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}
}
