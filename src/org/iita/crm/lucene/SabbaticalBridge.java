package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.applications.model.SabbaticalTraining;


public class SabbaticalBridge implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		SabbaticalTraining sabbatical = (SabbaticalTraining) value;
		StringBuffer sb = new StringBuffer();
		//sb.append(sabbatical.getTopic()).append(" sabbatical ");
		//sb.append(sabbatical.getObjectives()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);
		if (boost != null) field.setBoost(boost);
		document.add(field);
	}
}
