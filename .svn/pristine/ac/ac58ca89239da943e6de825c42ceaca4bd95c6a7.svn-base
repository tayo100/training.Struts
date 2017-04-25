package org.iita.trainingunit.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.iita.crm.model.Partner;
import org.iita.crm.model.PartnerPersonContact;
import org.iita.crm.model.Person;
import org.iita.service.impl.XLSImportException;
import org.iita.util.PagedResult;

public interface PartnerPortService {
	<T extends Partner> List<T> previewXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
	IOException, XLSImportException;

	<T extends Object> void importXLSData(List<Object[]> partners, Class<T> clazz, List<Object[]> rowFailedPartnerData);
	
	<T extends PartnerPersonContact> List<T> previewContactsXLSImports(File file, Class<T> clazz, List<Object[]> allXlsRowData) throws FileNotFoundException,
	IOException, XLSImportException;

	<T extends Object> void importContactsXLSData(List<Object[]> contacts, Class<T> clazz, List<Object[]> rowFailedPartnerData);
	
	/**
	 * @param person
	 * @param class
	 */
	<T extends Object> T ensurePartnerExists(Object[] partner, Class<T> clazz, List<Object[]> rowFailedPartnerData);

	PagedResult<Partner> list(int startAt, int maxResults);

	List<Partner> list(Date fromDate, Date toDate);
	List<Partner> list();

	InputStream exportPartnerData(List<Partner> partners) throws IOException;

	Partner getPartnerInfo(Person person);
	Partner getPartnerInfo(Long id);
	
	void addPartner(Partner partner);
	void deletePartner(Partner partner);
	
	PagedResult<Partner> search(String text, int startAt, int maxResults);
	List<Partner> search(String text);
	
	PagedResult<Partner> search(String name, String tag, String org, int startAt, int maxResults);

	List<String> listPartnerCategories();
	List<String> listPartnerClassifications();
	List<String> listPartnerMandateCrops();
	List<String> listHubs();
	List<String> listPartnerCoreBusinesses();
	
	List<String> listPartnerCoreBusinessCategories();
	List<String> listPartnerScales();
	List<String> listPartnerSectors();
}
