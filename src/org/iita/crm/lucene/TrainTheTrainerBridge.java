package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.announcements.model.TrainTheTrainer;

/**
 * @author CNwachukwu
 * 
 */
public class TrainTheTrainerBridge implements FieldBridge  {
	
	/**
	 * @see org.hibernate.search.bridge.FieldBridge#set(java.lang.String, java.lang.Object, org.apache.lucene.document.Document,
	 *      org.apache.lucene.document.Field.Store, org.apache.lucene.document.Field.Index, java.lang.Float)
	 */
	
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		TrainTheTrainer trainer = (TrainTheTrainer) value;
		StringBuffer sb = new StringBuffer(" ");
		sb.append(trainer.getRequestor()).append(" trainingprogram ");
		sb.append(trainer.getUnit()).append(" ");
		sb.append(trainer.getProgramDirector()).append(" ");
		sb.append(trainer.getProjectInformation()).append(" ");
		sb.append(trainer.getCrp()).append(" ");
		
		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}
}