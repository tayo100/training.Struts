package org.iita.trainingunit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.iita.crm.model.Person;
import org.iita.service.impl.XLSImportException;
import org.iita.trainingunit.model.Alumni;
import org.iita.util.PagedResult;

public interface AlumniService {
	<T extends Alumni> List<T> previewXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
	IOException, XLSImportException;

	<T extends Object> void importXLSData(List<Object[]> alumnis, Class<T> clazz, List<Object[]> rowFailedAlumniData);
	
	/**
	 * @param person
	 * @param class
	 */
	<T extends Object> T ensureAlumniExists(Object[] alumni, Class<T> clazz, List<Object[]> rowFailedAlumniData);

	PagedResult<Alumni> list(int startAt, int maxResults);

	List<Alumni> list(Date fromDate, Date toDate);

	InputStream exportAlumniData(List<Alumni> alumnis) throws IOException;

	Alumni getAlumniInfo(Person person);
	Alumni getAlumniInfo(Long id);
	
	void addAlumnus(Alumni alumnus);
	void deleteAlumnus(Alumni alumnus);
	
	PagedResult<Alumni> search(String lastName, String firstName, String topic, String org, Date fromDate, Date toDate, int startAt, int maxResults);
	List<Alumni> search(String lastName, String firstName, String topic, String org, Date fromDate, Date toDate);
	
}
