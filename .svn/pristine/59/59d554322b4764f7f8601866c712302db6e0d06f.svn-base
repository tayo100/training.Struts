package org.iita.trainingunit.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.hibernate.search.bridge.FieldBridge;
import org.iita.trainingunit.model.Department;

public class DepartmentBridge  implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		Department dept =  (Department) value;
		StringBuffer sb = new StringBuffer();
		sb.append(dept.getName()).append(" department ");

		Field field = new Field(name, sb.toString(), store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}

}
