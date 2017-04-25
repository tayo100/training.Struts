/**
 * training.Struts Feb 4, 2010
 */
package org.iita.crm.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.hibernate.search.bridge.FieldBridge;

/**
 * @author mobreza
 * 
 */
public class DocumentBridge<T> implements FieldBridge {
	@SuppressWarnings("unchecked")
	@Override
	public void set(String name, Object value, Document document, Store store, Index index, Float boost) {
		org.iita.crm.model.EntityDocument<T> doc = (org.iita.crm.model.EntityDocument<T>) value;

		String parsedString = "";
		if (doc.getDocument().getFile() != null) {
			File file = new File(doc.getDocument().getFile());
			if (file != null && file.exists()) {
				Tika tika = new Tika();
				tika.setMaxStringLength(200000);
				try {
					parsedString = tika.parseToString(file);
					//System.err.println(parsedString);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (TikaException e) {
					e.printStackTrace();
				}
			}
		}
		Field field = new Field(name, doc.getDocument().getTitle() + " " + parsedString, store, index);

		if (boost != null)
			field.setBoost(boost);

		document.add(field);
	}

}
