/**
 * promisCRM.Struts Apr 9, 2010
 */
package org.iita.crm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.iita.crm.model.Document;
import org.iita.crm.model.EntityDocument;

/**
 * @author mobreza
 *
 */
public interface DocumentService {

	/**
	 * @param file
	 * @return
	 */
	Document load(String file);

	/**
	 * @param document
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	File getFile(Document document) throws FileNotFoundException, IOException;

	/**
	 * @param title
	 * @param filePath
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	Document upload(String title, String filePath, File file) throws IOException;

	<T> void upload(EntityDocument<T> entityDocument, String title, File file) throws IOException;
	
	/**
	 * @param id
	 * @return
	 */
	Document findDocument(Long id);

	/**
	 * @param document
	 */
	void remove(Document document);
	
	<T> void remove(EntityDocument<T> entityDocument);

	/**
	 * @param document
	 */
	void update(Document document);

}
