package org.iita.crm.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.applications.model.IndividualTraining;

public class IndividualBridge implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		IndividualTraining individual = (IndividualTraining) value;
		StringBuffer sb = new StringBuffer();
		//sb.append(individual.getTopic()).append(" individual ");
		//sb.append(individual.getObjectives()).append(" ");

		Field field = new Field(name, sb.toString(), store, index);
		if (boost != null) field.setBoost(boost);
		document.add(field);
	}
}
